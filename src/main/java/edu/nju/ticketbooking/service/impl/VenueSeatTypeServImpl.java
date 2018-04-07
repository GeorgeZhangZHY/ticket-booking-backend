package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.VenueSeatTypeDao;
import edu.nju.ticketbooking.model.VenueSeatType;
import edu.nju.ticketbooking.service.VenueSeatTypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueSeatTypeServImpl implements VenueSeatTypeServ {

    @Autowired
    private VenueSeatTypeDao venueSeatTypeDao;

    @Override
    public VenueSeatType addNewVenueSeatType(VenueSeatType newVenueSeatType) {
        return venueSeatTypeDao.addNewVenueSeatType(newVenueSeatType);
    }

    @Override
    public VenueSeatType modifyVenueSeatType(VenueSeatType modifiedVenueSeatType) {
        return venueSeatTypeDao.modifyVenueSeatType(modifiedVenueSeatType);
    }

    @Override
    public void setVenueSeatTypeDeleted(int venueSeatTypeId) {
        VenueSeatType seatType = venueSeatTypeDao.getVenueSeatType(venueSeatTypeId);
        seatType.setDeleted(true);
        venueSeatTypeDao.modifyVenueSeatType(seatType);
    }
}
