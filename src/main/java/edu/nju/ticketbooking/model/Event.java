package edu.nju.ticketbooking.model;

import edu.nju.ticketbooking.constant.EventType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid", updatable = false)
    private int eventId;

    @Column(name = "vid")
    private int venueId;

    @Column(name = "ename")
    private String eventName;

    @Column(name = "edesc")
    private String description;

    @Column(name = "host_time")
    private Timestamp hostTime;

    @Column(name = "etype")
    @Enumerated(value = EnumType.STRING)
    private EventType eventType;

    @Column(name = "poster_url")
    private String posterUrl;

    public Event() {

    }

    public Event(int venueId, String eventName, String description, Timestamp hostTime, EventType eventType, String posterUrl) {
        this.venueId = venueId;
        this.eventName = eventName;
        this.description = description;
        this.hostTime = hostTime;
        this.eventType = eventType;
        this.posterUrl = posterUrl;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int id) {
        this.eventId = id;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getHostTime() {
        return hostTime;
    }

    public void setHostTime(Timestamp hostTime) {
        this.hostTime = hostTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
