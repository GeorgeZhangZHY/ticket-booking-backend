package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Event;

public interface EventServ {

    Event addNewEvent(Event newEvent);

    Event modifyEvent(Event modifiedEvent);

}
