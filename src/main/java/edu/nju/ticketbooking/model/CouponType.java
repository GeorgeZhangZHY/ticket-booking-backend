package edu.nju.ticketbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "coupon_types")
public class CouponType {

    @Id
    @GeneratedValue
    @Column(name = "ctid", updatable = false)
    private int id;

    @Column(name = "cdesc")
    private String description;

    @Column(name = "cprice")
    private double price;       // 优惠券面额

    @Column(name = "cond")
    private double condition;   // 订单价格满多少可以使用

    @Column(name = "score_needed")
    private int scoreNeeded;   // 兑换所需积分

    @Column(name = "is_activated")
    private boolean isActivated = true;    // 是否可供兑换

    public CouponType() {
    }

    public CouponType(String description, double price, double condition) {
        this.description = description;
        this.price = price;
        this.condition = condition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCondition() {
        return condition;
    }

    public void setCondition(double condition) {
        this.condition = condition;
    }

    public int getScoreNeeded() {
        return scoreNeeded;
    }

    public void setScoreNeeded(int scoreNeeded) {
        this.scoreNeeded = scoreNeeded;
    }

    public boolean getIsActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }
}
