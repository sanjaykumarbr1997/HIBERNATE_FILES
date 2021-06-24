package com.xworkz.suitcase_app.suitcase;

import java.util.List;
import java.util.Scanner;

import com.xworkz.suitcase_app.suitcase.dto.SuitcaseDTO;
import com.xworkz.suitcase_app.suitcase.service.SuitcaseService;
import com.xworkz.suitcase_app.suitcase.service.SuitcaseServiceImpl;


public class Tester {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press \"Y\" to save date ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			SuitcaseDTO suiDTO = new SuitcaseDTO(); 
			System.out.println("Enter the details:");
			System.out.println("Enter suitcase name");
			suiDTO.setName(scanner.next());
			System.out.println("Enter suitcase color");
			suiDTO.setColor(scanner.next());
			System.out.println("Enter suitcase size");
			suiDTO.setSize(scanner.next());
			
			SuitcaseService suService = new SuitcaseServiceImpl();
			suService.validateAndSave(suiDTO);
			
		}
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			SuitcaseService sService = new SuitcaseServiceImpl();
			List<SuitcaseDTO> suDTOs = sService.validateAndGetAllDetails();
			suDTOs.forEach(System.out::println);
		}
		
		
		System.out.println("Press \"Y\" to update data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of suitcase to update color");
			System.out.println("Enter correct id of suitcase");
			System.out.println("Enter new color");
			SuitcaseService suitsService = new SuitcaseServiceImpl();
			suitsService.validateAndUpdateColorByName(scanner.next(),scanner.nextInt(),scanner.next());	
		}
		
		System.out.println("Press \"Y\" to delete data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of suitcase to delete");
			System.out.println("Enter correct id of suitcase");
			SuitcaseService suiService = new SuitcaseServiceImpl();
			suiService.validateAndDeleteColorByName(scanner.next(),scanner.nextInt());	
		}
		
		System.out.println("Press \"Y\" to get suitcase color by suitcase  name,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter suitcase  name");
			SuitcaseService suuuitService= new SuitcaseServiceImpl();
			String colu = suuuitService.validateAndGetSuitcaseColorBySuitcaseName(scanner.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details of  suitcase by suitcase  name ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter suitcase  name");
			SuitcaseService siuitcaseService= new SuitcaseServiceImpl();
			SuitcaseDTO  sfDTO  = siuitcaseService.validateAndGetDetailsBySuitcaseName(scanner.next());
			System.out.println(sfDTO );
			
			
		}
		
		System.out.println("Press \"Y\" to get  suitcase size & color by suitcase name ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter suitcase  name");
			SuitcaseService  stcsService= new SuitcaseServiceImpl();
			Object obj[] = stcsService.validateAndGetSuitcaseSizeAndColorBysuitcaseName(scanner.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
		
		}
		
		scanner.close();

	}

}
