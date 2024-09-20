package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.space.dao.PetDao;
import com.space.global.DataSource;
import com.space.table.Owner;
import com.space.table.Pet;

public class JdbcPetDao implements PetDao{

	@Override
	public void insertPet(Pet pet) {
	
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO PET VALUES (?, ?, ?, ?, ?)")){ 
				
			
				pStatement.setInt(1, pet.getPetId() );
				pStatement.setString(2, pet.getPetName());
				pStatement. setInt(3, pet.getPetAge());
				pStatement.setString(4, pet.getPetGender());
				pStatement.setInt(5, pet.getOwner().getOwnerId());
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
	}

	@Override
	public void deletePet(Pet pet) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE PET WHERE PET_ID = ?")) {
	            preparedStatement.setInt(1, pet.getPetId());
	            preparedStatement.executeUpdate();
	           
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void updatePet(Pet pet) {
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE PET SET PET_NAME = ?, PET_AGE = ?, PET_GENDER = ?, OWNER_ID = ? WHERE PET_ID = ?")){ 
    		
    		pStatement.setString(1, pet.getPetName());
    	
			pStatement.setInt(2, pet.getPetAge());
			
			pStatement.setString(3, pet.getPetGender());
			
			pStatement.setInt(4, pet.getOwner().getOwnerId());
			
		
			pStatement.setInt(5, pet.getPetId());
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public List<Pet> findAllPets() {
		
		List<Pet> pets = new ArrayList<Pet>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement(
						"SELECT * FROM PET ORDER BY PET_ID DESC");
				ResultSet rs = pStatement.executeQuery()) { 
			
			while(rs.next()) { 
				Pet pet = new Pet();
			
				pet.setPetId(rs.getInt("pet_id")); 
				pet.setPetName(rs.getString("pet_name"));
				pet.setPetAge(rs.getInt("pet_age"));
				pet.setPetGender(rs.getString("pet_gender"));
				
				Owner owner = new Owner();
				owner.setOwnerId(rs.getInt("owner_id"));
				pet.setOwner(owner);
				
				pets.add(pet);
			}
			for (Pet pet : pets) {
				System.out.println(pet);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return pets;
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
				
				owner.setOwnerId(rs.getInt("owner_id")); 
				pet.setOwner(owner); 
			}
				 
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return pet;
		
	}

}
