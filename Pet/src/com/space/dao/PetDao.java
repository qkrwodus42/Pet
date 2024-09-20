package com.space.dao;

import java.util.List;

import com.space.table.Pet;

public interface PetDao {
	void insertPet(Pet pet);
	void deletePet(Pet pet);
	void updatePet(Pet pet);
	List<Pet> findAllPets();
	Pet findPetById(int petId);

}
