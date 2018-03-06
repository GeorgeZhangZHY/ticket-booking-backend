package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.constant.EventFilter;
import edu.nju.ticketbooking.dao.EventDao;
import edu.nju.ticketbooking.model.Event;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {

    @Override
    public Event addEvent(Event newEvent) {
        return (Event) HibernateUtil.addNew(newEvent, Event.class);
    }

    @Override
    public Event modifyEvent(Event modifiedEvent) {
        return (Event) HibernateUtil.saveModified(modifiedEvent);
    }

    @Override
    public Event getEvent(int eventId) {
        return (Event) HibernateUtil.getById(eventId, Event.class);
    }

    @Override
    public List<Event> getEventList(EventFilter filter, Object condition) {
        String queryStr = null;
        switch (filter) {
            case VENUE:
                queryStr = "FROM Event e WHERE e.venueId = ?";
                break;
            case TYPE:
                queryStr = "FROM Event e WHERE e.eventType = ?";
                break;
        }
        return HibernateUtil.getListByQuery(queryStr, new Object[]{condition});
    }
}
