package edu.nju.ticketbooking.model;

public class Statistics {

    private int activatedUserNum,
            maleUserNum,
            femaleUserNum,
            approvedVenueNum;

    public Statistics() {
    }

    public Statistics(int activatedUserNum, int maleUserNum, int femaleUserNum, int approvedVenueNum) {
        this.activatedUserNum = activatedUserNum;
        this.maleUserNum = maleUserNum;
        this.femaleUserNum = femaleUserNum;
        this.approvedVenueNum = approvedVenueNum;
    }

    public int getActivatedUserNum() {
        return activatedUserNum;
    }

    public void setActivatedUserNum(int activatedUserNum) {
        this.activatedUserNum = activatedUserNum;
    }

    public int getMaleUserNum() {
        return maleUserNum;
    }

    public void setMaleUserNum(int maleUserNum) {
        this.maleUserNum = maleUserNum;
    }

    public int getFemaleUserNum() {
        return femaleUserNum;
    }

    public void setFemaleUserNum(int femaleUserNum) {
        this.femaleUserNum = femaleUserNum;
    }

    public int getApprovedVenueNum() {
        return approvedVenueNum;
    }

    public void setApprovedVenueNum(int approvedVenueNum) {
        this.approvedVenueNum = approvedVenueNum;
    }
}
