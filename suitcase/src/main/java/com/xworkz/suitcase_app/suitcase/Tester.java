package com.xworkz.suitcase_app.suitcase;

import java.util.List;
import java.util.Scanner;


import com.xworkz.suitcase_app.suitcase.dto.SuitcaseDTO;
import com.xworkz.suitcase_app.suitcase.service.SuitcaseService;
import com.xworkz.suitcase_app.suitcase.service.SuitcaseServiceImpl;


public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press \"Y\" to save date ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			SuitcaseDTO suiDTO = new SuitcaseDTO(); 
			System.out.println("Enter the details:");
			System.out.println("Enter suitcase name");
			suiDTO.setName(sc.next());
			System.out.println("Enter suitcase color");
			suiDTO.setColor(sc.next());
			System.out.println("Enter suitcase size");
			suiDTO.setSize(sc.next());
			
			SuitcaseService suService = new SuitcaseServiceImpl();
			suService.validateAndSave(suiDTO);
			
		}
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			SuitcaseService sService = new SuitcaseServiceImpl();
			List<SuitcaseDTO> suDTOs = sService.validateAndGetAllDetails();
			suDTOs.forEach(System.out::println);
		}
		
		
		System.out.println("Press \"Y\" to update data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of suitcase to update color");
			System.out.println("Enter correct id of suitcase");
			System.out.println("Enter new color");
			SuitcaseService suitsService = new SuitcaseServiceImpl();
			suitsService.validateAndUpdateColorByName(sc.next(),sc.nextInt(),sc.next());	
		}
		
		System.out.println("Press \"Y\" to delete data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of suitcase to delete");
			System.out.println("Enter correct id of suitcase");
			SuitcaseService suiService = new SuitcaseServiceImpl();
			suiService.validateAndDeleteColorByName(sc.next(),sc.nextInt());	
		}
		
		System.out.println("Press \"Y\" to get suitcase color by suitcase  name,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter suitcase  name");
			SuitcaseService suuuitService= new SuitcaseServiceImpl();
			String colu = suuuitService.validateAndGetSuitcaseColorBySuitcaseName(sc.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details of  suitcase by suitcase  name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter suitcase  name");
			SuitcaseService siuitcaseService= new SuitcaseServiceImpl();
			SuitcaseDTO  sfDTO  = siuitcaseService.validateAndGetDetailsBySuitcaseName(sc.next());
			System.out.println(sfDTO );
			
			
		}
		
		System.out.println("Press \"Y\" to get  suitcase size & color by suitcase name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter suitcase  name");
			SuitcaseService  stcsService= new SuitcaseServiceImpl();
			Object obj[] = stcsService.validateAndGetSuitcaseSizeAndColorBysuitcaseName(sc.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
		
		}
		
		System.out.println("H: Press \"Y\" to get  suitcase name & color details  by suitcase size,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter suitcase size");
			SuitcaseService suitcaseService = new SuitcaseServiceImpl();
			List<Object[]> objec = suitcaseService.validateAndGetsuitcaseNameAndsuitcaseColorBysuitcaseSize(sc.next());
			for(Object o2[] :objec) {
				for(Object objectt:o2) {
					System.out.print(objectt +" ");
					
				}
			}
			
			
		}
		
		System.out.println("H:Press \"Y\" to update suitcase size by suitcase name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of suitcase ");
				System.out.println("Enter new size");
				
				SuitcaseService suitcaseService = new SuitcaseServiceImpl();
				int rowAffected=suitcaseService.validateAndUpdateSizeByNameH(sc.next(),sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update suitcase color by name  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of suitcase ");
				System.out.println("Enter new color");
				
				SuitcaseService suitcaseService = new SuitcaseServiceImpl();
				int rowAffected=suitcaseService.validateAndUpdateColorByNameH(sc.next(),sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		
		
		System.out.println("H:Press \"Y\" to delete suitcase details by name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of suitcase ");				
				SuitcaseService suitcaseService = new SuitcaseServiceImpl();
				int rowAffected=suitcaseService.validateAndDeleteByNameH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete suitcase details by color  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter color ");				
				SuitcaseService suitcaseService = new SuitcaseServiceImpl();
				int rowAffected=suitcaseService.validateAndDeleteByColorH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete suitcase details by size  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter size ");				
				SuitcaseService suitcaseService = new SuitcaseServiceImpl();
				int rowAffected=suitcaseService.validateAndDeleteBySizeH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		sc.close();

	}

}
