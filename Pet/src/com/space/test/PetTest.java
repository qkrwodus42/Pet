package com.space.test;

import com.space.jdbcDao.JdbcPetDao;
import com.space.table.Owner;
import com.space.table.Pet;

public class PetTest {
	public static void main(String[] args) {
		Pet pet = new Pet();
		Owner owner = new Owner();
		JdbcPetDao jdbcPetDao = new JdbcPetDao();
		
		pet.setPetId(13);
		pet.setPetName("두부");
		pet.setPetAge(1);
		pet.setPetGender("M");
		owner.setOwnerId(10);
		pet.setOwner(owner);
		
		//#insert
		jdbcPetDao.insertPet(pet);
		
		//#delete
		jdbcPetDao.deletePet(pet);
		
		//#update
		jdbcPetDao.updatePet(pet);
		
		//#find all
		System.out.println(jdbcPetDao.findAllPets());
		
		//#find by id
		System.out.println(jdbcPetDao.findPetById(11));
	}
}
