package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.model.StudentDTO;
import com.util.DbConnection;

public class StudentDaoImplementation implements StudentDao{

	@Override
	public boolean registerStudent(StudentDTO studentdto) {
		PreparedStatement preparedStatement = null;
		String INSERT_STUDENT_SQL = "INSERT INTO student (student_first_name,student_last_name,student_email,student_mobileno,student_gender,student_birthdate,student_address,study,password) VALUES(?,?,?,?,?,?,?)";
		boolean user_inserted = false;
		try (Connection connection = DbConnection.createConnection();) {
			preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
			preparedStatement.setString(1, studentdto.getFirstName());
			preparedStatement.setString(2, studentdto.getLastName());
			preparedStatement.setString(3, studentdto.getEmailId());
			preparedStatement.setString(4, studentdto.getContactNo());
			preparedStatement.setString(5, studentdto.getGender());
			preparedStatement.setDate(6, (Date) studentdto.getDob());
			preparedStatement.setString(7, studentdto.getAddress());
			preparedStatement.setString(8, studentdto.getStudy());
			preparedStatement.setString(9, studentdto.getPassword());
			user_inserted = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user_inserted;

		
	}

	@Override
	public JsonObject loginStudent(StudentDTO studentdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> getAllUsers(StudentDTO studentdto) {
		List<StudentDTO> studentList = new ArrayList<>();
		ResultSet resultSet = null;
		String SELECT_ALL_USERS_SQL = "SELECT * FROM student WHERE is_deleted=0";
		String SELECT_ONE_USER_SQL = "SELECT * FROM student WHERE is_deleted=0 AND student_id=?";
		try {
			Connection connection = DbConnection.createConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;
			if (studentdto.getStudentId() != 0) {
				preparedStatement = connection.prepareStatement(SELECT_ONE_USER_SQL);
				preparedStatement.setInt(1, studentdto.getStudentId());
				resultSet = preparedStatement.executeQuery();
			} else {
				resultSet = statement.executeQuery(SELECT_ALL_USERS_SQL);
			}
			while (resultSet.next()) {
				StudentDTO StudentDTO2 = new StudentDTO();
				StudentDTO2.setStudentId(Integer.parseInt(resultSet.getString("student_id")));
				StudentDTO2.setFirstName(resultSet.getString("student_first_name"));
				StudentDTO2.setLastName(resultSet.getString("student_last_name"));
				StudentDTO2.setEmailId(resultSet.getString("student_email"));
				StudentDTO2.setContactNo(resultSet.getString("student_mobileno"));
				StudentDTO2.setGender(resultSet.getString("student_gender"));
				StudentDTO2.setDob(resultSet.getDate("student_birthdate"));
				StudentDTO2.setAddress(resultSet.getString("student_address"));
				StudentDTO2.setStudy(resultSet.getString("study"));			
				studentList.add(StudentDTO2);
			}
			statement.close();
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return studentList;
	}
	
	
	@Override
	public boolean deleteStudent(int studentId) {
		boolean deleteStudent = false;
		Connection connection = DbConnection.createConnection();
		String DELETE_STUDENT_SQl = "UPDATE student SET is_deleted=1 WHERE student_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQl);
			preparedStatement.setInt(1, studentId);
			deleteStudent = preparedStatement.executeUpdate() > 0;
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return deleteStudent;
	}

}
