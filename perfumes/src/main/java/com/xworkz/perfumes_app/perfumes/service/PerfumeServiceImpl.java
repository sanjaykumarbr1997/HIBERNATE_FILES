package com.xworkz.perfumes_app.perfumes.service;

import com.xworkz.perfumes_app.perfumes.dao.PerfumeDAO;
import com.xworkz.perfumes_app.perfumes.dao.PerfumeDAOImpl;
import com.xworkz.perfumes_app.perfumes.dto.PerfumeDTO;

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

}
