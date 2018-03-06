package edu.nju.ticketbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_types")
public class EventType {

    @Id
    @Column(name = "type", updatable = false)
    private String type;

    public EventType() {
    }

    public EventType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
