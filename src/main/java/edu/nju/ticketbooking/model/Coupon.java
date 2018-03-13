package edu.nju.ticketbooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 用户持有的优惠券
 */
@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", updatable = false)
    private int couponId;

    @Column(name = "ctid")
    private int couponTypeId;

    @Column(name = "uid")
    private int userId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "get_time")
    private Timestamp getTime = new Timestamp(System.currentTimeMillis());

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

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int id) {
        this.couponId = id;
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
