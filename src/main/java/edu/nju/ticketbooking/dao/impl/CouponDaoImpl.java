package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.CouponDao;
import edu.nju.ticketbooking.model.Coupon;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponDaoImpl implements CouponDao {

    @Override
    public Coupon addNewCoupon(Coupon newCoupon) {
        return (Coupon) HibernateUtil.addNew(newCoupon, Coupon.class);
    }

    @Override
    public List<Coupon> getUserCouponList(int userId) {
        return HibernateUtil.getListByQuery("FROM Coupon c WHERE c.userId = ?", new Object[]{userId});
    }

    @Override
    public Coupon modifyCoupon(Coupon modifiedCoupon) {
        return (Coupon) HibernateUtil.saveModified(modifiedCoupon);
    }

    @Override
    public Coupon getCoupon(int couponId) {
        return (Coupon) HibernateUtil.getById(couponId, Coupon.class);
    }
}
