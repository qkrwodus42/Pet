package com.space.table;

public class Hospital {
	private int hospitalId;
	private String hospitalName;
	private String hospitalLoc;
	private String diagnosis;
	private Pet pet;
	
	public Hospital() {}
	
	public Hospital(int hospitalId, String hospitalName, String hospitalLoc, String diagnosis, Pet pet) {
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.hospitalLoc = hospitalLoc;
		this.diagnosis = diagnosis;
		this.pet = pet;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalLoc() {
		return hospitalLoc;
	}

	public void setHospitalLoc(String hospitalLoc) {
		this.hospitalLoc = hospitalLoc;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalLoc=" + hospitalLoc
				+ ", diagnosis=" + diagnosis + ", pet=" + pet + "]";
	}
	
	
	

}
