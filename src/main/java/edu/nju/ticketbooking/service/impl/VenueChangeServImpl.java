package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.constant.VenueChangeState;
import edu.nju.ticketbooking.dao.VenueChangeDao;
import edu.nju.ticketbooking.model.VenueChange;
import edu.nju.ticketbooking.service.VenueChangeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueChangeServImpl implements VenueChangeServ {

    @Autowired
    private VenueChangeDao venueChangeDao;

    @Override
    public VenueChange modifyVenueChange(VenueChange modifiedVenueChange) {
        return venueChangeDao.modifyVenueChange(modifiedVenueChange);
    }

    @Override
    public void setVenueChangeApproved(int venueChangeId, boolean isApproved) {
        VenueChange venueChange = venueChangeDao.getVenueChange(venueChangeId);
        venueChange.setState(isApproved ? VenueChangeState.APPROVED : VenueChangeState.REJECTED);
        venueChangeDao.modifyVenueChange(venueChange);
    }

    @Override
    public VenueChange addNewVenueChange(VenueChange newVenueChange) {
        return venueChangeDao.addNewVenueChange(newVenueChange);
    }

    @Override
    public List<VenueChange> getVenueChangeList(VenueChangeState state, int pageSize, int pageNum) {
        return venueChangeDao.getVenueChangeList(state, pageSize, pageNum);
    }
}
