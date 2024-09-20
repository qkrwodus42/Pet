package com.space.test;

import com.space.jdbcDao.JdbcOwnerDao;
import com.space.table.Owner;

public class OwnerTest {
	public static void main(String[] args) {
		Owner owner = new Owner();
		JdbcOwnerDao jdbcOwnerDao  = new JdbcOwnerDao();
		
		//# insert
		owner.setOwnerId(20);
		owner.setOwnerName("victoria");
		jdbcOwnerDao.insertOwner(owner);
		
		//#delete
		jdbcOwnerDao.deleteOwner(owner);
		
		//#update
		jdbcOwnerDao.updateOwner(owner);
		
		//#find all
		System.out.println(jdbcOwnerDao.findAllOwners());
		
		//#find by id
		System.out.println(jdbcOwnerDao.findOwnerById(20));
	}
}
