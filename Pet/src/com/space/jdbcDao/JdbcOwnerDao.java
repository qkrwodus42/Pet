package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.space.dao.OwnerDao;
import com.space.global.AppFunction;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.table.Hospital;
import com.space.table.Owner;
import com.space.table.Pet;
import com.space.table.Pharmacy;

public class JdbcOwnerDao implements OwnerDao{

	@Override
	public void insertOwner() {
		System.out.println("Enter new owner id: ");
    	int inputNum = AppFunction.inputInteger();
    	
    	System.out.println("Enter new owner name: ");
    	String inputWord = AppFunction.inputString();
    	
    	
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO OWNER VALUES (?, ?)")){ 
				
			
				pStatement.setInt(1, inputNum);
				pStatement.setString(2, inputWord);
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
	}
		

	@Override
	public void deleteOwnerById(int ownerId) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE OWNER WHERE OWNER_ID = ?")) {
	            preparedStatement.setInt(1, ownerId);
	            preparedStatement.executeUpdate();
	            AppUI.DeleteCompleteMessage();
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void updateOwnerById(int ownerId) {
    	System.out.println("Enter new owner name: ");
    	String inputWord = AppFunction.inputString();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE OWNER SET OWNER_NAME = ? WHERE PLACE_NO = ?")){ 
    		
			pStatement.setString(1, inputWord);
			pStatement.setInt(2, ownerId);
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public void findAllOwners() {
		// TODO Auto-generated method stub
		
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
