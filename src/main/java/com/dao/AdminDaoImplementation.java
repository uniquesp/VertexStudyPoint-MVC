package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.JsonObject;
import com.model.AdminDTO;
import com.util.DbConnection;

public class AdminDaoImplementation implements AdminDao {

	@Override
	public JsonObject loginAdmin(AdminDTO adminDTO) {
		JsonObject jsonObject = new JsonObject();
		String ADMIN_LOGIN_SQL = "SELECT id FROM team WHERE is_deleted=0 AND admin_email=? AND admin_password=?";
		try {
			Connection connection = DbConnection.createConnection();
			jsonObject.addProperty("id", 0);
			jsonObject.addProperty("success", false);
			jsonObject.addProperty("message", "Failed to Login!!!");
			PreparedStatement preparedStatement = connection.prepareStatement(ADMIN_LOGIN_SQL);
			preparedStatement.setString(1, adminDTO.getEmail());
			preparedStatement.setString(2, adminDTO.getPassword());
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				jsonObject.addProperty("success", true);
				jsonObject.addProperty("id", result.getInt("id"));
				
			}
			result.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	@Override
	public JsonObject showCounts() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	

}
