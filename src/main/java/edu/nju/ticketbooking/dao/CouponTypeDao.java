package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.CouponType;

import java.util.List;

public interface CouponTypeDao {

    CouponType getCouponType(int couponTypeId);

    CouponType modifyCouponType(CouponType modifiedCouponType);

    List<CouponType> getCouponTypeList(boolean activatedOnly);

    CouponType addNewCouponType(CouponType newCouponType);
}
