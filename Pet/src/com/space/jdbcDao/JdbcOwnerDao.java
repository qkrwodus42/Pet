package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.space.dao.OwnerDao;
import com.space.global.DataSource;
import com.space.table.Owner;

public class JdbcOwnerDao implements OwnerDao{

	@Override
	public void insertOwner(Owner owner) {
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO OWNER VALUES (?, ?)")){ 
				
			
				pStatement.setInt(1, owner.getOwnerId());
				pStatement.setString(2, owner.getOwnerName());
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
	}
		

	@Override
	public void deleteOwner(Owner owner) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE OWNER WHERE OWNER_ID = ?")) {
	            preparedStatement.setInt(1, owner.getOwnerId());
	            preparedStatement.executeUpdate();
	           
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void updateOwner(Owner owner) {
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE OWNER SET OWNER_NAME = ? WHERE PLACE_NO = ?")){ 
    		
			pStatement.setString(1, owner.getOwnerName());
			pStatement.setInt(2, owner.getOwnerId());
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public List<Owner> findAllOwners() {
		List<Owner> owners = new ArrayList<Owner>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(
						"SELECT * FROM OWNER ORDER BY OWNER_ID DESC");
				ResultSet rs = pStatement.executeQuery()) { 
			
			while(rs.next()) { 
				Owner owner = new Owner();
			
				owner.setOwnerId(rs.getInt("owner_id")); 
				owner.setOwnerName(rs.getString("owner_name"));
				
				owners.add(owner);
			}
			for (Owner owner : owners) {
				System.out.println(owner);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return owners;
		
	}

	@Override
	public Owner findOwnerById(int ownerId) {
		Owner owner = new Owner();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM OWNER WHERE OWNER_ID = ?"))
				{ 
			pStatement.setInt(1, ownerId);		
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()) {
				
				owner.setOwnerId(rs.getInt("owner_id")); 
				owner.setOwnerName(rs.getString("owner_name"));
				
			
			}
				 
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return owner;
		
	}
		
	

}
