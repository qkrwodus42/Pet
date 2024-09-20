package com.space.test;

import com.space.jdbcDao.JdbcPharmacyDao;
import com.space.table.Hospital;
import com.space.table.Pet;
import com.space.table.Pharmacy;

public class PharmacyTest {
	public static void main(String[] args) {
		Pharmacy pharmacy = new Pharmacy();
		Hospital hospital = new Hospital();
		Pet pet = new Pet();
		JdbcPharmacyDao jdbcPharmacyDao = new JdbcPharmacyDao();
		
		pharmacy.setPharmacyId(91);
		pharmacy.setPharmacyName("Good Pharmacy");
		pharmacy.setPharmacyLoc("America");
		hospital.setHospitalId(31);
		pharmacy.setHospital(hospital);
		pet.setPetId(11);
		pharmacy.setPet(pet);
		
		//#insert
		jdbcPharmacyDao.insertPharmacy(pharmacy);
		
		//#delete
		jdbcPharmacyDao.deletePharmacy(pharmacy);
		
		//#update
		jdbcPharmacyDao.updatePharmacy(pharmacy);
		
		//#find all
		System.out.println(jdbcPharmacyDao.findAllPharmacies());
		
		//#find by id
		System.out.println(jdbcPharmacyDao.findPharmacyById(91));
	}
}
