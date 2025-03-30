package com.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class StaffDTO {
    private int stId;
    private String stName;
    private String emailId;
    private String contactNumber;
    private String stWork;
    private BigDecimal stSalary;
    private Date joiningDate;
    private String gender;
    private String addr;
    private Timestamp dateRegistered;

    // Getters and Setters
    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getStWork() {
        return stWork;
    }

    public void setStWork(String stWork) {
        this.stWork = stWork;
    }

    public BigDecimal getStSalary() {
        return stSalary;
    }

    public void setStSalary(BigDecimal stSalary) {
        this.stSalary = stSalary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Timestamp getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Timestamp dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "StaffDTO{" +
                "stId=" + stId +
                ", stName='" + stName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", stWork='" + stWork + '\'' +
                ", stSalary=" + stSalary +
                ", joiningDate=" + joiningDate +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                ", dateRegistered=" + dateRegistered +
                '}';
    }
}

