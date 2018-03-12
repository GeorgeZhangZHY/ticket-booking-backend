package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Coupon;

import java.util.List;

public interface CouponServ {

    Coupon acquireCoupon(int userId, int couponTypeId);

    void setCouponUsed(int couponId, boolean isUsed);

    List<Coupon> getUserCouponList(int userId);
}
