package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.EventDao;
import edu.nju.ticketbooking.dao.OrderDao;
import edu.nju.ticketbooking.model.*;
import edu.nju.ticketbooking.service.EventServ;
import edu.nju.ticketbooking.service.OrderServ;
import edu.nju.ticketbooking.service.SummaryServ;
import edu.nju.ticketbooking.service.VenueServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServImpl implements EventServ {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderServ orderServ;

    @Autowired
    private VenueServ venueServ;

    @Autowired
    private SummaryServ summaryServ;

    @Override
    public Event getEvent(int eventId) {
        return eventDao.getEvent(eventId);
    }

    @Override
    public Event addNewEvent(Event newEvent) {
        return eventDao.addEvent(newEvent);
    }

    /**
     * 自动将到期活动设为已举行
     * 并将相应订单设为已完成，同时添加待结算任务
     * 每30秒运行一次
     */
    @Scheduled(fixedRate = 30 * 1000)
    private void setDueEventHosted() {
        for (Event event : eventDao.getAllEventList()) {
            long hostTime = event.getHostTime().getTime(),
                    now = System.currentTimeMillis();
            if (now > hostTime) {
                event.setHosted(true);
                List<Order> eventOrderList = orderDao.getEventOrderList(event.getEventId());
                double totalMoney = 0;
                for (Order order : eventOrderList) {
                    orderServ.completeOrder(order.getOrderId());
                    totalMoney += order.getTotalPrice();
                }

                //分成比例
                double venuePart = 0.7;
                double venueIncome = totalMoney * venuePart,
                        platformIncome = totalMoney - venueIncome;


                Venue venue = venueServ.getVenue(event.getVenueId());
                Summary newSummary = new Summary(
                        event.getEventId(),
                        event.getVenueId(),
                        false,
                        totalMoney,
                        platformIncome,
                        venueIncome,
                        event,
                        venue
                );
                summaryServ.addNewUnhandledSummary(newSummary);
            }
        }
    }

    @Override
    public Event modifyEvent(Event modifiedEvent) {
        Event event = eventDao.getEvent(modifiedEvent.getEventId());
        if (event.getIsHosted()) {
            return null; // 已经举行的活动不允许修改信息
        }
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
