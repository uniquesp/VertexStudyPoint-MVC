package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.dao.StudentDaoImplementation;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.model.LeaveFormDTO;
import com.model.StudentDTO;

public class StudentServiceImplementation implements StudentService{

	@Override
	public JsonObject registerStudent(StudentDTO studentdto) {
		JsonObject responseJson = new JsonObject();
		StudentDao studentdao  = new StudentDaoImplementation();
		try {
			boolean userInserted = studentdao.registerStudent(studentdto);

			if (userInserted) {
				responseJson.addProperty("success", true);
				responseJson.addProperty("message", "User registered successfully");
			} else {
				responseJson.addProperty("success", false);
				responseJson.addProperty("message", "Failed to register Student");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseJson.addProperty("success", false);
			responseJson.addProperty("message", "An error occurred during student process");
		}

		return responseJson;
	}

	@Override
	public JsonObject getAllUser(StudentDTO studentdto) {
		List<StudentDTO> studentObject = new StudentDaoImplementation().getAllUsers(studentdto);
		JsonObject jsonObject = new JsonObject();
		Gson gson = new Gson();
		if (studentObject != null && !studentObject.isEmpty()) {
			jsonObject.addProperty("success", true);
			jsonObject.add("students", gson.toJsonTree(studentObject));
		} else {
			jsonObject.addProperty("success", false);
			jsonObject.addProperty("message", "No user found");
		}
		return jsonObject;
	}

	@Override
	public JsonObject studentProfileDelete(int StudentId) {
		JsonObject jsonObject = new JsonObject();
		StudentDao studentDao = new StudentDaoImplementation();
		boolean isStudentDeleted = studentDao.deleteStudent(StudentId);
		if (isStudentDeleted) {
			jsonObject.addProperty("success", true);
			jsonObject.addProperty("message", "Student deleted successfully");
		} else {
			jsonObject.addProperty("success", false);
			jsonObject.addProperty("message", "Failed to delete Student");
		}
		return jsonObject;
	}

	@Override
	public JsonObject getAllFeedbacks(StudentDTO studentdto) {
		List<StudentDTO> FeedbackObject = new StudentDaoImplementation().getAllFeedbacks(studentdto);
		JsonObject jsonObject = new JsonObject();
		Gson gson = new Gson();
		if (FeedbackObject != null && !FeedbackObject.isEmpty()) {
			jsonObject.addProperty("success", true);
			jsonObject.add("feedbacks", gson.toJsonTree(FeedbackObject));
		} else {
			jsonObject.addProperty("success", false);
			jsonObject.addProperty("message", "No feedback found");
		}
		return jsonObject;
	}
	
	@Override
	public JsonObject getAllLeaveDetails(LeaveFormDTO leaveFormdto) {
	    List<LeaveFormDTO> leaveDetailsList = new StudentDaoImplementation().getAllLeaveDetails(leaveFormdto);
	    JsonObject jsonObject = new JsonObject();
	    Gson gson = new Gson();

	    if (leaveDetailsList != null && !leaveDetailsList.isEmpty()) {
	        jsonObject.addProperty("success", true);
	        jsonObject.add("leaveDetails", gson.toJsonTree(leaveDetailsList));
	    } else {
	        jsonObject.addProperty("success", false);
	        jsonObject.addProperty("message", "No leave details found");
	    }

	    return jsonObject;
	}


}
