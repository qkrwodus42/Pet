package com.space.jdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.space.dao.SalonDao;
import com.space.global.DataSource;
import com.space.table.Pet;
import com.space.table.Salon;

public class JdbcSalonDao implements SalonDao{

	@Override
	public void insertSalon(Salon salon) {
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO SALON VALUES (?, ?, ?, ?)")){ 
				
			
				pStatement.setInt(1, salon.getSalonId());
				pStatement.setString(2, salon.getSalonName());
				pStatement.setString(3, salon.getSalonLoc());
				pStatement.setInt(4, salon.getPet().getPetId());
		
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteSalon(Salon salon) {
		try (Connection connection = DataSource.getDataSource();
	             PreparedStatement preparedStatement
	                     = connection.prepareStatement("DELETE SALON WHERE SALON_ID = ?")) {
	            preparedStatement.setInt(1, salon.getSalonId());
	            preparedStatement.executeUpdate();
	          
	        }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		
	}

	@Override
	public void updateSalon(Salon salon) {
		
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE SALON SET SALON_NAME = ?, SALON_LOCATION = ?, PET_ID = ? WHERE SALON_ID = ?")){ 
    		
    		
    			pStatement.setString(1, salon.getSalonName());
    		
				pStatement.setString(2, salon.getSalonLoc());
			
				Pet pet = new Pet();
				pet.setPetId(pet.getPetId());
				salon.setPet(pet);
				pStatement.setInt(3, salon.getPet().getPetId());
			
			
			pStatement.setInt(4, salon.getSalonId());
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public List<Salon> findAllSalons() {
		List<Salon> salons = new ArrayList<Salon>();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM SALON ORDER BY SALON_ID DESC");
				ResultSet rs = pStatement.executeQuery()) {
			
			while(rs.next()) {
				Salon salon = new Salon();
			
				salon.setSalonId(rs.getInt("salon_id")); 
				salon.setSalonName(rs.getString("salon_name"));
				salon.setSalonLoc(rs.getString("salon_location"));
				
				Pet pet = new Pet();
				pet.setPetId(rs.getInt("pet_id")); 
				salon.setPet(pet); 
				
				salons.add(salon);
			}
			for (Salon salon : salons) {
				System.out.println(salons);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
				
		return salons;
		
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
