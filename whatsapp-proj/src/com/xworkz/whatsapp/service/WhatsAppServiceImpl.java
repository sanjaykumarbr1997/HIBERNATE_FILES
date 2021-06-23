package com.xworkz.whatsapp.service;

import java.util.List;

import com.xworkz.whatsapp.dao.WhatsAppDAO;
import com.xworkz.whatsapp.dao.WhatsAppDAOImpl;
import com.xworkz.whatsapp.dto.WhatsAppDTO;

public class WhatsAppServiceImpl implements WhatsAppService {

	
	private WhatsAppDAO wDAO;
	public WhatsAppServiceImpl() {
		wDAO = new WhatsAppDAOImpl();
	}
	
	
	@Override
	public void validateAndCreateWhatsApp(WhatsAppDTO wDTO) {
		
		if(wDTO!= null) {
			wDAO.createWhatsApp(wDTO);
		}
		else {
			System.out.println("entry cant be empty");
		}
		
		

	}


	@Override
	public List<WhatsAppDTO> validateAndGetAllDetails() {
		return wDAO.getAllDetails();
	}

}
