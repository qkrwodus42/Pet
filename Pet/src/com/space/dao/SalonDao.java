package com.space.dao;

import java.util.List;

import com.space.table.Salon;

public interface SalonDao {
	void insertSalon(Salon salon);
	void deleteSalon(Salon salon);
	void updateSalon(Salon salon);
	List<Salon> findAllSalons();
	Salon findSalonById(int salonId);

}
