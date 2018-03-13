package edu.nju.ticketbooking.model;

import javax.persistence.*;

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
    private int rowNum;

    @Column(name = "col_num")
    private int columnNum;

    @Column(name = "price")
    private double price;

    @Column(name = "is_checked")
    private boolean isChecked;

    @Column(name = "is_online")
    private boolean isOnline;   // false表示为线下非会员购买

//    @ManyToOne
//    @JoinColumn(name = "oid", updatable = false, insertable = false)
//    private Order order;

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

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
