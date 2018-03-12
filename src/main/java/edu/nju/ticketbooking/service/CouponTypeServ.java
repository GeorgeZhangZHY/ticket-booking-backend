package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.CouponType;

import java.util.List;

public interface CouponTypeServ {

    CouponType addNewCouponType(CouponType newCouponType);

    void setCouponTypeActivated(int couponTypeId, boolean isActivated);

    CouponType modifyCouponType(CouponType modifiedCouponType);

    /**
     * @param activatedOnly 若为true，则只取处于激活状态下的优惠券类型；否则取所有
     */
    List<CouponType> getCouponTypeList(boolean activatedOnly);
}
