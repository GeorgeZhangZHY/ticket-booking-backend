package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.constant.EventFilterType;
import edu.nju.ticketbooking.constant.EventType;
import edu.nju.ticketbooking.dao.EventDao;
import edu.nju.ticketbooking.model.Event;
import edu.nju.ticketbooking.model.Page;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Event> getEventList(EventFilterType filter, Object condition, int pageSize, int pageNum, Timestamp fromTime, Timestamp toTime) {
        String queryTemplate = "FROM Event WHERE hostTime >= ? AND hostTime <= ? %s ORDER BY hostTime ASC";
        String constraint = "";
        ArrayList params = new ArrayList(Arrays.asList(fromTime, toTime));
        switch (filter) {
            case TYPE:
                condition = EventType.valueOf((String) condition);    // 手动cast，避免hibernate报错
                if (condition != EventType.ALL) {
                    constraint = "AND eventType = ?";
                    params.add(condition);
                }
                break;
            case VENUE:
                constraint = "AND venueId = ?";
                params.add(condition);
                break;
        }
        String query = String.format(queryTemplate, constraint);
        return HibernateUtil.getPageByQuery(query, params.toArray(), new Page(pageSize, pageNum));
    }

}
