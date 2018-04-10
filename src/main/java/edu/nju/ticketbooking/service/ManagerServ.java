package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Manager;
import edu.nju.ticketbooking.model.Statistics;

public interface ManagerServ {

    Manager getManager(int managerId);

    Statistics getStatistics();

}
