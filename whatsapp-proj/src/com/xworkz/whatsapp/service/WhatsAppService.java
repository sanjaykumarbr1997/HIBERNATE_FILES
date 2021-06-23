package com.xworkz.whatsapp.service;

import java.util.List;

import com.xworkz.whatsapp.dto.WhatsAppDTO;

public interface WhatsAppService {
	
	public void validateAndCreateWhatsApp(WhatsAppDTO wDTO);

	public List<WhatsAppDTO> validateAndGetAllDetails();

}
