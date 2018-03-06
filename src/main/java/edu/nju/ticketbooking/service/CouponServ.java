package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Coupon;

public interface CouponServ {

    Coupon acquireCoupon(int userId, int couponTypeId);

    void useCoupon(int couponId);

}
