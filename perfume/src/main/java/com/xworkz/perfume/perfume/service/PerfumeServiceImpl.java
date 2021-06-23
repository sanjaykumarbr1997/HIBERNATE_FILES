package com.xworkz.perfume.perfume.service;

import java.util.List;

import com.xworkz.perfume.perfume.dao.PerfumeDAO;
import com.xworkz.perfume.perfume.dao.PerfumeDAOImpl;
import com.xworkz.perfume.perfume.dto.PerfumeDTO;

public class PerfumeServiceImpl implements PerfumeService {
	
	
	private PerfumeDAO pDAO;
	
	public PerfumeServiceImpl() {
		 pDAO = new PerfumeDAOImpl();
	}

	public void vaidateAndSave(PerfumeDTO pDTO) {
		if(pDTO!=null) {
			
			pDAO.save(pDTO);
			
		}
		
	}

	public PerfumeDTO validateAndGetDetailsByName(int id, String name) {
		
		if(name!=null) {
			return pDAO.getDetailsByName(id,name);	
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
		
	}

	public void validateAndUpdateColorByName(int id, String name, String color) {
		if(name!=null) {
			pDAO.updateColorByName(id,name,color);
		}
		else {
			System.out.println("name cant be empty");
		}
		
	}

	public void validateAndDeleteDetailsByName(int id, String name) {
		if(name!=null) {
			pDAO.deleteDetailsByName(id,name);
		}
		else {
			System.out.println("name cant be empty");
		}
	}

	@Override
	public List<PerfumeDTO> validateAndGetAllDetails() {
		return pDAO.getAllDetails();
	}

}