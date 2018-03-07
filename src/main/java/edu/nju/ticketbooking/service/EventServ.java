package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.constant.EventFilter;
import edu.nju.ticketbooking.model.Event;

import java.sql.Timestamp;
import java.util.List;

public interface EventServ {

    Event addNewEvent(Event newEvent);

    Event modifyEvent(Event modifiedEvent);

    List<Event> getEventList(EventFilter filter, Object condition, int pageSize, int pageNum, Timestamp fromTime, Timestamp toTime);

}
