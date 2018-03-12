package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.Venue;
import edu.nju.ticketbooking.service.VenueServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VenueController {

    @Autowired
    private VenueServ venueServ;

    @PostMapping(value = "/venue")
    public Venue applyForNewVenue(@RequestBody Venue newVenue) {
        return venueServ.applyForNewVenue(newVenue);
    }

    @GetMapping(value = "/venue")
    public Venue getVenue(@RequestParam(value = "venueId") int venueId) {
        return venueServ.getVenue(venueId);
    }

    @PutMapping(value = "/venue/approved")
    public boolean setVenueApplicationApproved(
            @RequestParam(value = "venueId") int venueId,
            @RequestParam(value = "isApproved") boolean isApproved) {
        venueServ.setVenueApplicationApproved(venueId, isApproved);
        return isApproved;
    }
}
