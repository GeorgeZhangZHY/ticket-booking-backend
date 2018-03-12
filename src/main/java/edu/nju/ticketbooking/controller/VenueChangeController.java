package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.constant.VenueChangeState;
import edu.nju.ticketbooking.model.VenueChange;
import edu.nju.ticketbooking.service.VenueChangeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenueChangeController {

    @Autowired
    private VenueChangeServ venueChangeServ;

    @GetMapping(value = "/venueChange")
    public List<VenueChange> getVenueChangeList(
            @RequestParam(value = "state") VenueChangeState state,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "pageNum") int pageNum
    ) {
        return venueChangeServ.getVenueChangeList(state, pageSize, pageNum);
    }

    @PostMapping(value = "/venueChange")
    public VenueChange addNewVenueChange(@RequestBody VenueChange newVenueChange) {
        return venueChangeServ.addNewVenueChange(newVenueChange);
    }

    @PutMapping(value = "/venueChange")
    public VenueChange modifyVenueChange(@RequestBody VenueChange modifiedVenueChange) {
        return venueChangeServ.modifyVenueChange(modifiedVenueChange);
    }

    @PutMapping(value = "/venueChange/approve")
    public boolean setVenueChangeApproved(
            @RequestParam(value = "venueChangeId") int venueChangeId,
            @RequestParam(value = "isApproved") boolean isApproved
    ) {
        venueChangeServ.setVenueChangeApproved(venueChangeId, isApproved);
        return isApproved;
    }
}
