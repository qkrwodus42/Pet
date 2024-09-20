package com.space.test;

import com.space.jdbcDao.JdbcSalonDao;
import com.space.table.Pet;
import com.space.table.Salon;

public class SalonTest {
	public static void main(String[] args) {
		Salon salon = new Salon();
		Pet pet = new Pet();
		JdbcSalonDao jdbcSalonDao = new JdbcSalonDao();
		
		salon.setSalonId(1);
		salon.setSalonName("Bella Beauty");
		salon.setSalonLoc("충무로");
		pet.setPetId(12);
		salon.setPet(pet);
		
		//#insert
		jdbcSalonDao.insertSalon(salon);
		
		//#delete
		jdbcSalonDao.deleteSalon(salon);
		
		//#update
		jdbcSalonDao.updateSalon(salon);
		
		//#find all
		System.out.println(jdbcSalonDao.findAllSalons());
		
		//#find by id
		System.out.println(jdbcSalonDao.findSalonById(1));
		
	}
}
