package edu.nju.ticketbooking.service;

import edu.nju.ticketbooking.model.Ticket;

public interface TicketServ {

    /**
     * 先调用此方法再调用addNewOrder
     */
    Ticket addNewTicket(Ticket newTicket);

    Ticket modifyTicket(Ticket modifiedTicket);

    void checkTicket(int ticketId);

    /**
     * 按照座位行列形式获取某次活动某种座位类型的购票情况，1表示已售出，0表示未售出
     */
    int[][] getAvailableSeats(int eventId, int venueSeatTypeId);

}
