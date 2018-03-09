package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.EventSeatPrice;

import java.util.List;

public interface EventSeatPriceServ {

    EventSeatPrice addEventSeatPrice(EventSeatPrice newEventSeatPrice);

    void deleteEventSeatPrice(int eventSeatPriceId);

    EventSeatPrice modifyEventSeatPrice(EventSeatPrice modifiedEventSeatPrice);

    List<EventSeatPrice> getEventSeatPriceList(int eventId);

}
