package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.EventSeatPrice;
import edu.nju.ticketbooking.service.EventSeatPriceServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventSeatPriceController {

    @Autowired
    private EventSeatPriceServ seatPriceServ;

    @PostMapping(value = "/eventSeatPrice")
    public EventSeatPrice addEventSeatPrice(@RequestBody EventSeatPrice newEventSeatPrice) {
        return seatPriceServ.addEventSeatPrice(newEventSeatPrice);
    }

    @DeleteMapping(value = "/eventSeatPrice")
    public void deleteEventSeatPrice(@RequestParam(value = "eventSeatPriceId") int eventSeatPriceId) {
        seatPriceServ.deleteEventSeatPrice(eventSeatPriceId);
    }

    @PutMapping(value = "/eventSeatPrice")
    public EventSeatPrice modifyEventSeatPrice(@RequestBody EventSeatPrice modifiedEventSeatPrice) {
        return seatPriceServ.modifyEventSeatPrice(modifiedEventSeatPrice);
    }

    @GetMapping(value = "/eventSeatPrice")
    public List<EventSeatPrice> getEventSeatPriceList(@RequestParam(value = "evenId") int eventId) {
        return seatPriceServ.getEventSeatPriceList(eventId);
    }

}
