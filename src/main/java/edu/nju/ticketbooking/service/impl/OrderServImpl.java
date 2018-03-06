package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.constant.OrderState;
import edu.nju.ticketbooking.dao.OrderDao;
import edu.nju.ticketbooking.model.Order;
import edu.nju.ticketbooking.service.OrderServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServImpl implements OrderServ {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getUserOrderList(int userId) {
        return orderDao.getUserOrderList(userId);
    }

    @Override
    public Order addNewOrder(Order order) {
        return orderDao.addNewOrder(order);
    }

    @Override
    public void payOrder(int orderId) {
        Order order = orderDao.getOrder(orderId);
        order.setState(OrderState.PAID);
        // todo pay

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
