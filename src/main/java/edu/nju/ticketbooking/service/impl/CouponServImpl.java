package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.CouponDao;
import edu.nju.ticketbooking.dao.CouponTypeDao;
import edu.nju.ticketbooking.model.Coupon;
import edu.nju.ticketbooking.service.CouponServ;
import edu.nju.ticketbooking.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServImpl implements CouponServ {

    @Autowired
    private CouponDao couponDao;

    @Autowired
    private UserServ userServ;

    @Autowired
    private CouponTypeDao couponTypeDao;

    @Override
    public Coupon acquireCoupon(int userId, int couponTypeId) {
        double neededScore = couponTypeDao.getCouponType(couponTypeId).getScoreNeeded();
        if (userServ.modifyScore(userId, -neededScore, false)) {
            Coupon newCoupon = new Coupon(couponTypeId, userId);
            return couponDao.addNewCoupon(newCoupon);
        }
        return null;
    }

    @Override
    public void setCouponUsed(int couponId, boolean isUsed) {
        Coupon coupon = couponDao.getCoupon(couponId);
        if (coupon != null) {
            coupon.setUsed(isUsed);
            couponDao.modifyCoupon(coupon);
        }
    }

    @Override
    public List<Coupon> getUserCouponList(int userId) {
        return couponDao.getUserCouponList(userId);
    }
}
