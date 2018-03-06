package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.constant.EventFilter;
import edu.nju.ticketbooking.model.Event;

import java.util.List;

public interface EventDao {

    Event addEvent(Event newEvent);

    Event modifyEvent(Event modifiedEvent);

    Event getEvent(int eventId);

    List<Event> getEventList(EventFilter filter, Object condition);

}
