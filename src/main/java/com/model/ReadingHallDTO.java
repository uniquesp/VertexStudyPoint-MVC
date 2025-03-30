package com.model;

import java.sql.Timestamp;

public class ReadingHallDTO {
    private int hallId;
    private String hallType;
    private String seatNo;
    private String seatStatus;
    private Timestamp dateRegistered;

    // Default Constructor
    public ReadingHallDTO() {
    }

    // Parameterized Constructor
    public ReadingHallDTO(int hallId, String hallType, String seatNo, String seatStatus, Timestamp dateRegistered) {
        this.hallId = hallId;
        this.hallType = hallType;
        this.seatNo = seatNo;
        this.seatStatus = seatStatus;
        this.dateRegistered = dateRegistered;
    }

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

    public Timestamp getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Timestamp dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    // toString Method
    @Override
    public String toString() {
        return "ReadingHallDTO{" +
                "hallId=" + hallId +
                ", hallType='" + hallType + '\'' +
                ", seatNo='" + seatNo + '\'' +
                ", seatStatus='" + seatStatus + '\'' +
                ", dateRegistered=" + dateRegistered +
                '}';
    }
}
