package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.space.dao.PharmacyDao;
import com.space.global.AppFunction;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.table.Hospital;
import com.space.table.Pet;
import com.space.table.Pharmacy;

public class JdbcPharmacyDao implements PharmacyDao{

	@Override
	public void insertPharmacy() {
		System.out.println("Enter new pharmacy id: ");
    	int inputId = AppFunction.inputInteger();
    	
    	System.out.println("Enter new pharmacy name: ");
    	String inputName = AppFunction.inputString();
    	
    	System.out.println("Enter pharmacy location: ");
    	String inputLoc = AppFunction.inputString();
    	
    	System.out.println("Enter hospital in charge: ");
    	int inputHos = AppFunction.inputInteger();
    	
    	System.out.println("Enter pet id: ");
    	int inputPet = AppFunction.inputInteger();
    	
    	
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO PHARMACY VALUES (?, ?, ?, ?, ?)")){ 
				
			
				pStatement.setInt(1, inputId);
				pStatement.setString(2, inputName);
				pStatement.setString(3, inputLoc);
				pStatement.setInt(4, inputHos);
				pStatement.setInt(5, inputPet);
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void deletePharmacyById(int pharmacyId) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE PHARMACY WHERE PHARMACY_ID = ?")) {
	            preparedStatement.setInt(1, pharmacyId);
	            preparedStatement.executeUpdate();
	            AppUI.DeleteCompleteMessage();
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void updatePharmacyById(int pharmacyId) {
		Pharmacy pharmacy = new Pharmacy();
		JdbcPharmacyDao jdbcPharmacyDao = new JdbcPharmacyDao();
		
		pharmacy = jdbcPharmacyDao.findPharmacyById(pharmacyId);
		
    	System.out.println("Enter pharmacy name to change: ");
    	String inputName = AppFunction.inputString();
    	
    	System.out.println("Enter pharmacy location to change: ");
    	String inputLoc = AppFunction.inputString();
    	
    	System.out.println("Enter hospital id in charge to change: ");
    	int inputHos = AppFunction.inputInteger();
    	
    	System.out.println("Enter pet id to change: ");
    	int inputPet = AppFunction.inputInteger();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE PARMACY SET PHARMACY_NAME = ?, PHARMACY_LOCATION = ?, HOSPITAL_ID = ?, PET_ID = ? WHERE PHARMACY_ID = ?")){ 
    		
    		if(!inputName.isEmpty()) {
    			pStatement.setString(1, inputName);
    		} else {
    			pStatement.setString(1, pharmacy.getPharmacyName());
    		}
			if(!inputLoc.isEmpty()) {
				pStatement.setString(2, inputLoc);
			} else {
				pStatement.setString(2, pharmacy.getPharmacyLoc());
			}
			if(inputHos == 0) {
				Hospital hospital = new Hospital();
				hospital.setHospitalId(inputHos);
				pharmacy.setHospital(hospital);
				pStatement.setInt(3, pharmacy.getHospital().getHospitalId());
			} else {
				pStatement.setInt(3, inputHos);
			}
			if(inputPet == 0) {
				pStatement.setInt(4, inputPet);
			} else {
				Pet pet = new Pet();
				pet.setPetId(inputPet);
				pharmacy.setPet(pet);
				pStatement.setInt(4, pharmacy.getPet().getPetId());
			}
			
			pStatement.setInt(5, pharmacyId);
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		
	}

	@Override
	public void findAllPharmacies() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pharmacy findPharmacyById(int pharmacyId) {
		Pharmacy pharmacy = new Pharmacy();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM PHARMACY WHERE PHARMACY_ID = ?"))
				{ 
			pStatement.setInt(1, pharmacyId);		
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()) {
				
				Pet pet = new Pet();	
				Hospital hospital = new Hospital();
				
				pharmacy.setPharmacyId(rs.getInt("hospital_id")); 
				pharmacy.setPharmacyName(rs.getString("hospital_name"));
				pharmacy.setPharmacyLoc(rs.getString("hospital_location"));
				
				
				hospital.setHospitalId(rs.getInt("hospital_id"));
				pharmacy.setHospital(hospital);
				
				pet.setPetId(rs.getInt("pet_id")); 
				pharmacy.setPet(pet); 
			
			}
				 
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return pharmacy;
		
	}

}
