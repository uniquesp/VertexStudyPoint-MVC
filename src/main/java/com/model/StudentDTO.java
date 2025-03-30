package com.model;

import java.sql.Timestamp;
import java.util.Date;

public class StudentDTO {
    private int sId;
    private String firstName;
    private String lastName;
    private String email_id;
    private String phone_no;
    private String gender;
    private Date dob;
    private String address;
    private String study;
    private String hallType;
    private String seatNo;
    private String password;
    private Timestamp dateRegistered;

    // Default Constructor
    public StudentDTO() {
    }

    // Parameterized Constructor
    public StudentDTO(int sId, String firstName, String lastName, String emailId, String contactNo, 
                      String gender, Date dob, String address, String study, String hallType, 
                      String seatNo, String password, Timestamp dateRegistered) {
        this.sId = sId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email_id = emailId;
        this.phone_no = contactNo;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.study = study;
        this.hallType = hallType;
        this.seatNo = seatNo;
        this.password = password;
        this.dateRegistered = dateRegistered;
    }

    // Getters and Setters
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return email_id;
    }

    public void setEmailId(String emailId) {
        this.email_id = emailId;
    }

    public String getContactNo() {
        return phone_no;
    }

    public void setContactNo(String contactNo) {
        this.phone_no = contactNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "StudentDTO{" +
                "sId=" + sId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + email_id + '\'' +
                ", contactNo='" + phone_no + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", study='" + study + '\'' +
                ", hallType='" + hallType + '\'' +
                ", seatNo='" + seatNo + '\'' +
                ", password='" + password + '\'' +
                ", dateRegistered=" + dateRegistered +
                '}';
    }
}
