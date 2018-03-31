package edu.nju.ticketbooking.model;

import edu.nju.ticketbooking.constant.TicketState;

import javax.persistence.*;

/**
 * 在购买时才创建
 */
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", updatable = false)
    private int ticketId;

    @Column(name = "eid")
    private int eventId;

    @Column(name = "vstid")
    private int venueSeatTypeId;

    @Column(name = "row_num")
    private int rowNum;  // 从0开始

    @Column(name = "col_num")
    private int columnNum;  // 从0开始

    @Column(name = "price")
    private double price;

    @Column(name = "is_online")
    private boolean isOnline = true;   // false表示为线下非会员购买

    @Column(name = "tstate")
    @Enumerated(value = EnumType.STRING)
    private TicketState ticketState = TicketState.NEW;

    public Ticket() {

    }

    public Ticket(int eventId, int venueSeatTypeId, int rowNum, int columnNum, double price) {
        this.eventId = eventId;
        this.venueSeatTypeId = venueSeatTypeId;
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        this.price = price;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int id) {
        this.ticketId = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getVenueSeatTypeId() {
        return venueSeatTypeId;
    }

    public void setVenueSeatTypeId(int venueSeatTypeId) {
        this.venueSeatTypeId = venueSeatTypeId;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public TicketState getTicketState() {
        return ticketState;
    }

    public void setTicketState(TicketState ticketState) {
        this.ticketState = ticketState;
    }
}
