package com.xworkz.whatsapp;

import com.xworkz.whatsapp.constants.StatusPrivacy;
import com.xworkz.whatsapp.dto.WhatsAppDTO;
import com.xworkz.whatsapp.service.WhatsAppService;
import com.xworkz.whatsapp.service.WhatsAppServiceImpl;

public class Tester {

	public static void main(String[] args) {
		
		WhatsAppDTO wDTO = new WhatsAppDTO();
		wDTO.setWhatsApp_id(11);
		wDTO.setWhatsApp_privacy(StatusPrivacy.ONLY_SHARE_WITH);
		wDTO.setContactNo(843343346L);
		wDTO.setChat("busy");
		wDTO.setWhatsApp_status("video"
				+ "");
		
		WhatsAppService whatsAppService = new WhatsAppServiceImpl();
		whatsAppService.validateAndCreateWhatsApp(wDTO);

	}

}
