package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.constant.OrderState;
import edu.nju.ticketbooking.dao.OrderDao;
import edu.nju.ticketbooking.model.Order;
import edu.nju.ticketbooking.model.Ticket;
import edu.nju.ticketbooking.service.OrderServ;
import edu.nju.ticketbooking.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServImpl implements OrderServ {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserServ userServ;

    /**
     * 自动取消15分钟内未支付的订单
     */
    private void cancelExpiredUnpaidOrder(Order order) {
        if (order.getState() == OrderState.UNPAID) {
            long timePassed = System.currentTimeMillis() - order.getCreateTime().getTime();
            int minutesPassed = (int) timePassed / (1000 * 60);
            if (minutesPassed >= 15) {
                order.setState(OrderState.CANCELED);
                orderDao.modifyOrder(order);
            }
        }
    }

    /**
     * 将已经举行的活动对应的订单设为已完成
     * 同时为用户增加积分
     */
    private void completePaidOrder(Order order) {
        if (order.getState() == OrderState.PAID) {
            order.setState(OrderState.COMPLETED);
            double scoreToAdd = order.getTotalPrice() / 10;
            userServ.modifyScore(order.getUserId(), scoreToAdd, true);
            orderDao.modifyOrder(order);
        }
    }

    private double calcOrderPrice(Order order) {
        List<Ticket> tickets = order.getTickets();
        double totalTicketPrice = 0;
        for (Ticket ticket : tickets) {
            totalTicketPrice += ticket.getPrice();
        }
        double couponPrice = order.getCoupon().getCouponType().getPrice();
        double userDiscount = userServ.getUserLevelDiscount(order.getUserId());
        return (totalTicketPrice - couponPrice) * userDiscount;
    }

    private List<Order> processOrders(List<Order> orders) {
        for (Order order : orders) {
            cancelExpiredUnpaidOrder(order);
            completePaidOrder(order);
        }
        return orders;
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
        List<Order> orders = orderDao.getUserOrderList(userId);
        return processOrders(orders);
    }

    @Override
    public Order addNewOrder(Order newOrder) {
        newOrder.setTotalPrice(calcOrderPrice(newOrder));
        return orderDao.addNewOrder(newOrder);
    }

    @Override
    public boolean payOrder(int orderId) {
        Order order = orderDao.getOrder(orderId);
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
            if (prevState == OrderState.PAID) {
                // 退款
                double refund = calcRefund(order);
                userServ.modifyBalance(order.getUserId(), refund);
            }
            orderDao.modifyOrder(order);
        }
    }
}
