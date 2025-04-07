package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
