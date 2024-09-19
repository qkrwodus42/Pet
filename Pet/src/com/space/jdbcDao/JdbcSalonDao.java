package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.space.dao.SalonDao;
import com.space.global.AppFunction;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.table.Pet;
import com.space.table.Salon;

public class JdbcSalonDao implements SalonDao{

	@Override
	public void insertSalon() {
		System.out.println("Enter new salon id: ");
    	int inputId = AppFunction.inputInteger();
    	
    	System.out.println("Enter new salon name: ");
    	String inputName = AppFunction.inputString();
    	
    	System.out.println("Enter salon location: ");
    	String inputLoc = AppFunction.inputString();
    	
    	System.out.println("Enter pet id: ");
    	int inputPet = AppFunction.inputInteger();
    	
    	
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO SALON VALUES (?, ?, ?, ?)")){ 
				
			
				pStatement.setInt(1, inputId);
				pStatement.setString(2, inputName);
				pStatement.setString(3, inputLoc);
				pStatement.setInt(4, inputPet);
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteSalonById(int salonId) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE SALON WHERE SALON_ID = ?")) {
	            preparedStatement.setInt(1, salonId);
	            preparedStatement.executeUpdate();
	            AppUI.DeleteCompleteMessage();
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		
	}

	@Override
	public void updateSalonById(int salonId) {
		Salon salon = new Salon();
		JdbcSalonDao jdbcSalonDao = new JdbcSalonDao();
		
		salon = jdbcSalonDao.findSalonById(salonId);
		
    	System.out.println("Enter salon name to change: ");
    	String inputName = AppFunction.inputString();
    	
    	System.out.println("Enter salon location to change: ");
    	String inputLoc = AppFunction.inputString();
    	
    	System.out.println("Enter pet id to change: ");
    	int inputPet = AppFunction.inputInteger();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE SALON SET SALON_NAME = ?, SALON_LOCATION = ?, PET_ID = ? WHERE SALON_ID = ?")){ 
    		
    		if(!inputName.isEmpty()) {
    			pStatement.setString(1, inputName);
    		} else {
    			pStatement.setString(1, salon.getSalonName());
    		}
			if(!inputLoc.isEmpty()) {
				pStatement.setString(2, inputLoc);
			} else {
				pStatement.setString(2, salon.getSalonLoc());
			}
			if(inputPet == 0) {
				pStatement.setInt(3, inputPet);
			} else {
				Pet pet = new Pet();
				pet.setPetId(inputPet);
				salon.setPet(pet);
				pStatement.setInt(3, salon.getPet().getPetId());
			}
			
			pStatement.setInt(4, salonId);
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public void findAllSalons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Salon findSalonById(int salonId) {
		Salon salon = new Salon();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM SALON WHERE SALON_ID = ?"))
				{ 
			pStatement.setInt(1, salonId);		
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()) {
				
				Pet pet = new Pet();	
				
				salon.setSalonId(rs.getInt("salon_id")); 
				salon.setSalonName(rs.getString("salon_name"));
				salon.setSalonLoc(rs.getString("salon_location"));
				
				
			
				pet.setPetId(rs.getInt("pet_id")); 
				salon.setPet(pet); 
			
			}
				 
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return salon;

	}

}
