package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Manager;

public interface ManagerServ {

    Manager login(String name, String password);

//    void logout()
}
