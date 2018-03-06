package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.CouponType;

public interface CouponTypeServ {

    CouponType addNewCouponType(CouponType newCouponType);

    void setCouponTypeActivated(int couponTypeId, boolean isActivated);

    CouponType modifyCouponType(CouponType modifiedCouponType);
}
