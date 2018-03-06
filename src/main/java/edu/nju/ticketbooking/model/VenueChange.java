package edu.nju.ticketbooking.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "venue_changes")
public class VenueChange {

    @Id
    @GeneratedValue
    @Column(name = "vcid", updatable = false)
    private int id;

    @Column(name = "vid")
    private int venueId;

    @Column(name = "submit_time")
    private Timestamp submitTime;

    @Column(name = "state")
    private String state;

    @Column(name = "new_address")
    private String newAddress;

    @Column(name = "new_vdesc")
    private String newDescription;

    @Column(name = "new_vname")
    private String newName;

    public VenueChange() {
    }

    public VenueChange(int venueId, Timestamp submitTime, String state, String newAddress, String newDescription, String newName) {
        this.venueId = venueId;
        this.submitTime = submitTime;
        this.state = state;
        this.newAddress = newAddress;
        this.newDescription = newDescription;
        this.newName = newName;
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

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
