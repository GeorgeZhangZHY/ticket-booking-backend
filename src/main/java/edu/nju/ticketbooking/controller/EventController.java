package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.Event;
import edu.nju.ticketbooking.model.EventFilter;
import edu.nju.ticketbooking.service.EventServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventServ eventServ;

    @GetMapping(value = "/event")
    public Event getEvent(@RequestParam(value = "eventId") int eventId) {
        return eventServ.getEvent(eventId);
    }

    @PostMapping(value = "/event/list")
    public List<Event> getEventList(@RequestBody EventFilter filter) {
        return eventServ.getEventList(filter);
    }

    @PostMapping(value = "/event")
    public Event addNewEvent(@RequestBody Event newEvent) {
        return eventServ.addNewEvent(newEvent);
    }

    @PutMapping(value = "/event")
    public Event modifyEvent(@RequestBody Event modifiedEvent) {
        return eventServ.modifyEvent(modifiedEvent);
    }
}
