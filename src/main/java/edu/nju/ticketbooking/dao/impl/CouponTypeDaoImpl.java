package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.CouponTypeDao;
import edu.nju.ticketbooking.model.CouponType;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CouponTypeDaoImpl implements CouponTypeDao {

    @Override
    public CouponType getCouponType(int couponTypeId) {
        return (CouponType) HibernateUtil.getById(couponTypeId, CouponType.class);
    }

    @Override
    public CouponType modifyCouponType(CouponType modifiedCouponType) {
        return (CouponType) HibernateUtil.saveModified(modifiedCouponType);
    }

    @Override
    public List<CouponType> getAllCouponType() {
        return HibernateUtil.getListByQuery("FROM CouponType", null);
    }

    @Override
    public CouponType addNewCouponType(CouponType newCouponType) {
        return (CouponType) HibernateUtil.addNew(newCouponType, CouponType.class);
    }

}
