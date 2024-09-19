package com.space.dao;

import com.space.table.Pet;

public interface PetDao {
	void insertPet();
	void deletePetById(int petId);
	void updatePetById(int petId);
	void findAllPets();
	Pet findPetById(int petId);

}
