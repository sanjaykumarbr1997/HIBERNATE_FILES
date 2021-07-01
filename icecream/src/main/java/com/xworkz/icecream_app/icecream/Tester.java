package com.xworkz.icecream_app.icecream;

import com.xworkz.icecream_app.icecream.dto.IceCreamDTO;
import com.xworkz.icecream_app.icecream.service.IceCreamService;
import com.xworkz.icecream_app.icecream.service.IceCreamServiceImpl;

public class Tester {
	public static void main(String[] args) {
	
	IceCreamDTO iDTO = new IceCreamDTO();
	iDTO.setBrand("Amul");
	iDTO.setColor("Yellow");
	iDTO.setFlavour("Mango");
	
	IceCreamService iceService= new IceCreamServiceImpl();
	iceService.validateAndSave(iDTO);
	
	
	}

}
