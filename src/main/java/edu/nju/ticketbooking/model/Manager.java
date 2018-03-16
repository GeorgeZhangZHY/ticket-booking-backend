package edu.nju.ticketbooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid", updatable = false)
    private int managerId;

    @Column(name = "mname")
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "mpassword")
    private String password;

    public Manager() {

    }

    public Manager(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int id) {
        this.managerId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
