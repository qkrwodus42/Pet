package com.space.table;

public class Salon {
	private int salonId;
	private String salonName;
	private String salonLoc;
	private Pet pet;
	
	public Salon() {}
	
	public Salon(int salonId, String salonName, String salonLoc, Pet pet) {
		this.salonId = salonId;
		this.salonName = salonName;
		this.salonLoc = salonLoc;
		this.pet = pet;
	}

	public int getSalonId() {
		return salonId;
	}

	public void setSalonId(int salonId) {
		this.salonId = salonId;
	}

	public String getSalonName() {
		return salonName;
	}

	public void setSalonName(String salonName) {
		this.salonName = salonName;
	}

	public String getSalonLoc() {
		return salonLoc;
	}

	public void setSalonLoc(String salonLoc) {
		this.salonLoc = salonLoc;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Salon [salonId=" + salonId + ", salonName=" + salonName + ", salonLoc=" + salonLoc + ", pet=" + pet
				+ "]";
	}
	
	
	
}
