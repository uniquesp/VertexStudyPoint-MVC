package com.service;

import com.google.gson.JsonObject;
import com.model.StaffDTO;

public interface StaffService {

	public JsonObject staffRegister(StaffDTO staffDTO);

	public JsonObject staffProfileUpdate(StaffDTO staffDTO);

	public JsonObject staffProfileDelete(int staffId);

	public JsonObject getAllStaff(StaffDTO staffDTO);

	public JsonObject getStaffDetailsById(StaffDTO staffDTO);
}
