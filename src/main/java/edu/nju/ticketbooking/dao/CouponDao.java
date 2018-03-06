package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.Coupon;

import java.util.List;

public interface CouponDao {

    Coupon addNewCoupon(Coupon newCoupon);

    List<Coupon> getUserCouponList(int userId);

    Coupon modifyCoupon(Coupon modifiedCoupon);

    Coupon getCoupon(int couponId);
}
