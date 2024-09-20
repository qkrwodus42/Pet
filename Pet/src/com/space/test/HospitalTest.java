package com.space.test;

import com.space.jdbcDao.JdbcHospitalDao;
import com.space.table.Hospital;
import com.space.table.Pet;

public class HospitalTest {
	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		JdbcHospitalDao jdbcHospitalDao = new JdbcHospitalDao();
		
		Pet pet = new Pet();
		
		hospital.setHospitalId(31);
		hospital.setHospitalName("Happy Hospital");
		hospital.setHospitalLoc("Seoul");
		hospital.setDiagnosis("injury");
		pet.setPetId(12);	
		hospital.setPet(pet);
		
		//#insert
		jdbcHospitalDao.insertHospital(hospital);

		//#delete
		jdbcHospitalDao.deleteHospital(hospital);
		
		//#update
		jdbcHospitalDao.updateHospital(hospital);
		
		//#find all
		System.out.println(jdbcHospitalDao.findAllHospitals());
		
		//#find by id
		System.out.println(jdbcHospitalDao.findHostpitalById(31));
	}
}
