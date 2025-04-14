package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.model.StudentDTO;
import com.service.StudentService;
import com.service.StudentServiceImplementation;

@WebServlet(name = "student", urlPatterns = { "/student" })
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("method");
		switch(operation) {
			case "register_user":
				insertOrUpdateStudent(request,response);
				break;
			case "display_student":
				displayStudent(request, response);
				break;
			case "get_student":
				getStudent(request, response);
				break;
			case "delete_student":
				deleteStudent(request, response);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + operation);
		}
	}
	
	
	public void insertOrUpdateStudent(HttpServletRequest request, HttpServletResponse response) {
		StudentDTO studentDto = new StudentDTO();
		try {
			PrintWriter writer = response.getWriter();
			studentDto.setFirstName(StringUtils.trimToEmpty(request.getParameter("first_name")));
			studentDto.setLastName(StringUtils.trimToEmpty(request.getParameter("last_name")));
			studentDto.setEmailId(StringUtils.trimToEmpty(request.getParameter("user_email")));
			studentDto.setContactNo(StringUtils.trimToEmpty(request.getParameter("user_mobile")));
			studentDto.setGender(StringUtils.trimToEmpty(request.getParameter("user_gender")));
			studentDto.setAddress(StringUtils.trimToEmpty(request.getParameter("user_address")));
			studentDto.setPassword(StringUtils.trimToEmpty(request.getParameter("password")));
			String action = request.getParameter("action");
			StudentService userServiceInterface = new StudentServiceImplementation();
			if (action != null) {
				if (action.equalsIgnoreCase("register")) {
					String startDate = StringUtils.trimToEmpty(request.getParameter("Birth_Date"));
					if (StringUtils.isNotEmpty(startDate)) {
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date date = sdf1.parse(startDate);
						java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
						studentDto.setDob(sqlStartDate);
					}
					writer.write(userServiceInterface.registerStudent(studentDto).toString());
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
				}
//				} else if (action.equalsIgnoreCase("update")) {
//					studentDto.setUserid(Integer.parseInt(request.getParameter("userid")));
//					writer.write(userServiceInterface.userProfileUpdate(studentDto).toString());
//					response.setContentType("application/json");
//					response.setCharacterEncoding("UTF-8");
//				} 
				else {
					writer.write("<script>Something went wrong</script>");
				}
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void displayStudent(HttpServletRequest request, HttpServletResponse response) {
		StudentDTO studentdto = new StudentDTO();
		StudentService userServiceInterface = new StudentServiceImplementation();
		try {
			PrintWriter writer = response.getWriter();
			writer.write(userServiceInterface.getAllUser(studentdto).toString());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getStudent(HttpServletRequest request, HttpServletResponse response) {
		StudentDTO studentdto = new StudentDTO();
		int id = Integer.parseInt(request.getParameter("student_id"));
		studentdto.setStudentId(id);
		try {
			PrintWriter writer = response.getWriter();
			StudentService studentinterface = new StudentServiceImplementation();
			writer.write(studentinterface.getAllUser(studentdto).toString());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("student_id"));
		try {
			PrintWriter writer = response.getWriter();
			StudentService studentServiceInterface = new StudentServiceImplementation();
			writer.write(studentServiceInterface.studentProfileDelete(id).toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	}
		
}

