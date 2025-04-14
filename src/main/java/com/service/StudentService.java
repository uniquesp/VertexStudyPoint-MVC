package com.service;

import com.google.gson.JsonObject;
import com.model.StudentDTO;

public interface StudentService {
	public JsonObject registerStudent(StudentDTO studentdto );
	public JsonObject getAllUser(StudentDTO studentdto);
	public JsonObject studentProfileDelete(int StudentId);
}

