package com.model;

import java.sql.Timestamp;
import java.util.Date;

public class StudentDTO {
    private int student_id;
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


    // Getters and Setters
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

	public int getStudentId() {
		return student_id;
	}

	public void setStudentId(int student_id) {
		this.student_id = student_id;
	}

	@Override
	public String toString() {
		return "StudentDTO [student_id=" + student_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email_id=" + email_id + ", phone_no=" + phone_no + ", gender=" + gender + ", dob=" + dob
				+ ", address=" + address + ", study=" + study + ", hallType=" + hallType + ", seatNo=" + seatNo
				+ ", password=" + password + ", dateRegistered=" + dateRegistered + "]";
	}

 
   
}
