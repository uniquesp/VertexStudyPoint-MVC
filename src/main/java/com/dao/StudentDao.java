package com.dao;

import com.google.gson.JsonObject;
import com.model.StudentDTO;

public interface StudentDao {
	public boolean registerStudent(StudentDTO studentdto);
	public JsonObject loginStudent(StudentDTO studentdto);

}
