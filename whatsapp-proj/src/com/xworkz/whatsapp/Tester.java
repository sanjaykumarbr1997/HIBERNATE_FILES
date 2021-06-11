package com.xworkz.whatsapp;

import com.xworkz.whatsapp.constants.StatusPrivacy;
import com.xworkz.whatsapp.dto.WhatsAppDTO;
import com.xworkz.whatsapp.service.WhatsAppService;
import com.xworkz.whatsapp.service.WhatsAppServiceImpl;

public class Tester {

	public static void main(String[] args) {
		
		WhatsAppDTO wDTO = new WhatsAppDTO();
		wDTO.setWhatsApp_id(6);
		wDTO.setWhatsApp_privacy(StatusPrivacy.MY_CONTACTS);
		wDTO.setContactNo(343343346L);
		wDTO.setChat("Bye  .....");
		wDTO.setWhatsApp_status("sad");
		
		WhatsAppService whatsAppService = new WhatsAppServiceImpl();
		whatsAppService.validateAndCreateWhatsApp(wDTO);

	}

}
