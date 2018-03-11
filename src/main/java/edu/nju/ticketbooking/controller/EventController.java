package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.service.EventServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private EventServ eventServ;


}
