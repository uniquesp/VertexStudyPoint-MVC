package com.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class StaffDTO {
    private int staff_id;
    private String staff_name;
    private String staff_email;
    private String phone_no;
    private String staff_work;
    private BigDecimal staff_salary;
    private Date joining_date;
    private String gender;
    private String address;
    
    
    
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_email() {
		return staff_email;
	}
	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getStaff_work() {
		return staff_work;
	}
	public void setStaff_work(String staff_work) {
		this.staff_work = staff_work;
	}
	public BigDecimal getStaff_salary() {
		return staff_salary;
	}
	public void setStaff_salary(BigDecimal staff_salary) {
		this.staff_salary = staff_salary;
	}
	public Date getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StaffDTO [staff_id=" + staff_id + ", staff_name=" + staff_name + ", staff_email=" + staff_email
				+ ", phone_no=" + phone_no + ", staff_work=" + staff_work + ", staff_salary=" + staff_salary
				+ ", joining_date=" + joining_date + ", gender=" + gender + ", address=" + address + "]";
	}

}

