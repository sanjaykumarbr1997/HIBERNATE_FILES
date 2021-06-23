package com.xworkz.whatsapp;

import java.util.List;
import java.util.Scanner;

import com.xworkz.whatsapp.constants.StatusPrivacy;
import com.xworkz.whatsapp.dto.WhatsAppDTO;
import com.xworkz.whatsapp.service.WhatsAppService;
import com.xworkz.whatsapp.service.WhatsAppServiceImpl;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		WhatsAppDTO wDTO = new WhatsAppDTO();
		System.out.println("Press \"Y\" to add  data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
		wDTO.setWhatsApp_id(11);
		wDTO.setWhatsApp_privacy(StatusPrivacy.ONLY_SHARE_WITH);
		wDTO.setContactNo(843343346L);
		wDTO.setChat("busy");
		wDTO.setWhatsApp_status("video"
				+ "");
		
		WhatsAppService whatsAppService = new WhatsAppServiceImpl();
		whatsAppService.validateAndCreateWhatsApp(wDTO);
		}
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			WhatsAppService sService = new WhatsAppServiceImpl();
			List<WhatsAppDTO> suDTOs = sService.validateAndGetAllDetails();
			suDTOs.forEach(System.out::println);
		}

	}

}
