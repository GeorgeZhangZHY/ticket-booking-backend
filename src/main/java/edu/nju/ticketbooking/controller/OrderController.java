package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.Order;
import edu.nju.ticketbooking.service.OrderServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServ orderServ;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> getOrderList(@RequestParam(value = "userId") String userId) {
        return orderServ.getUserOrderList(Integer.parseInt(userId));
    }
}
