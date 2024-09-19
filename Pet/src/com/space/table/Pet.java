package com.space.table;

public class Pet {
	private int petId;
	private String petName;
	private int petAge;
	private String petGender;
	private Owner owner;
	
	public Pet() {}
	
	public Pet(int petId, String petName, int petAge, String petGender, Owner owner) {
		this.petId = petId;
		this.petName = petName;
		this.petAge = petAge;
		this.petGender = petGender;
		this.owner = owner;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetGender() {
		return petGender;
	}

	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", petAge=" + petAge + ", petGender=" + petGender
				+ ", owner=" + owner + "]";
	}
	
	

}
