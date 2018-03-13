package edu.nju.ticketbooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.nju.ticketbooking.constant.VenueChangeState;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "venue_changes")
public class VenueChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vcid", updatable = false)
    private int venueChangeId;

    @Column(name = "vid")
    private int venueId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "submit_time")
    private Timestamp submitTime = new Timestamp(System.currentTimeMillis());

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private VenueChangeState state = VenueChangeState.PENDING;

    @Column(name = "new_address")
    private String newAddress;

    @Column(name = "new_vdesc")
    private String newDescription;

    @Column(name = "new_vname")
    private String newName;

    public VenueChange() {
    }

    public VenueChange(int venueId, Timestamp submitTime, String newAddress, String newDescription, String newName) {
        this.venueId = venueId;
        this.submitTime = submitTime;
        this.newAddress = newAddress;
        this.newDescription = newDescription;
        this.newName = newName;
    }

    public int getVenueChangeId() {
        return venueChangeId;
    }

    public void setVenueChangeId(int id) {
        this.venueChangeId = id;
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

    public VenueChangeState getState() {
        return state;
    }

    public void setState(VenueChangeState state) {
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
