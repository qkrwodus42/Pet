package com.space.dao;

import com.space.table.Salon;

public interface SalonDao {
	void insertSalon();
	void deleteSalonById(int salonId);
	void updateSalonById(int salonId);
	void findAllSalons();
	Salon findSalonById(int salonId);

}
