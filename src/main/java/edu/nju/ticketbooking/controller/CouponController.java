package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.Coupon;
import edu.nju.ticketbooking.service.CouponServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponController {

    @Autowired
    private CouponServ couponServ;

    @GetMapping(value = "/coupon")
    public List<Coupon> getUserCouponList(@RequestParam(value = "userId") int userId) {
        return couponServ.getUserCouponList(userId);
    }

    @PostMapping(value = "/coupon")
    public Coupon acquireCoupon(
            @RequestParam(value = "userId") int userId,
            @RequestParam(value = "couponTypeId") int couponTypeId
    ) {
        return couponServ.acquireCoupon(userId, couponTypeId);
    }

}
