package com.xworkz.paint_app.paint.service;

import java.util.List;

import com.xworkz.paint_app.paint.dao.PaintDAO;
import com.xworkz.paint_app.paint.dao.PaintDAOImpl;
import com.xworkz.paint_app.paint.dto.PaintDTO;

public class PaintServiceImpl implements PaintService {
	private PaintDAO pDAO;
	
	public PaintServiceImpl() {
		pDAO = new PaintDAOImpl();
	}

	public void validateAndSave(PaintDTO pDTO) {
		
		if(pDTO!=null) {
			pDAO.save(pDTO);
			
		}
		else {
			System.out.println("DTO cant be empty");
		}

	}

	@Override
	public List<PaintDTO> validateAndGetAllDetails() {
		return pDAO.getAllDetails();
	}

	@Override
	public void validateAndUpdatePriceByName(String name, int id, double price) {
		if(name!=null) {
			pDAO.updatePriceByName(name,id,price);
			
		}
		else {
			System.out.println("Name cant be empty");
		}
		
	}

	@Override
	public void validateAndDeleteDetailsByName(String name, int id) {
		if(name!=null) {
			pDAO.deleteDetailsByName(name,id);
			
		}
		else {
			System.out.println("Name cant be empty");
		}
		
	}

}
