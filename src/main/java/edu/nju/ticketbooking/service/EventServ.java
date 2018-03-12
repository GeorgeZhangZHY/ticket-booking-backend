package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Event;
import edu.nju.ticketbooking.model.EventFilter;

import java.util.List;

public interface EventServ {

    Event getEvent(int eventId);

    Event addNewEvent(Event newEvent);

    Event modifyEvent(Event modifiedEvent);

    List<Event> getEventList(EventFilter filter);

}
