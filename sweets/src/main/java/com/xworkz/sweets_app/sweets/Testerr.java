package com.xworkz.sweets_app.sweets;

import java.util.List;
import java.util.Scanner;

import com.xworkz.sweets_app.sweets.dto.SweetsDTO;
import com.xworkz.sweets_app.sweets.service.SweetsService;
import com.xworkz.sweets_app.sweets.service.SweetsServiceImpl;


public class Testerr {
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		SweetsService sweetsService = new SweetsServiceImpl();
		
		System.out.println("Enter no of records you need to enter");
		int input = scanner.nextInt();
		for(int i=0;i<input;i++) {
		SweetsDTO sDTO = new SweetsDTO() ;
		System.out.println("Enter sweet name");
		sDTO.setName(scanner.next());
		System.out.println("Enter sweet color");
		sDTO.setColor(scanner.next());
		System.out.println("Enter price of sweet");
		sDTO.setPrice(scanner.nextDouble());
		System.out.println("Enter shape of sweet");
		sDTO.setShape(scanner.next());
		sweetsService.valideAndSave(sDTO);
		
		} 
		
		System.out.println("Enter no of records you need to fetch by name");
		int input1 = scanner.nextInt();
		for(int i=0;i<input1;i++) {
		System.out.println("Enter sweet ID");
		System.out.println("Enter sweet Name");
	
		SweetsDTO sDTO =sweetsService.validateAndGetDetailsByName(scanner.nextInt(),scanner.next());
		System.out.println(sDTO);
		
		} 
		
		System.out.println("Enter no of records you need to update color by name");
		int input2 = scanner.nextInt();
		for(int i=0;i<input2;i++) {
			
			System.out.println("Enter sweet id");
			System.out.println("Enter sweet name");
			System.out.println("Enter color to change");
			sweetsService.validateAndUpdate(scanner.nextInt(),scanner.next(),scanner.next());
			System.out.println("Details updated");
			
		}
		
		System.out.println("Enter no of records you need to delete by name");
		int input3 = scanner.nextInt();
		for(int i=0;i<input3;i++) {
			
			System.out.println("Enter sweet id");
			System.out.println("Enter sweet name to delete");
			sweetsService.validateAndDelete(scanner.nextInt(),scanner.next());
			System.out.println("Details deleted");
			
		}
		
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			SweetsService sweeService = new SweetsServiceImpl();
			List<SweetsDTO> suDTOs = sweeService.validateAndGetAllDetails();
			suDTOs.forEach(System.out::println);
		}
		
		System.out.println("Press \"Y\" to get sweets color by sweets  name,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter sweets  name");
			SweetsService swtssService= new SweetsServiceImpl();
			String colu = swtssService.validateAndGetSweetsColorBySweetName(scanner.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details of  sweets by sweets  name ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter sweets  name");
			SweetsService sweeeeService= new SweetsServiceImpl();
			SweetsDTO  stsDTO  = sweeeeService.validateAndGetDetailsBySweetName(scanner.next());
			System.out.println(stsDTO );
			
			
		}
		
		System.out.println("Press \"Y\" to get  sweets shape & color by sweets price,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter sweets  name");
			SweetsService  swtsssService= new SweetsServiceImpl();
			Object obj[] = swtsssService.validateAndGetsweetsShapeAndColorBySweetName(scanner.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
		
		}
		
		
		
		scanner.close();
		
	}

}
