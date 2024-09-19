package com.space.dao;

import com.space.table.Owner;

public interface OwnerDao {
	void insertOwner();
	void deleteOwnerById(int ownerId);
	void updateOwnerById(int ownerId);
	void findAllOwners();
	Owner findOwnerById(int ownerId);


}
