package com.xworkz.sweets_app.sweets;

import java.util.List;
import java.util.Scanner;


import com.xworkz.sweets_app.sweets.dto.SweetsDTO;
import com.xworkz.sweets_app.sweets.service.SweetsService;
import com.xworkz.sweets_app.sweets.service.SweetsServiceImpl;


public class Testerr {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		SweetsService sweetsService = new SweetsServiceImpl();
		
		System.out.println("Enter no of records you need to enter");
		int input = sc.nextInt();
		for(int i=0;i<input;i++) {
		SweetsDTO sDTO = new SweetsDTO() ;
		System.out.println("Enter sweet name");
		sDTO.setName(sc.next());
		System.out.println("Enter sweet color");
		sDTO.setColor(sc.next());
		System.out.println("Enter price of sweet");
		sDTO.setPrice(sc.nextDouble());
		System.out.println("Enter shape of sweet");
		sDTO.setShape(sc.next());
		sweetsService.valideAndSave(sDTO);
		
		} 
		
		System.out.println("Enter no of records you need to fetch by name");
		int input1 = sc.nextInt();
		for(int i=0;i<input1;i++) {
		System.out.println("Enter sweet ID");
		System.out.println("Enter sweet Name");
	
		SweetsDTO sDTO =sweetsService.validateAndGetDetailsByName(sc.nextInt(),sc.next());
		System.out.println(sDTO);
		
		} 
		
		System.out.println("Enter no of records you need to update color by name");
		int input2 = sc.nextInt();
		for(int i=0;i<input2;i++) {
			
			System.out.println("Enter sweet id");
			System.out.println("Enter sweet name");
			System.out.println("Enter color to change");
			sweetsService.validateAndUpdate(sc.nextInt(),sc.next(),sc.next());
			System.out.println("Details updated");
			
		}
		
		System.out.println("Enter no of records you need to delete by name");
		int input3 = sc.nextInt();
		for(int i=0;i<input3;i++) {
			
			System.out.println("Enter sweet id");
			System.out.println("Enter sweet name to delete");
			sweetsService.validateAndDelete(sc.nextInt(),sc.next());
			System.out.println("Details deleted");
			
		}
		
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			SweetsService sweeService = new SweetsServiceImpl();
			List<SweetsDTO> suDTOs = sweeService.validateAndGetAllDetails();
			suDTOs.forEach(System.out::println);
		}
		
		System.out.println("Press \"Y\" to get sweets color by sweets  name,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter sweets  name");
			SweetsService swtssService= new SweetsServiceImpl();
			String colu = swtssService.validateAndGetSweetsColorBySweetName(sc.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details of  sweets by sweets  name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter sweets  name");
			SweetsService sweeeeService= new SweetsServiceImpl();
			SweetsDTO  stsDTO  = sweeeeService.validateAndGetDetailsBySweetName(sc.next());
			System.out.println(stsDTO );
			
			
		}
		
		System.out.println("Press \"Y\" to get  sweets shape & color by sweets price,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter sweets  name");
			SweetsService  swtsssService= new SweetsServiceImpl();
			Object obj[] = swtsssService.validateAndGetsweetsShapeAndColorBySweetName(sc.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
		
		}
		System.out.println("H: Press \"Y\" to get  sweet price & color details  by sweet shape,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter sweet shape");
			SweetsService swttService = new SweetsServiceImpl();
			List<Object[]> objec = swttService.validateAndGetsweetPriceAndsweetColorBysweetshape(sc.next());
			for(Object o2[] :objec) {
				for(Object objectt:o2) {
					System.out.print(objectt +" ");
					
				}
			}
			
			
		}
		
		System.out.println("H:Press \"Y\" to update sweet price by sweet name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of sweet ");
				System.out.println("Enter new price");
				
				SweetsService swttService = new SweetsServiceImpl();
				int rowAffected=swttService.validateAndUpdatePriceByNameH(sc.next(),sc.nextDouble());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update sweet color by name  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of sweet ");
				System.out.println("Enter new color");
				
				SweetsService swttService = new SweetsServiceImpl();
				int rowAffected=swttService.validateAndUpdateColorByNameH(sc.next(),sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update sweet shape  by name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of sweet ");
				System.out.println("Enter new shape");
				
				SweetsService swttService = new SweetsServiceImpl();
				int rowAffected=swttService.validateAndUpdatesweetshapeByNameH(sc.next(),sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete sweet details by name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of sweet ");				
				SweetsService swttService = new SweetsServiceImpl();
				int rowAffected=swttService.validateAndDeleteByNameH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete sweet details by price  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter price ");				
				SweetsService swttService = new SweetsServiceImpl();
				int rowAffected=swttService.validateAndDeleteByPriceH(sc.nextDouble());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete sweet details by color  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter color ");				
				SweetsService swttService = new SweetsServiceImpl();
				int rowAffected=swttService.validateAndDeleteByColorH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		
		
		sc.close();
		
	}

}
