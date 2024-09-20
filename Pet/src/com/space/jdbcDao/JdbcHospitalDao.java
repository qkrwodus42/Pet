package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.space.dao.HospitalDao;
import com.space.global.DataSource;
import com.space.table.Hospital;
import com.space.table.Pet;

public class JdbcHospitalDao implements HospitalDao{

	@Override
	public void insertHospital(Hospital hospital) {
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO HOSPITAL VALUES (?, ?, ?, ?, ?)")){ 
				
			
				pStatement.setInt(1, hospital.getHospitalId());
				pStatement.setString(2, hospital.getHospitalName());
				pStatement.setString(3, hospital.getHospitalLoc());
				pStatement.setString(4, hospital.getDiagnosis());
				pStatement.setInt(5, hospital.getPet().getPetId());
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteHospital(Hospital hospital) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE HOSPITAL WHERE HOSPITAL_ID = ?")) {
			
	            preparedStatement.setInt(1, hospital.getHospitalId());
	            preparedStatement.executeUpdate();
	            
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void updateHospital(Hospital hospital) {
		
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE HOSPITAL SET HOSPITAL_NAME = ?, HOSPITAL_LOCATION = ?, DIAGNOSIS = ?, PET_ID = ? WHERE HOSPITAL_ID = ?")){ 
    		
    		
    		pStatement.setString(1, hospital.getHospitalName());
    		
			
			pStatement.setString(2, hospital.getHospitalLoc());
			
			
			pStatement.setString(3, hospital.getDiagnosis());
			
			pStatement.setInt(4, hospital.getPet().getPetId());
			
			pStatement.setInt(5, hospital.getHospitalId());
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public List<Hospital> findAllHospitals() {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM HOSPITAL ORDER BY HOSPITAL_NO DESC");
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				Hospital hospital = new Hospital();
			
				hospital.setHospitalId(rs.getInt("hospital_id")); 
				hospital.setHospitalName(rs.getString("hospital_name"));
				hospital.setHospitalLoc(rs.getString("hospital_location"));
				hospital.setDiagnosis(rs.getString("diagnosis"));
				
				Pet pet = new Pet();
				pet.setPetId(rs.getInt("pet_id")); 
				hospital.setPet(pet); 
				
				hospitals.add(hospital);
			}
			for (Hospital hospital : hospitals) {
				System.out.println(hospitals);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
				
		return hospitals;
		
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
