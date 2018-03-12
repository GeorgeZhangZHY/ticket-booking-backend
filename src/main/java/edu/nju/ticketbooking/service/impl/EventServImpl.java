package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.EventDao;
import edu.nju.ticketbooking.model.Event;
import edu.nju.ticketbooking.model.EventFilter;
import edu.nju.ticketbooking.service.EventServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServImpl implements EventServ {

    @Autowired
    private EventDao eventDao;

    @Override
    public Event getEvent(int eventId) {
        return eventDao.getEvent(eventId);
    }

    @Override
    public Event addNewEvent(Event newEvent) {
        return eventDao.addEvent(newEvent);
    }

    @Override
    public Event modifyEvent(Event modifiedEvent) {
        return eventDao.modifyEvent(modifiedEvent);
    }

    @Override
    public List<Event> getEventList(EventFilter filter) {
        return eventDao.getEventList(
                filter.getType(),
                filter.getCondition(),
                filter.getPageSize(),
                filter.getPageNum(),
                filter.getFromTime(),
                filter.getToTime()
        );
    }

}
