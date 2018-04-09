package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.Order;
import edu.nju.ticketbooking.service.OrderServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServ orderServ;

    @GetMapping(value = "/order")
    public List<Order> getOrderList(@RequestParam(value = "userId") int userId) {
        return orderServ.getUserOrderList(userId);
    }

    @GetMapping(value = "/order/venue")
    List<Order> getVenueOrderList(@RequestParam(value = "venueId") int venueId) {
        return orderServ.getVenueOrderList(venueId);
    }

    @PostMapping(value = "/order")
    public Order addNewOrder(@RequestBody Order order) {
        return orderServ.addNewOrder(order);
    }

    @PutMapping(value = "/order/pay")
    public boolean payOrder(@RequestParam(value = "orderId") int orderId) {
        return orderServ.payOrder(orderId);
    }

    @PutMapping(value = "/order/cancel")
    public void cancelOrder(@RequestParam(value = "orderId") int orderId) {
        orderServ.cancelOrder(orderId);
    }
}
