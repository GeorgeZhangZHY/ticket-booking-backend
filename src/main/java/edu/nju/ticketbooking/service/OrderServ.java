package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Order;

import java.util.List;

public interface OrderServ {

    List<Order> getUserOrderList(int userId);

    List<Order> getVenueOrderList(int venueId);

    Order addNewOrder(Order newOrder);

    boolean payOrder(int orderId);

    void cancelOrder(int orderId);

    void completeOrder(int orderId);

}
