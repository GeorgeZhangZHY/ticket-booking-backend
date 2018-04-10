package edu.nju.ticketbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "event_seat_prices")
public class EventSeatPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "espid", updatable = false)
    private int eventSeatPriceId;

    @Column(name = "vstid")
    private int venueSeatTypeId;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "vstid", insertable = false, updatable = false)
    private VenueSeatType venueSeatType;

    public EventSeatPrice() {
    }

    public EventSeatPrice(int venueSeatTypeId, double price) {
        this.venueSeatTypeId = venueSeatTypeId;
        this.price = price;
    }

    public int getEventSeatPriceId() {
        return eventSeatPriceId;
    }

    public void setEventSeatPriceId(int id) {
        this.eventSeatPriceId = id;
    }

    public int getVenueSeatTypeId() {
        return venueSeatTypeId;
    }

    public void setVenueSeatTypeId(int venueSeatTypeId) {
        this.venueSeatTypeId = venueSeatTypeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public VenueSeatType getVenueSeatType() {
        return venueSeatType;
    }

    public void setVenueSeatType(VenueSeatType venueSeatType) {
        this.venueSeatType = venueSeatType;
    }
}
