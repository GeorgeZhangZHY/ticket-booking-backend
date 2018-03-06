package edu.nju.ticketbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue
    @Column(name = "mid", updatable = false)
    private int id;

    @Column(name = "mname")
    private String name;

    @Column(name = "mpassword")
    private String password;

    public Manager() {

    }

    public Manager(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
