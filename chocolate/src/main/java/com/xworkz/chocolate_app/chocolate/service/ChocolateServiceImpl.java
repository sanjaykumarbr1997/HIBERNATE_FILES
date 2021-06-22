package com.xworkz.chocolate_app.chocolate.service;

import java.util.List;

import com.xworkz.chocolate_app.chocolate.dao.ChocolateDAO;
import com.xworkz.chocolate_app.chocolate.dao.ChocolateDAOImpl;
import com.xworkz.chocolate_app.chocolate.dto.ChocoloateDTO;

public class ChocolateServiceImpl implements ChocolateService {
	
	private ChocolateDAO cDAO;
	public ChocolateServiceImpl() {
		cDAO = new ChocolateDAOImpl();
	}

	@Override
	public void validateAndSave(ChocoloateDTO cDTO) {
		if(cDTO!=null) {
			cDAO.save(cDTO);
		}
		else {
			System.out.println("DTO cant be null");
		}
		

	}

	@Override
	public List<ChocoloateDTO> validateAndGetAllDetails() {
		return cDAO.getAllDetails();
	}

	@Override
	public void validateAndUpdateColorByName(String name, int id, String color) {
		if(name!=null) {
			cDAO.updateColorByName(name,id,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

	@Override
	public void validateAndDeleteColorByName(String name, int id) {
		if(name!=null) {
			cDAO.deleteColorByName(name,id);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}

	
	

}
