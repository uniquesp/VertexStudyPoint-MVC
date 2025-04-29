package com.model;


public class ReadingHallDTO {
    private int hallId;
    private String hallType;
    private String seatNo;
    private String seatStatus;


    // Getters and Setters
    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    // toString Method
    @Override
    public String toString() {
        return "ReadingHallDTO{" +
                "hallId=" + hallId +
                ", hallType='" + hallType + '\'' +
                ", seatNo='" + seatNo + '\'' +
                ", seatStatus='" + seatStatus + '\'' +
                '}';
    }
}
