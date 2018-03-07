package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.EventSeatPrice;

import java.util.List;

public interface EventSeatPriceDao {

    EventSeatPrice addEventSeatPrice(EventSeatPrice newEventSeatPrice);

    void deleteEventSeatPrice(int eventSeatPriceId);

    EventSeatPrice modifyEventSeatPrice(EventSeatPrice modifiedEventSeatPrice);

    List<EventSeatPrice> getEventSeatPriceList(int eventId);

    EventSeatPrice getEventSeatPrice(int eventSeatPriceId);
}
