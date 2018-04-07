package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.VenueSeatType;

/**
 * 修改场馆座位类型时不需要管理员审批
 */
public interface VenueSeatTypeServ {

    VenueSeatType addNewVenueSeatType(VenueSeatType newVenueSeatType);

    VenueSeatType modifyVenueSeatType(VenueSeatType modifiedVenueSeatType);

    void setVenueSeatTypeDeleted(int venueSeatTypeId);
}
