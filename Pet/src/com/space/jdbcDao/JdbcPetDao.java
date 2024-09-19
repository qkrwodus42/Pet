package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.space.dao.PetDao;
import com.space.global.AppFunction;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.table.Owner;
import com.space.table.Pet;

public class JdbcPetDao implements PetDao{

	@Override
	public void insertPet() {
		System.out.println("Enter new pet id: ");
    	int inputId = AppFunction.inputInteger();
    	
    	System.out.println("Enter new pet name: ");
    	String inputName = AppFunction.inputString();
    	
    	System.out.println("Enter new pet age: ");
    	int inputAge = AppFunction.inputInteger();
    	
    	System.out.println("Enter new pet gender: ");
    	String inputGender = AppFunction.inputString();
    	
    	System.out.println("Enter owner id: ");
    	int inputOwner = AppFunction.inputInteger();
    	
    	
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO PET VALUES (?, ?, ?, ?, ?)")){ 
				
			
				pStatement.setInt(1, inputId);
				pStatement.setString(2, inputName);
				pStatement.setInt(3, inputAge);
				pStatement.setString(4, inputGender);
				pStatement.setInt(5, inputOwner);
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
	}

	@Override
	public void deletePetById(int petId) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE PET WHERE PET_ID = ?")) {
	            preparedStatement.setInt(1, petId);
	            preparedStatement.executeUpdate();
	            AppUI.DeleteCompleteMessage();
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void updatePetById(int petId) {
		Pet pet = new Pet();
		JdbcPetDao jdbcPetDao = new JdbcPetDao();
		
		pet = jdbcPetDao.findPetById(petId);
		
    	System.out.println("Enter pet name to change: ");
    	String inputName = AppFunction.inputString();
    	
    	System.out.println("Enter pet age to change: ");
    	int inputAge = AppFunction.inputInteger();
    	
    	System.out.println("Enter pet gender to change: ");
    	String inputGender = AppFunction.inputString();
    	
    	System.out.println("Enter owner id to change: ");
    	int inputOwner = AppFunction.inputInteger();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE PET SET PET_NAME = ?, PET_AGE = ?, PET_GENDER = ?, OWNER_ID = ? WHERE PET_ID = ?")){ 
    		
    		if(!inputName.isEmpty()) {
    			pStatement.setString(1, inputName);
    		} else {
    			pStatement.setString(1, pet.getPetName());
    		}
			if(inputAge == 0) {
				pStatement.setInt(2, inputAge);
			} else {
				pStatement.setInt(2, pet.getPetAge());
			}
			if(!inputGender.isEmpty()) {
				pStatement.setString(3, inputGender);
			} else {
				pStatement.setString(3, pet.getPetGender());
			}
			if(inputOwner == 0) {
				pStatement.setInt(4, inputOwner);
			} else {
				Owner owner = new Owner();
				owner.setOwnerId(inputOwner);
				pet.setOwner(owner);
				pStatement.setInt(4, pet.getOwner().getOwnerId());
			}
			
			pStatement.setInt(5, petId);
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public void findAllPets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet findPetById(int petId) {
		Pet pet = new Pet();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM PET WHERE PET_ID = ?"))
				{ 
			pStatement.setInt(1, petId);		
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()) {
				
				Owner owner = new Owner();
				
				pet.setPetId(rs.getInt("pet_id")); 
				pet.setPetName(rs.getString("pet_name"));
				pet.setPetAge(rs.getInt("pet_age"));
				pet.setPetGender(rs.getString("pet_gender"));
				
				owner.setOwnerId(rs.getInt("owner_id")); //owner의 owner_id를 먼저 갖고와
				pet.setOwner(owner); //그 다음에 위 객체를 pet이 가져와
			
			}
				 
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return pet;
		
	}

}
