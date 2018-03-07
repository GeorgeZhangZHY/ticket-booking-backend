package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.CouponDao;
import edu.nju.ticketbooking.dao.CouponTypeDao;
import edu.nju.ticketbooking.dao.UserDao;
import edu.nju.ticketbooking.model.Coupon;
import edu.nju.ticketbooking.model.CouponType;
import edu.nju.ticketbooking.model.User;
import edu.nju.ticketbooking.service.CouponServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServImpl implements CouponServ {

    @Autowired
    private CouponDao couponDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CouponTypeDao couponTypeDao;

    @Override
    public Coupon acquireCoupon(int userId, int couponTypeId) {
        User user = userDao.getUser(userId);
        CouponType couponType = couponTypeDao.getCouponType(couponTypeId);
        double userScore = user.getScore(), neededScore = couponType.getScoreNeeded();
        if (userScore >= neededScore) {
            user.setScore(userScore - neededScore);
            Coupon newCoupon = new Coupon(couponTypeId, userId);
            userDao.modifyUser(user);
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
