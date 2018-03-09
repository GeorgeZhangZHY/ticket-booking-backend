package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.dao.TicketDao;
import edu.nju.ticketbooking.model.Ticket;
import edu.nju.ticketbooking.service.TicketServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServImpl implements TicketServ {

    @Autowired
    private TicketDao ticketDao;

    @Override
    public Ticket addNewTicket(Ticket newTicket) {
        return ticketDao.addNewTicket(newTicket);
    }

    @Override
    public Ticket modifyTicket(Ticket modifiedTicket) {
        return ticketDao.modifyTicket(modifiedTicket);
    }

    @Override
    public void checkTicket(int ticketId) {
        Ticket ticket = ticketDao.getTicket(ticketId);
        ticket.setChecked(true);
        ticketDao.modifyTicket(ticket);
    }
}
