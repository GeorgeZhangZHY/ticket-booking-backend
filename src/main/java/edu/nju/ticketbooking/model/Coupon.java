package edu.nju.ticketbooking.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 用户持有的优惠券
 */
@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue
    @Column(name = "cid", updatable = false)
    private int id;

    @Column(name = "ctid")
    private int couponTypeId;

    @Column(name = "uid")
    private int userId;

    @Column(name = "get_time")
    private Timestamp getTime;

    @Column(name = "is_used")
    private boolean isUsed;

    @ManyToOne
    @JoinColumn(name = "ctid", nullable = false, updatable = false, insertable = false)
    private CouponType couponType;

    public Coupon() {

    }

    public Coupon(int couponTypeId, int userId) {
        this.couponTypeId = couponTypeId;
        this.userId = userId;
        this.isUsed = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(int couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getGetTime() {
        return getTime;
    }

    public void setGetTime(Timestamp getTime) {
        this.getTime = getTime;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public CouponType getCouponType() {
        return couponType;
    }

    public void setCouponType(CouponType couponType) {
        this.couponType = couponType;
    }
}
