package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.space.dao.PharmacyDao;
import com.space.global.DataSource;
import com.space.table.Hospital;
import com.space.table.Pet;
import com.space.table.Pharmacy;

public class JdbcPharmacyDao implements PharmacyDao{

	@Override
	public void insertPharmacy(Pharmacy pharmacy) {
	
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO PHARMACY VALUES (?, ?, ?, ?, ?)")){ 
				
			
				pStatement.setInt(1, pharmacy.getPharmacyId());
				pStatement.setString(2, pharmacy.getPharmacyName());
				pStatement.setString(3, pharmacy.getPharmacyLoc());
				pStatement.setInt(4, pharmacy.getHospital().getHospitalId());
				pStatement.setInt(5, pharmacy.getPet().getPetId());
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void deletePharmacy(Pharmacy pharmacy) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE PHARMACY WHERE PHARMACY_ID = ?")) {
	            preparedStatement.setInt(1, pharmacy.getPharmacyId());
	            preparedStatement.executeUpdate();
	           
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void updatePharmacy(Pharmacy pharmacy) {
		
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE PARMACY SET PHARMACY_NAME = ?, PHARMACY_LOCATION = ?, HOSPITAL_ID = ?, PET_ID = ? WHERE PHARMACY_ID = ?")){ 
    		
    	
    			pStatement.setString(1, pharmacy.getPharmacyName());
    		
				pStatement.setString(2, pharmacy.getPharmacyLoc());
			
				Hospital hospital = new Hospital();
				hospital.setHospitalId(hospital.getHospitalId());
				pharmacy.setHospital(hospital);
				pStatement.setInt(3, pharmacy.getHospital().getHospitalId());
			
				Pet pet = new Pet();
				pet.setPetId(pet.getPetId());
				pharmacy.setPet(pet);
				pStatement.setInt(4, pharmacy.getPet().getPetId());
			
			
			pStatement.setInt(5, pharmacy.getPharmacyId());
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		
	}

	@Override
	public List<Pharmacy> findAllPharmacies() {
		List<Pharmacy> pharmacies = new ArrayList<Pharmacy>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM PHARMACY ORDER BY PHARMACY_ID DESC");
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				Pharmacy pharmacy = new Pharmacy();
			
				pharmacy.setPharmacyId(rs.getInt("hospital_id")); 
				pharmacy.setPharmacyName(rs.getString("hospital_name"));
				pharmacy.setPharmacyLoc(rs.getString("hospital_location"));
				
				Hospital hospital = new Hospital();
				hospital.setHospitalId(rs.getInt("hospital_id"));
				pharmacy.setHospital(hospital);
				
				Pet pet = new Pet();
				pet.setPetId(rs.getInt("pet_id")); 
				pharmacy.setPet(pet); 
				
				pharmacies.add(pharmacy);
			}
			for (Pharmacy pharmacy : pharmacies) {
				System.out.println(pharmacies);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
				
		return pharmacies;
		
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
