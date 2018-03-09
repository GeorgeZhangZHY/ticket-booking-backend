package edu.nju.ticketbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "event_seat_prices")
public class EventSeatPrice {

    @Id
    @GeneratedValue
    @Column(name = "espid", updatable = false)
    private int id;

    @Column(name = "eid")
    private int eventId;

    @Column(name = "vstid")
    private int venueSeatTypeId;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "vstid", insertable = false, updatable = false)
    private VenueSeatType venueSeatType;

    public EventSeatPrice() {
    }

    public EventSeatPrice(int eventId, int venueSeatTypeId, double price) {
        this.eventId = eventId;
        this.venueSeatTypeId = venueSeatTypeId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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
