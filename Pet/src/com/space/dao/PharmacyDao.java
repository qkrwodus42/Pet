package com.space.dao;

import com.space.table.Pharmacy;

public interface PharmacyDao {
	void insertPharmacy();
	void deletePharmacyById(int pharmacyId);
	void updatePharmacyById(int pharmacyId);
	void findAllPharmacies();
	Pharmacy findPharmacyById(int pharmacyId);


}
