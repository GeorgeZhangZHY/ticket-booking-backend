package edu.nju.ticketbooking.dao.impl;

import edu.nju.ticketbooking.dao.TicketDao;
import edu.nju.ticketbooking.model.Ticket;
import edu.nju.ticketbooking.util.HibernateUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @Override
    public Ticket addNewTicket(Ticket newTicket) {
        return (Ticket) HibernateUtil.addNew(newTicket, Ticket.class);
    }

    @Override
    public Ticket modifyTicket(Ticket modifiedTicket) {
        return (Ticket) HibernateUtil.saveModified(modifiedTicket);
    }

    @Override
    public Ticket getTicket(int ticketId) {
        return (Ticket) HibernateUtil.getById(ticketId, Ticket.class);
    }


    @Override
    public List<Ticket> getTicketsByEventSeat(int eventId, int venueSeatTypeId) {
        String query = "FROM Ticket WHERE eventId = ? AND venueSeatTypeId = ?";
        return HibernateUtil.getListByQuery(query, new Object[]{eventId, venueSeatTypeId});
    }

    @Override
    public List<Ticket> getEventTicketList(int eventId) {
        return HibernateUtil.getListByQuery("FROM Ticket WHERE eventId = ?", new Object[]{eventId});
    }

}
