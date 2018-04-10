package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.constant.EventFilterType;
import edu.nju.ticketbooking.constant.OrderState;
import edu.nju.ticketbooking.constant.TicketState;
import edu.nju.ticketbooking.dao.OrderDao;
import edu.nju.ticketbooking.model.*;
import edu.nju.ticketbooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OrderServImpl implements OrderServ {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserServ userServ;

    @Autowired
    private CouponServ couponServ;

    @Autowired
    private TicketServ ticketServ;

    @Autowired
    private EventServ eventServ;

    /**
     * 自动取消15分钟内未支付的订单
     * 每10秒运行一次
     */
    @Scheduled(fixedRate = 10 * 1000)
    private void cancelExpiredUnpaidOrder() {
        System.out.println("Running: cancelExpiredUnpaidOrder");
        for (Order order : orderDao.getAllOrderList()) {
            if (order.getState() == OrderState.UNPAID) {
                long timePassed = System.currentTimeMillis() - order.getCreateTime().getTime();
                int minutesPassed = (int) timePassed / (1000 * 60);
                if (minutesPassed >= 15) {
                    cancelOrder(order.getOrderId());
                }
            }
        }
    }

    private double calcOrderPrice(Order order) {
        Set<Ticket> tickets = order.getTickets();
        double totalTicketPrice = 0;
        for (Ticket ticket : tickets) {
            totalTicketPrice += ticket.getPrice();
        }
        Coupon coupon = order.getCoupon();
        double couponPrice = 0;
        if (coupon != null) {
            couponPrice = coupon.getCouponType().getPrice();
        }
        double userDiscount = userServ.getUserLevelDiscount(order.getUserId());
        return (totalTicketPrice - couponPrice) * userDiscount;
    }

    /**
     * 离活动时间越近，退款越少
     * 6天及以上退100%，4~6天80%，2~4天60%，2天以内40%
     */
    private double calcRefund(Order order) {
        Timestamp eventTime = order.getEvent().getHostTime(),
                orderTime = order.getCreateTime();
        long timeLeft = eventTime.getTime() - orderTime.getTime();
        int daysLeft = (int) timeLeft / (1000 * 60 * 60 * 24);
        double percentage = Math.min(daysLeft / 2 * 0.2 + 0.4, 1);
        return order.getTotalPrice() * percentage;
    }

    @Override
    public List<Order> getUserOrderList(int userId) {
        return orderDao.getUserOrderList(userId);
    }

    @Override
    public List<Order> getVenueOrderList(int venueId) {
        List<Event> venueEventList = eventServ.getEventList(new EventFilter(
                EventFilterType.VENUE,
                venueId,
                0,
                Integer.MAX_VALUE,
                new Timestamp(0),
                new Timestamp(System.currentTimeMillis())
        ));
        List<Order> orderList = new ArrayList<>();
        for (Event event : venueEventList) {
            orderList.addAll(orderDao.getEventOrderList(event.getEventId()));
        }
        return orderList;
    }

    @Override
    public Order addNewOrder(Order newOrder) {
        newOrder.setTotalPrice(calcOrderPrice(newOrder));
        Coupon coupon = newOrder.getCoupon();
        if (coupon != null) {
            couponServ.setCouponUsed(coupon.getCouponId(), true);
        }
        return orderDao.addNewOrder(newOrder);
    }

    @Override
    public boolean payOrder(int orderId) {
        Order order = orderDao.getOrder(orderId);
        if (order.getState() != OrderState.UNPAID) {
            return false;
        }

        int userId = order.getUserId();
        double priceToPay = order.getTotalPrice();

        if (userServ.modifyBalance(userId, -priceToPay)) {
            order.setState(OrderState.PAID);
            orderDao.modifyOrder(order);
            return true;
        }
        return false;
    }

    @Override
    public void cancelOrder(int orderId) {
        Order order = orderDao.getOrder(orderId);
        OrderState prevState = order.getState();
        if (prevState == OrderState.PAID || prevState == OrderState.UNPAID) {
            order.setState(OrderState.CANCELED);
            // 取消订票记录
            Set<Ticket> tickets = order.getTickets();
            for (Ticket ticket : tickets) {
                ticket.setTicketState(TicketState.CANCELED);
                ticketServ.modifyTicket(ticket);
            }

            if (prevState == OrderState.PAID) {
                // 退款
                double refund = calcRefund(order);
                userServ.modifyBalance(order.getUserId(), refund);
            }
            orderDao.modifyOrder(order);

            // 退还优惠券
            Coupon coupon = order.getCoupon();
            if (coupon != null) {
                couponServ.setCouponUsed(coupon.getCouponId(), false);
            }
        }
    }

    @Override
    public void completeOrder(int orderId) {
        Order order = orderDao.getOrder(orderId);
        if (order.getState() == OrderState.PAID) {
            order.setState(OrderState.COMPLETED);
            double scoreToAdd = order.getTotalPrice() / 10;
            userServ.modifyScore(order.getUserId(), scoreToAdd, true);
            orderDao.modifyOrder(order);
        }
    }
}
