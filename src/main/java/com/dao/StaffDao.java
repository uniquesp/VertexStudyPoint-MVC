package com.dao;

import java.util.List;

import com.model.StaffDTO;

public interface StaffDao {

	public boolean registerOrUpdateStaff(StaffDTO staffdto);

	public boolean deleteStaff(int staffId);

	public List<StaffDTO> getAllStaff(StaffDTO staffDto);

}
