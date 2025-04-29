package com.model;

import java.sql.Date;

public class LeaveFormDTO {

	private int library_leave_id;
	private int hall_id;
	private String hall_type;
	private String seat_no;
	private Date library_leave_date;
	private int student_id;
	private StudentDTO studentdto;
	
	
	public int getLibrary_leave_id() {
		return library_leave_id;
	}
	public void setLibrary_leave_id(int library_leave_id) {
		this.library_leave_id = library_leave_id;
	}
	public int getHall_id() {
		return hall_id;
	}
	public void setHall_id(int hall_id) {
		this.hall_id = hall_id;
	}
	public String getHall_type() {
		return hall_type;
	}
	public void setHall_type(String hall_type) {
		this.hall_type = hall_type;
	}
	public String getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}
	public Date getLibrary_leave_date() {
		return library_leave_date;
	}
	public void setLibrary_leave_date(Date library_leave_date) {
		this.library_leave_date = library_leave_date;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public StudentDTO getStudentdto() {
		return studentdto;
	}
	public void setStudentdto(StudentDTO studentdto) {
		this.studentdto = studentdto;
	}
	
	
	@Override
	public String toString() {
		return "LeaveFormDTO [library_leave_id=" + library_leave_id + ", hall_id=" + hall_id + ", hall_type="
				+ hall_type + ", seat_no=" + seat_no + ", library_leave_date=" + library_leave_date + ", student_id="
				+ student_id + ", studentdto=" + studentdto + "]";
	}
	
	

}
