package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.model.StaffDTO;
import com.service.StaffService;
import com.service.StaffServiceImplementation;

@WebServlet("/staff")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/Admin-Login.jsp");
			return;
		}

		String operation = request.getParameter("method");
		switch (operation) {
		case "register_staff":
			registerOrUpdateStaff(request, response);
			break;
		case "delete_staff":
			deleteStaff(request, response);
			break;
		case "get_all_staff":
			getAllStaff(request, response);
			break;
		case "get_single_staff":
			getStaffById(request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected method value: " + operation);
		}
	}

	private void registerOrUpdateStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StaffDTO staffDTO = new StaffDTO();
		StaffService staffService = new StaffServiceImplementation();

		staffDTO.setStaff_name(StringUtils.trimToEmpty(request.getParameter("staff_name")));
		staffDTO.setStaff_email(StringUtils.trimToEmpty(request.getParameter("staff_email")));
		staffDTO.setPhone_no(StringUtils.trimToEmpty(request.getParameter("staff_mobileno")));
		staffDTO.setStaff_work(StringUtils.trimToEmpty(request.getParameter("staff_work_type")));
		staffDTO.setGender(StringUtils.trimToEmpty(request.getParameter("staff_gender")));
		staffDTO.setAddress(StringUtils.trimToEmpty(request.getParameter("staff_address")));

		String salary = request.getParameter("staff_salary");
		if (salary != null && !salary.isEmpty()) {
			staffDTO.setStaff_salary(new java.math.BigDecimal(salary));
		}

		String joiningDate = request.getParameter("staff_joining_date");
		if (joiningDate != null && !joiningDate.isEmpty()) {
			staffDTO.setJoining_date(java.sql.Date.valueOf(joiningDate)); // Ensure format is yyyy-MM-dd
		}

		JsonObject result;

		String staffIdStr = request.getParameter("staff_id");
		if (staffIdStr != null && !staffIdStr.isEmpty()) {
			staffDTO.setStaff_id(Integer.parseInt(staffIdStr));
			// Call update method
			result = staffService.staffProfileUpdate(staffDTO);
		} else {
			// Call register method
			result = staffService.staffRegister(staffDTO);
		}

		writeJsonResponse(response, result);
	}

	private void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int staffId = Integer.parseInt(request.getParameter("staff_id"));
		StaffService staffService = new StaffServiceImplementation();
		JsonObject result = staffService.staffProfileDelete(staffId);
		writeJsonResponse(response, result);
	}

	private void getAllStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StaffDTO staffDTO = new StaffDTO();
		StaffService staffService = new StaffServiceImplementation();
		JsonObject result = staffService.getAllStaff(staffDTO);
		writeJsonResponse(response, result);
	}

	private void getStaffById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StaffDTO staffDTO = new StaffDTO();
		int staffId = Integer.parseInt(request.getParameter("staff_id"));
		staffDTO.setStaff_id(staffId);
		StaffService staffService = new StaffServiceImplementation();
		JsonObject result = staffService.getStaffDetailsById(staffDTO);
		writeJsonResponse(response, result);
	}

	private void writeJsonResponse(HttpServletResponse response, JsonObject jsonObject) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try (PrintWriter writer = response.getWriter()) {
			writer.write(jsonObject.toString());
		}

	}

}
