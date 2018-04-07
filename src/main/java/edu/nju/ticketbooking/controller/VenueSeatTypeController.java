package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.VenueSeatType;
import edu.nju.ticketbooking.service.VenueSeatTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VenueSeatTypeController {

    @Autowired
    private VenueSeatTypeServ venueSeatTypeServ;

    @PostMapping(value = "/venueSeatType")
    public VenueSeatType addNewVenueSeatType(@RequestBody VenueSeatType newVenueSeatType) {
        return venueSeatTypeServ.addNewVenueSeatType(newVenueSeatType);
    }

    @PutMapping(value = "/venueSeatType")
    public VenueSeatType modifyVenueSeatType(@RequestBody VenueSeatType modifiedVenueSeatType) {
        return venueSeatTypeServ.modifyVenueSeatType(modifiedVenueSeatType);
    }

    @DeleteMapping(value = "/venueSeatType")
    public void deleteVenueSeatType(@RequestParam(value = "venueSeatTypeId") int venueSeatTypeId) {
        venueSeatTypeServ.setVenueSeatTypeDeleted(venueSeatTypeId);
    }

}
