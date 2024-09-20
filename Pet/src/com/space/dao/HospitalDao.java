package com.space.dao;

import java.util.List;

import com.space.table.Hospital;

public interface HospitalDao {
	void insertHospital(Hospital hospital);
	void deleteHospital(Hospital hospital);
	void updateHospital(Hospital hospital);
	List<Hospital> findAllHospitals();
	Hospital findHostpitalById(int hospitalId);

}
