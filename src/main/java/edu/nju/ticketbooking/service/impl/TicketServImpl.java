package edu.nju.ticketbooking.service.impl;

import edu.nju.ticketbooking.constant.TicketState;
import edu.nju.ticketbooking.dao.TicketDao;
import edu.nju.ticketbooking.dao.VenueSeatTypeDao;
import edu.nju.ticketbooking.model.Ticket;
import edu.nju.ticketbooking.model.VenueSeatType;
import edu.nju.ticketbooking.service.TicketServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServImpl implements TicketServ {

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private VenueSeatTypeDao venueSeatTypeDao;

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
        ticket.setTicketState(TicketState.CHECKED);
        ticketDao.modifyTicket(ticket);
    }

    @Override
    public int[][] getAvailableSeats(int eventId, int venueSeatTypeId) {
        VenueSeatType seatType = venueSeatTypeDao.getVenueSeatType(venueSeatTypeId);
        int[][] map = new int[seatType.getTotalRowNum()][seatType.getTotalColumnNum()];
        List<Ticket> soldTickets = ticketDao.getTicketsByEventSeat(eventId, venueSeatTypeId);
        for (Ticket ticket : soldTickets) {
            if (ticket.getTicketState() != TicketState.CANCELED) {
                map[ticket.getRowNum()][ticket.getColumnNum()] = 1;
            }
        }
        return map;
    }

}
