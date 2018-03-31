package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.Ticket;

import java.util.List;

public interface TicketDao {

    Ticket addNewTicket(Ticket newTicket);

    Ticket modifyTicket(Ticket modifiedTicket);

    Ticket getTicket(int ticketId);

    void deleteTicket(int ticketId);

    List<Ticket> getTicketsByEventSeat(int eventId, int venueSeatTypeId);
}
