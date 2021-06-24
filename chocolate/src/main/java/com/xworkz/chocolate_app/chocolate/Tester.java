package com.xworkz.chocolate_app.chocolate;

import java.util.List;
import java.util.Scanner;

import com.xworkz.chocolate_app.chocolate.dto.ChocoloateDTO;
import com.xworkz.chocolate_app.chocolate.service.ChocolateService;
import com.xworkz.chocolate_app.chocolate.service.ChocolateServiceImpl;


public class Tester {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press \"Y\" to save date ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			ChocoloateDTO cDTO = new ChocoloateDTO(); 
			System.out.println("Enter the details:");
			System.out.println("Enter chocolate name");
			cDTO.setName(scanner.next());
			System.out.println("Enter chocolate color");
			cDTO.setColor(scanner.next());
			System.out.println("Enter chocolate price");
			cDTO.setPrice(scanner.nextDouble());
			System.out.println("Enter chocolate company");
			cDTO.setCompany(scanner.next());
			
			ChocolateService cs = new ChocolateServiceImpl();
			cs.validateAndSave(cDTO);
			
		}
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			ChocolateService cService = new ChocolateServiceImpl();
			List<ChocoloateDTO > chDTOs = cService.validateAndGetAllDetails();
			chDTOs.forEach(System.out::println);
		}
		
		
		System.out.println("Press \"Y\" to update data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of chocolate to update color");
			System.out.println("Enter correct id of chocolate");
			System.out.println("Enter new color");
			ChocolateService choService = new ChocolateServiceImpl();
			choService.validateAndUpdateColorByName(scanner.next(),scanner.nextInt(),scanner.next());	
		}
		
		System.out.println("Press \"Y\" to delete data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of chocolate to delete");
			System.out.println("Enter correct id of chocolate");
			ChocolateService chocService = new ChocolateServiceImpl();
			chocService.validateAndDeleteColorByName(scanner.next(),scanner.nextInt());	
		}
		
		System.out.println("Press \"Y\" to get chocolate company by chocolate name,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter chocolate name");
			ChocolateService chocolateService= new ChocolateServiceImpl();
			String colu = chocolateService.validateAndGetChocolateCompanyByChocolateName(scanner.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details  by chocolate name ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter chocolate name");
			ChocolateService cchocolateService= new ChocolateServiceImpl();
			ChocoloateDTO chocolDTO  = cchocolateService.validateAndGetDetailsByChocolatename(scanner.next());
			System.out.println(chocolDTO );
			
			
		}
		
		System.out.println("Press \"Y\" to get  chocolate price & chocolate color by chocolate name ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter chocolate name");
			ChocolateService  chhocolateService= new ChocolateServiceImpl();
			Object obj[] = chhocolateService.validateAndGetChocolatePriceAndChocolateColorByChocolateName(scanner.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
			
			
		}
		
		
		

	}

}
