package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.constant.OrderState;
import edu.nju.ticketbooking.dao.OrderDao;
import edu.nju.ticketbooking.dao.UserDao;
import edu.nju.ticketbooking.model.Order;
import edu.nju.ticketbooking.model.Ticket;
import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.service.OrderServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServImpl implements OrderServ {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    private double calcOrderPrice(Order order) {
        List<Ticket> tickets = order.getTickets();
        double totalTicketPrice = 0;
        for (Ticket ticket : tickets) {
            totalTicketPrice += ticket.getPrice();
        }
        double couponPrice = order.getCoupon().getCouponType().getPrice();
        double userDiscount = getUserLevelDiscount(userDao.getUser(order.getUserId()).getLevel());
        return (totalTicketPrice - couponPrice) * userDiscount;
    }

    private double getUserLevelDiscount(int userLevel) {
        double discountIncrement = 0.03;
        return 1.0 - (userLevel - 1) * discountIncrement;
    }

    @Override
    public List<Order> getUserOrderList(int userId) {
        return orderDao.getUserOrderList(userId);
    }

    @Override
    public Order addNewOrder(Order order) {
        order.setTotalPrice(calcOrderPrice(order));
        return orderDao.addNewOrder(order);
    }

    @Override
    public void payOrder(int orderId) {
        Order order = orderDao.getOrder(orderId);
        User user = userDao.getUser(order.getUserId());
        double balance = user.getBalance(),
                priceToPay = order.getTotalPrice(),
                scoreToAdd = priceToPay / 10;
        balance -= priceToPay;
        if (balance >= 0) {
            user.setBalance(balance);
            user.setScore(user.getScore() + scoreToAdd);
            order.setState(OrderState.PAID);
        }
    }

    @Override
    public void cancelOrder(int orderId) {
        Order order = orderDao.getOrder(orderId);
        if (order.getState() == OrderState.UNPAID) {
            order.setState(OrderState.CANCELED);
            orderDao.modifyOrder(order);
        }
    }
}
