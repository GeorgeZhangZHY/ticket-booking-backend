package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.EventSeatPriceDao;
import edu.nju.ticketbooking.model.EventSeatPrice;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventSeatPriceDaoImpl implements EventSeatPriceDao {
    @Override
    public EventSeatPrice addEventSeatPrice(EventSeatPrice newEventSeatPrice) {
        return (EventSeatPrice) HibernateUtil.addNew(newEventSeatPrice, EventSeatPrice.class);
    }

    @Override
    public void deleteEventSeatPrice(int eventSeatPriceId) {
        HibernateUtil.deleteById(eventSeatPriceId, EventSeatPrice.class);
    }

    @Override
    public EventSeatPrice modifyEventSeatPrice(EventSeatPrice modifiedEventSeatPrice) {
        return (EventSeatPrice) HibernateUtil.saveModified(modifiedEventSeatPrice);
    }

    @Override
    public List<EventSeatPrice> getEventSeatPriceList(int eventId) {
        String query = "FROM EventSeatPrice WHERE eventId = ?";
        return HibernateUtil.getListByQuery(query, new Object[]{eventId});
    }

    @Override
    public EventSeatPrice getEventSeatPrice(int eventSeatPriceId) {
        return (EventSeatPrice) HibernateUtil.getById(eventSeatPriceId, EventSeatPrice.class);
    }
}
