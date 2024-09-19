package com.space.dao;

import com.space.table.Hospital;

public interface HospitalDao {
	void insertHospital();
	void deleteHospitalById(int hospitalId);
	void updateHospitalById(int hospitalId);
	void findAllHospitals();
	Hospital findHostpitalById(int hospitalId);

}
