package edu.nju.ticketbooking.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "eid", updatable = false)
    private int id;

    @Column(name = "vid")
    private int venueId;

    @Column(name = "edesc")
    private String description;

    @Column(name = "host_time")
    private Timestamp hostTime;

    @Column(name = "etype")
    private String eventType;

    public Event() {

    }

    public Event(int venueId, String description, Timestamp hostTime, String eventType) {
        this.venueId = venueId;
        this.description = description;
        this.hostTime = hostTime;
        this.eventType = eventType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
