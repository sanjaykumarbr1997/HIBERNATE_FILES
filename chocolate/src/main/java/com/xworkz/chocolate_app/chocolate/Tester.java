package com.xworkz.chocolate_app.chocolate;

import java.util.List;
import java.util.Scanner;

import com.xworkz.chocolate_app.chocolate.dto.ChocoloateDTO;
import com.xworkz.chocolate_app.chocolate.service.ChocolateService;
import com.xworkz.chocolate_app.chocolate.service.ChocolateServiceImpl;
import com.xworkz.chocolate_app.chocolate.service.ChocolateService;
import com.xworkz.chocolate_app.chocolate.service.ChocolateServiceImpl;


public class Tester {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press \"Y\" to save date ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			ChocoloateDTO cDTO = new ChocoloateDTO(); 
			System.out.println("Enter the details:");
			System.out.println("Enter chocolate id");
			cDTO.setName(scanner.next());
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
		
		System.out.println("Press \"Y\" to get  chocolate price & color details  by chocolate company name ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter chocolate company name");
			ChocolateService chocolateService = new ChocolateServiceImpl();
			List<Object[]> objec = chocolateService.validateAndGetchocolatePriceAndchocolateColorByChocolateName(scanner.next());
			for(Object o2[] :objec) {
				for(Object objectt:o2) {
					System.out.print(objectt +" ");
					
				}
			}
			
			
		}
		
		System.out.println("H:Press \"Y\" to update chocolate price by chocolate name  \"N\" ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of chocolate ");
				System.out.println("Enter new price");
				
				ChocolateService chocoolService = new ChocolateServiceImpl();
				int rowAffected=chocoolService.validateAndUpdatePriceByNameH(scanner.next(),scanner.nextDouble());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update chocolate color by name  \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of chocolate ");
				System.out.println("Enter new color");
				
				ChocolateService chocoolService = new ChocolateServiceImpl();
				int rowAffected=chocoolService.validateAndUpdateColorByNameH(scanner.next(),scanner.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update chocolate company name by name  \"N\" ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of chocolate ");
				System.out.println("Enter new company name");
				
				ChocolateService chocoolService = new ChocolateServiceImpl();
				int rowAffected=chocoolService.validateAndUpdateChocolateCompanyByNameH(scanner.next(),scanner.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete chocolate details by name  \"N\" ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of chocolate ");				
				ChocolateService chocolService = new ChocolateServiceImpl();
				int rowAffected=chocolService.validateAndDeleteByNameH(scanner.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete chocolate details by price  \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter price ");				
				ChocolateService chocolService = new ChocolateServiceImpl();
				int rowAffected=chocolService.validateAndDeleteByPriceH(scanner.nextDouble());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete chocolate details by color  \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter color ");				
				ChocolateService chocolService = new ChocolateServiceImpl();
				int rowAffected=chocolService.validateAndDeleteByColorH(scanner.next());
				System.out.println(rowAffected);
			
			
		}
		

	}

}
