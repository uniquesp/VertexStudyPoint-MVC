package com.dao;

import java.util.List;

import com.google.gson.JsonObject;
import com.model.LeaveFormDTO;
import com.model.StudentDTO;

public interface StudentDao {
	public boolean registerStudent(StudentDTO studentdto);
	public JsonObject loginStudent(StudentDTO studentdto);
	public List<StudentDTO> getAllUsers(StudentDTO studentdto);
	public boolean deleteStudent(int studentId);
	public List<StudentDTO> getAllFeedbacks(StudentDTO studentdto);
	public List<LeaveFormDTO> getAllLeaveDetails(LeaveFormDTO leavedto);

}
