package com.space.dao;

import java.util.List;

import com.space.table.Owner;

public interface OwnerDao {
	void insertOwner(Owner owner);
	void deleteOwner(Owner owner);
	void updateOwner(Owner owner);
	List<Owner> findAllOwners();
	Owner findOwnerById(int ownerId);


}
