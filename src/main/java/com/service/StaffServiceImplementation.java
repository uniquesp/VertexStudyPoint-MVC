package com.service;

import java.util.List;

import com.dao.StaffDao;
import com.dao.StaffDaoImplementation;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.model.StaffDTO;

public class StaffServiceImplementation implements StaffService {

	@Override
	public JsonObject staffRegister(StaffDTO staffDTO) {
		JsonObject responseJson = new JsonObject();
		StaffDao staffDao = new StaffDaoImplementation();

		try {
			boolean staffInsertedOrUpdated = staffDao.registerOrUpdateStaff(staffDTO);

			if (staffInsertedOrUpdated) {
				responseJson.addProperty("success", true);
				responseJson.addProperty("message", "Staff registered successfully");
			} else {
				responseJson.addProperty("success", false);
				responseJson.addProperty("message", "Failed to register or update staff");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseJson.addProperty("success", false);
			responseJson.addProperty("message", "An error occurred during staff processing");
		}

		return responseJson;
	}

	@Override
	public JsonObject staffProfileUpdate(StaffDTO staffDTO) {
		JsonObject responseJson = new JsonObject();
		StaffDao staffDao = new StaffDaoImplementation();

		try {
			boolean staffUpdated = staffDao.registerOrUpdateStaff(staffDTO);

			if (staffUpdated) {
				responseJson.addProperty("success", true);
				responseJson.addProperty("message", "Staff updated successfully");
			} else {
				responseJson.addProperty("success", false);
				responseJson.addProperty("message", "Failed to update staff");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseJson.addProperty("success", false);
			responseJson.addProperty("message", "An error occurred during staff process");
		}

		return responseJson;
	}

	@Override
	public JsonObject staffProfileDelete(int staffId) {
		JsonObject jsonObject = new JsonObject();
		StaffDao staffDao = new StaffDaoImplementation();
		boolean isStaffDeleted = staffDao.deleteStaff(staffId);

		if (isStaffDeleted) {
			jsonObject.addProperty("success", true);
			jsonObject.addProperty("message", "Staff deleted successfully");
		} else {
			jsonObject.addProperty("success", false);
			jsonObject.addProperty("message", "Failed to delete staff");
		}

		return jsonObject;
	}

	@Override
	public JsonObject getAllStaff(StaffDTO staffDTO) {
		List<StaffDTO> staffList = new StaffDaoImplementation().getAllStaff(staffDTO);
		JsonObject jsonObject = new JsonObject();
		Gson gson = new Gson();

		if (staffList != null && !staffList.isEmpty()) {
			jsonObject.addProperty("success", true);
			jsonObject.add("staff", gson.toJsonTree(staffList));
		} else {
			jsonObject.addProperty("success", false);
			jsonObject.addProperty("message", "No staff found");
		}

		return jsonObject;
	}

	@Override
	public JsonObject getStaffDetailsById(StaffDTO staffDTO) {
		JsonObject responseJson = new JsonObject();
		Gson gson = new Gson();
		StaffDao staffDao = new StaffDaoImplementation();

		try {
			List<StaffDTO> staffList = staffDao.getAllStaff(staffDTO);

			if (staffList != null && !staffList.isEmpty()) {
				responseJson.addProperty("success", true);
				responseJson.add("staff", gson.toJsonTree(staffList.get(0))); 
			} else {
				responseJson.addProperty("success", false);
				responseJson.addProperty("message", "Staff not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseJson.addProperty("success", false);
			responseJson.addProperty("message", "Error fetching staff details");
		}

		return responseJson;
	}

}
