package com.space.dao;

import java.util.List;

import com.space.table.Pharmacy;

public interface PharmacyDao {
	void insertPharmacy(Pharmacy pharmacy);
	void deletePharmacy(Pharmacy pharmacy);
	void updatePharmacy(Pharmacy pharmacy);
	List<Pharmacy> findAllPharmacies();
	Pharmacy findPharmacyById(int pharmacyId);


}
