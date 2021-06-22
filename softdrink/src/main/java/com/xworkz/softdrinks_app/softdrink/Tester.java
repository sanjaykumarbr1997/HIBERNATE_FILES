package com.xworkz.softdrinks_app.softdrink;

import java.util.List;
import java.util.Scanner;

import com.xworkz.softdrinks_app.softdrink.dto.SoftDrinksDTO;
import com.xworkz.softdrinks_app.softdrink.service.SoftDrinksService;
import com.xworkz.softdrinks_app.softdrink.service.SoftDrinksServiceImpl;



public class Tester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press \"Y\" to save date ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			SoftDrinksDTO sDTO = new SoftDrinksDTO(); 
			System.out.println("Enter the details:");
			System.out.println("Enter softdrink name");
			sDTO.setName(sc.next());
			System.out.println("Enter softdrink color");
			sDTO.setColor(sc.next());
			System.out.println("Enter softdrink price");
			sDTO.setPrice(sc.nextDouble());
			System.out.println("Enter softdrink mfg year");
			sDTO.setMfgYear(sc.nextInt());
			
			SoftDrinksService cs = new SoftDrinksServiceImpl();
			cs.validateAndSave(sDTO);
			
		}
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			SoftDrinksService sService = new SoftDrinksServiceImpl();
			List<SoftDrinksDTO > sfDTOs = sService.validateAndGetAllDetails();
			sfDTOs.forEach(System.out::println);
		}
		
		
		System.out.println("Press \"Y\" to update data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of softdrink to update color");
			System.out.println("Enter correct id of softdrink");
			System.out.println("Enter new Color");
			
			SoftDrinksService sService = new SoftDrinksServiceImpl();
			sService.validateAndUpdateColorByName(sc.next(),sc.nextInt(),sc.next());	
		}
		
		System.out.println("Press \"Y\" to delete data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of softdrinks to delete");
			System.out.println("Enter softdrink id of chocolate");
			SoftDrinksService softService = new SoftDrinksServiceImpl();
			softService.validateAndDeleteColorByName(sc.next(),sc.nextInt());	
		}
		
		
		sc.close();

	}
		
		
	

}
