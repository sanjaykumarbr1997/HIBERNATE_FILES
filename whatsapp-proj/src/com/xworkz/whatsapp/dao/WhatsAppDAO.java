package com.xworkz.whatsapp.dao;

import java.util.List;

import com.xworkz.whatsapp.dto.WhatsAppDTO;

public interface WhatsAppDAO {
	
	
	public void createWhatsApp(WhatsAppDTO wDTO);

	public List<WhatsAppDTO> getAllDetails();

	

}
