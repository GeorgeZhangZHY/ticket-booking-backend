package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.service.ManagerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @Autowired
    private ManagerServ managerServ;
    

}
