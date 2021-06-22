package com.xworkz.suitcase_app.suitcase.service;

import java.util.List;

import com.xworkz.suitcase_app.suitcase.dao.SuitcaseDAO;
import com.xworkz.suitcase_app.suitcase.dao.SuitcaseDAOImpl;
import com.xworkz.suitcase_app.suitcase.dto.SuitcaseDTO;

public class SuitcaseServiceImpl implements SuitcaseService {
	private SuitcaseDAO suitDAO;
	
	public SuitcaseServiceImpl() {
		suitDAO = new SuitcaseDAOImpl();
	}

	public void validateAndSave(SuitcaseDTO suiDTO) {
		if(suiDTO!=null) {
			suitDAO.save(suiDTO);
		}
		else {
			System.out.println("DTO cant be null");
		}
		

	}

	@Override
	public List<SuitcaseDTO> validateAndGetAllDetails() {
		return suitDAO.getAllDetails();
	}

	@Override
	public void validateAndUpdateColorByName(String name, int id, String color) {
		if(name!=null) {
			suitDAO.updateColorByName(name,id,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

	@Override
	public void validateAndDeleteColorByName(String name, int id) {
		if(name!=null) {
			suitDAO.deleteColorByName(name,id);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

}
