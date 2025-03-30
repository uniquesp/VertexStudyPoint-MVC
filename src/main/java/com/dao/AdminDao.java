package com.dao;

import com.google.gson.JsonObject;
import com.model.AdminDTO;

public interface AdminDao {

	public JsonObject loginAdmin(AdminDTO adminDTO);
	public JsonObject showCounts();
}
