package edu.nju.ticketbooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.nju.ticketbooking.constant.OrderState;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * 优惠券、会员等级优惠等仅针对Order进行计算
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid", updatable = false)
    private int orderId;

    @Column(name = "eid")
    private int eventId;

    @Column(name = "uid")
    private int userId;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private OrderState state = OrderState.UNPAID;

    @Column(name = "oprice")
    private double totalPrice;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "create_time")
    private Timestamp createTime = new Timestamp(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn(name = "eid", insertable = false, updatable = false)
    private Event event;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToOne
    @JoinColumn(name = "cid", unique = true, insertable = false, updatable = false)
    private Coupon coupon;

    public Order() {

    }

    public Order(int eventId, int userId, double totalPrice, Timestamp createTime) {
        this.eventId = eventId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int id) {
        this.orderId = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
