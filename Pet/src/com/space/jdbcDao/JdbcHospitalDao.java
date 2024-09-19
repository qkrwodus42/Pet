package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.space.dao.HospitalDao;
import com.space.global.AppFunction;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.table.Hospital;
import com.space.table.Pet;

public class JdbcHospitalDao implements HospitalDao{

	@Override
	public void insertHospital() {
		System.out.println("Enter new hospital id: ");
    	int inputId = AppFunction.inputInteger();
    	
    	System.out.println("Enter new hospital name: ");
    	String inputName = AppFunction.inputString();
    	
    	System.out.println("Enter hospital location: ");
    	String inputLoc = AppFunction.inputString();
    	
    	System.out.println("Enter diagnosis: ");
    	String inputDia = AppFunction.inputString();
    	
    	System.out.println("Enter pet id: ");
    	int inputPet = AppFunction.inputInteger();
    	
    	
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO HOSPITAL VALUES (?, ?, ?, ?, ?)")){ 
				
			
				pStatement.setInt(1, inputId);
				pStatement.setString(2, inputName);
				pStatement.setString(3, inputLoc);
				pStatement.setString(4, inputDia);
				pStatement.setInt(5, inputPet);
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteHospitalById(int hospitalId) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE HOSPITAL WHERE HOSPITAL_ID = ?")) {
	            preparedStatement.setInt(1, hospitalId);
	            preparedStatement.executeUpdate();
	            AppUI.DeleteCompleteMessage();
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void updateHospitalById(int hospitalId) {
		Hospital hospital = new Hospital();
		JdbcHospitalDao jdbcHospitalDao = new JdbcHospitalDao();
		
		hospital = jdbcHospitalDao.findHostpitalById(hospitalId);
		
    	System.out.println("Enter hospital name to change: ");
    	String inputName = AppFunction.inputString();
    	
    	System.out.println("Enter hospital location to change: ");
    	String inputLoc = AppFunction.inputString();
    	
    	System.out.println("Enter diagnosis to change: ");
    	String inputDia = AppFunction.inputString();
    	
    	System.out.println("Enter pet id to change: ");
    	int inputPet = AppFunction.inputInteger();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE HOSPITAL SET HOSPITAL_NAME = ?, HOSPITAL_LOCATION = ?, DIAGNOSIS = ?, PET_ID = ? WHERE HOSPITAL_ID = ?")){ 
    		
    		if(!inputName.isEmpty()) {
    			pStatement.setString(1, inputName);
    		} else {
    			pStatement.setString(1, hospital.getHospitalName());
    		}
			if(!inputLoc.isEmpty()) {
				pStatement.setString(2, inputLoc);
			} else {
				pStatement.setString(2, hospital.getHospitalLoc());
			}
			if(!inputDia.isEmpty()) {
				pStatement.setString(3, inputDia);
			} else {
				pStatement.setString(3, hospital.getDiagnosis());
			}
			if(inputPet == 0) {
				Pet pet = new Pet();
				pet.setPetId(inputPet);
				hospital.setPet(pet);
				pStatement.setInt(4, hospital.getPet().getPetId());
			} else {
				pStatement.setInt(4, inputPet);
			}
			
			pStatement.setInt(5, hospitalId);
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public void findAllHospitals() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hospital findHostpitalById(int hospitalId) {
		Hospital hospital = new Hospital();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM HOSPITAL WHERE HOSPITAL_ID = ?"))
				{ 
			pStatement.setInt(1, hospitalId);		
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()) {
				
				Pet pet = new Pet();
				
				hospital.setHospitalId(rs.getInt("hospital_id")); 
				hospital.setHospitalName(rs.getString("hospital_name"));
				hospital.setHospitalLoc(rs.getString("hospital_location"));
				hospital.setDiagnosis(rs.getString("diagnosis"));
				
				pet.setPetId(rs.getInt("pet_id")); 
				hospital.setPet(pet); 
			
			}
				 
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return hospital;
		
	}

}
