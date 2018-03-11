package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.CouponDao;
import edu.nju.ticketbooking.dao.CouponTypeDao;
import edu.nju.ticketbooking.model.Coupon;
import edu.nju.ticketbooking.service.CouponServ;
import edu.nju.ticketbooking.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void useCoupon(int couponId) {
        Coupon coupon = couponDao.getCoupon(couponId);
        coupon.setUsed(true);
        couponDao.modifyCoupon(coupon);
    }
}
