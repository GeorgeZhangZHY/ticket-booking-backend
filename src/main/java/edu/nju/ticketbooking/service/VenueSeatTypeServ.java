package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.VenueSeatType;

public interface VenueSeatTypeServ {

    VenueSeatType addNewVenueSeatType(VenueSeatType newVenueSeatType);

    VenueSeatType modifyVenueSeatType(VenueSeatType modifiedVenueSeatType);

    void deleteVenueSeatType(int venueSeatTypeId);
}
