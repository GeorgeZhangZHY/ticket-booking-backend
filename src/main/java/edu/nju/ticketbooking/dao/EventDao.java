package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.constant.EventFilterType;
import edu.nju.ticketbooking.model.Event;

import java.sql.Timestamp;
import java.util.List;

public interface EventDao {

    Event addEvent(Event newEvent);

    Event modifyEvent(Event modifiedEvent);

    Event getEvent(int eventId);

    List<Event> getEventList(EventFilterType filter, Object condition, int pageSize, int pageNum, Timestamp fromTime, Timestamp toTime);

    List<Event> getAllEventList();
}
