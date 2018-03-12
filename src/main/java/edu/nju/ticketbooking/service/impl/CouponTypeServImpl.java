package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.CouponTypeDao;
import edu.nju.ticketbooking.model.CouponType;
import edu.nju.ticketbooking.service.CouponTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponTypeServImpl implements CouponTypeServ {

    @Autowired
    private CouponTypeDao couponTypeDao;

    @Override
    public CouponType addNewCouponType(CouponType newCouponType) {
        return couponTypeDao.addNewCouponType(newCouponType);
    }

    @Override
    public void setCouponTypeActivated(int couponTypeId, boolean isActivated) {
        CouponType couponType = couponTypeDao.getCouponType(couponTypeId);
        couponType.setActivated(isActivated);
        couponTypeDao.modifyCouponType(couponType);
    }

    @Override
    public CouponType modifyCouponType(CouponType modifiedCouponType) {
        return couponTypeDao.modifyCouponType(modifiedCouponType);
    }

    @Override
    public List<CouponType> getCouponTypeList(boolean activatedOnly) {
        return couponTypeDao.getCouponTypeList(activatedOnly);
    }
}
