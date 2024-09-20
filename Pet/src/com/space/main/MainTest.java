package com.space.main;

import com.space.jdbcDao.JdbcHospitalDao;
import com.space.jdbcDao.JdbcOwnerDao;
import com.space.jdbcDao.JdbcPetDao;
import com.space.table.Hospital;
import com.space.table.Owner;
import com.space.table.Pet;

public class MainTest {
	public static void main(String[] args) {
		Owner owner = new Owner();
		JdbcOwnerDao jdbcOwnerDao = new JdbcOwnerDao();
//		
//		owner.setOwnerId(20);
//		owner.setOwnerName("victoria");
//	
//		jdbcOwnerDao.insertOwner(owner);
		
		Pet pet = new Pet();
		JdbcPetDao jdbcPetDao = new JdbcPetDao();
		
//		pet.setPetId(12);
//		pet.setPetAge(5);
//		pet.setPetGender("F");
//		pet.setPetName("mozzi");
//		owner.setOwnerId(20);
//		pet.setOwner(owner);
//		jdbcPetDao.insertPet(pet);
//		System.out.println(pet);
//		System.out.println(jdbcPetDao.findAllPets());
		
		Hospital hospital = new Hospital(); 
		JdbcHospitalDao jdbcHospitalDao = new JdbcHospitalDao();
		
//		hospital.setHospitalId(31);
//		hospital.setHospitalName("Happy Hospital");
//		hospital.setHospitalLoc("Seoul");
//		hospital.setDiagnosis("injury");
//		pet.setPetId(12);
//		hospital.setPet(pet);
//		jdbcHospitalDao.insertHospital(hospital);
//		System.out.println(hospital);
//		
		//jdbcHospitalDao.updateHospital(hospital);
		//jdbcHospitalDao.deleteHospital(hospital);
		System.out.println(jdbcHospitalDao.findHostpitalById(31));
	}
}
