package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.Manager;
import edu.nju.ticketbooking.model.Statistics;
import edu.nju.ticketbooking.service.ManagerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @Autowired
    private ManagerServ managerServ;

    @GetMapping(value = "/manager")
    public Manager getOrderList(@RequestParam(value = "managerId") int managerId) {
        return managerServ.getManager(managerId);
    }

    @GetMapping(value = "/manager/statistics")
    public Statistics getStatistics() {
        return managerServ.getStatistics();
    }
}
