package edu.nju.ticketbooking.controller;

import edu.nju.ticketbooking.model.Ticket;
import edu.nju.ticketbooking.service.TicketServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketServ ticketServ;

    @GetMapping(value = "/ticket/seat")
    public int[][] getAvailableSeats(
            @RequestParam(value = "eventId") int eventId,
            @RequestParam(value = "venueSeatTypeId") int venueSeatTypeId
    ) {
        return ticketServ.getAvailableSeats(eventId, venueSeatTypeId);
    }

    @GetMapping(value = "/ticket")
    public List<Ticket> getEventTicketList(@RequestParam(value = "eventId") int eventId) {
        return ticketServ.getEventTicketList(eventId);
    }


    /**
     * 用于线下非会员购票
     * 其余情况均通过Order接口购票
     */
    @PostMapping(value = "/ticket")
    public Ticket addNewTicket(@RequestBody Ticket newTicket) {
        return ticketServ.addNewTicket(newTicket);
    }

    @PutMapping(value = "/ticket/check")
    public void checkTicket(@RequestParam(value = "ticketId") int ticketId) {
        ticketServ.checkTicket(ticketId);
    }
}
