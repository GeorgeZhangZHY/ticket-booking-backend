package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.EventSeatPriceDao;
import edu.nju.ticketbooking.model.EventSeatPrice;
import edu.nju.ticketbooking.service.EventSeatPriceServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventSeatPriceServImpl implements EventSeatPriceServ {

    @Autowired
    private EventSeatPriceDao eventSeatPriceDao;

    @Override
    public EventSeatPrice addEventSeatPrice(EventSeatPrice newEventSeatPrice) {
        return eventSeatPriceDao.addEventSeatPrice(newEventSeatPrice);
    }

    @Override
    public void deleteEventSeatPrice(int eventSeatPriceId) {
        eventSeatPriceDao.deleteEventSeatPrice(eventSeatPriceId);
    }

    @Override
    public EventSeatPrice modifyEventSeatPrice(EventSeatPrice modifiedEventSeatPrice) {
        return eventSeatPriceDao.modifyEventSeatPrice(modifiedEventSeatPrice);
    }

    @Override
    public List<EventSeatPrice> getEventSeatPriceList(int eventId) {
        return eventSeatPriceDao.getEventSeatPriceList(eventId);
    }

}
