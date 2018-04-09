package edu.nju.ticketbooking.model;

import edu.nju.ticketbooking.constant.EventFilterType;

import java.sql.Timestamp;

public class EventFilter {

    private EventFilterType type;

    private Object condition;  // 若type为TYPE，则为EventType类型；若type为VENUE，则为int类型(venueId)

    private int pageNum, pageSize;

    private Timestamp fromTime, toTime;

    public EventFilter() {
    }

    public EventFilter(EventFilterType type, Object condition, int pageNum, int pageSize, Timestamp fromTime, Timestamp toTime) {
        this.type = type;
        this.condition = condition;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public EventFilterType getType() {
        return type;
    }

    public void setType(EventFilterType type) {
        this.type = type;
    }

    public Object getCondition() {
        return condition;
    }

    public void setCondition(Object condition) {
        this.condition = condition;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Timestamp getFromTime() {
        return fromTime;
    }

    public void setFromTime(Timestamp fromTime) {
        this.fromTime = fromTime;
    }

    public Timestamp getToTime() {
        return toTime;
    }

    public void setToTime(Timestamp toTime) {
        this.toTime = toTime;
    }
}
