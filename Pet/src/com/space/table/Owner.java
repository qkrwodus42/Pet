package com.space.table;

public class Owner {
	private int ownerId;
	private String ownerName;
	
	public Owner() {}
	
	public Owner(int ownerId, String ownerName) {
		this.ownerId = ownerId;
		this.ownerName = ownerName;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + "]";
	}

	
}
