package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.StaffDTO;
import com.util.DbConnection;

public class StaffDaoImplementation implements StaffDao {

	@Override
	public boolean registerOrUpdateStaff(StaffDTO staffDTO) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String INSERT_STAFF_SQL = "INSERT INTO staff (staff_name, staff_email, staff_mobileno, staff_work_type, staff_salary, staff_joining_date, staff_gender, staff_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		String UPDATE_STAFF_SQL = "UPDATE staff SET staff_name = ?, staff_email = ?, staff_mobileno = ?, staff_work_type = ?, staff_salary = ?, staff_joining_date = ?, staff_gender = ?, staff_address = ? WHERE staff_id = ?";

		boolean staffInserted = false;
		boolean staffUpdated = false;

		try {
			connection = DbConnection.createConnection();
			if (staffDTO.getStaff_id() != 0) {
				preparedStatement = connection.prepareStatement(UPDATE_STAFF_SQL);
			} else {
				preparedStatement = connection.prepareStatement(INSERT_STAFF_SQL);
			}

			// Common parameter bindings
			preparedStatement.setString(1, staffDTO.getStaff_name());
			preparedStatement.setString(2, staffDTO.getStaff_email());
			preparedStatement.setString(3, staffDTO.getPhone_no());
			preparedStatement.setString(4, staffDTO.getStaff_work());
			preparedStatement.setBigDecimal(5, staffDTO.getStaff_salary());
			preparedStatement.setDate(6, staffDTO.getJoining_date());
			preparedStatement.setString(7, staffDTO.getGender());
			preparedStatement.setString(8, staffDTO.getAddress());

			if (staffDTO.getStaff_id() != 0) {
				preparedStatement.setInt(9, staffDTO.getStaff_id());
				staffUpdated = preparedStatement.executeUpdate() > 0;
			} else {
				staffInserted = preparedStatement.executeUpdate() > 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return staffInserted || staffUpdated;
	}

	@Override
	public boolean deleteStaff(int staffId) {
		boolean deleteStaff = false;
		Connection connection = DbConnection.createConnection();
		String DELETE_STAFF_SQL = "UPDATE staff SET is_deleted = 1 WHERE staff_id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STAFF_SQL);
			preparedStatement.setInt(1, staffId);
			deleteStaff = preparedStatement.executeUpdate() > 0;
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
		return deleteStaff;
	}

	@Override
	public List<StaffDTO> getAllStaff(StaffDTO staffDto) {
		List<StaffDTO> staffList = new ArrayList<>();
		ResultSet resultSet = null;
		String SELECT_ALL_STAFF_SQL = "SELECT * FROM staff WHERE is_deleted=0";
		String SELECT_ONE_STAFF_SQL = "SELECT * FROM staff WHERE is_deleted=0 AND staff_id=?";

		try {
			Connection connection = DbConnection.createConnection();
			Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = null;

			if (staffDto.getStaff_id() != 0) {
				preparedStatement = connection.prepareStatement(SELECT_ONE_STAFF_SQL);
				preparedStatement.setInt(1, staffDto.getStaff_id());
				resultSet = preparedStatement.executeQuery();
			} else {
				resultSet = statement.executeQuery(SELECT_ALL_STAFF_SQL);
			}

			while (resultSet.next()) {
				StaffDTO staff = new StaffDTO();
				staff.setStaff_id(resultSet.getInt("staff_id"));
				staff.setStaff_name(resultSet.getString("staff_name"));
				staff.setStaff_email(resultSet.getString("staff_email"));
				staff.setPhone_no(resultSet.getString("staff_mobileno"));
				staff.setStaff_work(resultSet.getString("staff_work_type"));
				staff.setStaff_salary(resultSet.getBigDecimal("staff_salary"));
				staff.setJoining_date(resultSet.getDate("staff_joining_date"));
				staff.setGender(resultSet.getString("staff_gender"));
				staff.setAddress(resultSet.getString("staff_address"));
				staffList.add(staff);
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

		return staffList;
	}

}
