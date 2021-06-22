package com.xworkz.softdrinks_app.softdrink.service;

import java.util.List;

import com.xworkz.softdrinks_app.softdrink.dao.SoftDrinksDAO;
import com.xworkz.softdrinks_app.softdrink.dao.SoftDrinksDAOImpl;
import com.xworkz.softdrinks_app.softdrink.dto.SoftDrinksDTO;

public class SoftDrinksServiceImpl implements SoftDrinksService {
	private SoftDrinksDAO sDAO;
	
	public SoftDrinksServiceImpl() {
		sDAO = new SoftDrinksDAOImpl();
	}

	@Override
	public void validateAndSave(SoftDrinksDTO cDTO) {
		if(cDTO!=null) {
			sDAO.save(cDTO);
		}
		else {
			System.out.println("DTO cant be null");
		}
		

	}

	@Override
	public List<SoftDrinksDTO> validateAndGetAllDetails() {
		return sDAO.getAllDetails();
	}

	@Override
	public void validateAndUpdateColorByName(String name, int id, String color) {
		if(name!=null) {
			sDAO.updateColorByName(name,id,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

	@Override
	public void validateAndDeleteColorByName(String name, int id) {
		if(name!=null) {
			sDAO.deleteColorByName(name,id);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}


	
	
	
	

}
