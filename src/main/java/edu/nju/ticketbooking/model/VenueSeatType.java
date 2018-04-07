package edu.nju.ticketbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "venue_seat_types")
public class VenueSeatType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vstid", updatable = false)
    private int venueSeatTypeId;

    @Column(name = "vid")
    private int venueId;

    @Column(name = "stype")
    private String seatType;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_row")
    private int totalRowNum;

    @Column(name = "total_col")
    private int totalColumnNum;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public VenueSeatType() {
    }

    public VenueSeatType(int venueId, String seatType, int quantity, int totalRowNum, int totalColumnNum) {
        this.venueId = venueId;
        this.seatType = seatType;
        this.quantity = quantity;
        this.totalRowNum = totalRowNum;
        this.totalColumnNum = totalColumnNum;
    }

    public int getVenueSeatTypeId() {
        return venueSeatTypeId;
    }

    public void setVenueSeatTypeId(int id) {
        this.venueSeatTypeId = id;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalRowNum() {
        return totalRowNum;
    }

    public void setTotalRowNum(int totalRowNum) {
        this.totalRowNum = totalRowNum;
    }

    public int getTotalColumnNum() {
        return totalColumnNum;
    }

    public void setTotalColumnNum(int totalColumnNum) {
        this.totalColumnNum = totalColumnNum;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
