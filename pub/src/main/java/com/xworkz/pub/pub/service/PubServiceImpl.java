package com.xworkz.pub.pub.service;

import com.xworkz.pub.pub.dao.PubDAO;
import com.xworkz.pub.pub.dao.PubDAOImpl;
import com.xworkz.pub.pub.dto.PubDTO;

public class PubServiceImpl implements PubService {
	
	private PubDAO pDAO;
	public PubServiceImpl() {
		pDAO = new PubDAOImpl();
	}

	public void validateAndSave(PubDTO pDTO) {
		if(pDTO!=null) {
			pDAO.save(pDTO);
		}

	}

	public PubDTO validateAndGetDetailsByName(String name, int id) {
		if(name!=null) {
			return pDAO.getDetailsByName(name,id);
		}
		return null;
	}

	public void validateAndUpdateContactDetailsByName(String name, int id, String contact) {
		pDAO.update(name,id,contact);
		
	}

	public void checking() {
		pDAO.checking();
		
	}

	public void delete(int id) {
		pDAO.delete(id);
	}

	

}
