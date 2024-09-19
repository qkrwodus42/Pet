package com.space.table;

public class Pharmacy {
	private int pharmacyId;
	private String pharmacyName;
	private String pharmacyLoc;
	private Hospital hospital;
	private Pet pet;
	
	public Pharmacy() {}
	
	public Pharmacy(int pharmacyId, String pharmacyName, String pharmacyLoc, Hospital hospital, Pet pet) {
		this.pharmacyId = pharmacyId;
		this.pharmacyName = pharmacyName;
		this.pharmacyLoc = pharmacyLoc;
		this.hospital = hospital;
		this.pet = pet;
	}

	public int getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(int pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

	public String getPharmacyLoc() {
		return pharmacyLoc;
	}

	public void setPharmacyLoc(String pharmacyLoc) {
		this.pharmacyLoc = pharmacyLoc;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Pharmacy [pharmacyId=" + pharmacyId + ", pharmacyName=" + pharmacyName + ", pharmacyLoc=" + pharmacyLoc
				+ ", hospital=" + hospital + ", pet=" + pet + "]";
	}
	
	

}
