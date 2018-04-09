package edu.nju.ticketbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "summaries")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", updatable = false)
    private int summaryId;

    @Column(name = "eid")
    private int eventId;

    @Column(name = "vid")
    private int venueId;

    @Column(name = "is_handled")
    private boolean isHandled;      // 已结算

    @Column(name = "total_money")
    private double totalMoney;

    @Column(name = "platform_income")
    private double platformIncome;

    @Column(name = "venue_income")
    private double venueIncome;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eid", insertable = false, updatable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vid", insertable = false, updatable = false)
    private Venue venue;

    public Summary() {
    }

    public Summary(int eventId, int venueId, boolean isHandled, double totalMoney, double platformIncome, double venueIncome, Event event, Venue venue) {
        this.eventId = eventId;
        this.venueId = venueId;
        this.isHandled = isHandled;
        this.totalMoney = totalMoney;
        this.platformIncome = platformIncome;
        this.venueIncome = venueIncome;
        this.event = event;
        this.venue = venue;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getPlatformIncome() {
        return platformIncome;
    }

    public void setPlatformIncome(double platformIncome) {
        this.platformIncome = platformIncome;
    }

    public double getVenueIncome() {
        return venueIncome;
    }

    public void setVenueIncome(double venueIncome) {
        this.venueIncome = venueIncome;
    }

    public int getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(int summaryId) {
        this.summaryId = summaryId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public boolean getIsHandled() {
        return isHandled;
    }

    public void setHandled(boolean handled) {
        isHandled = handled;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
