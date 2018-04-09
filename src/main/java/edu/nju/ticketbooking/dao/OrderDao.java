package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getUserOrderList(int userId);

    Order addNewOrder(Order newOrder);

    Order modifyOrder(Order modifiedOrder);

    Order getOrder(int orderId);

    List<Order> getEventOrderList(int eventId);

    List<Order> getAllOrderList();
}
