package com.xworkz.paint_app.paint;

import java.util.List;
import java.util.Scanner;

import com.xworkz.paint_app.paint.dto.PaintDTO;
import com.xworkz.paint_app.paint.service.PaintService;
import com.xworkz.paint_app.paint.service.PaintServiceImpl;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PaintDTO pDTO = new PaintDTO();
		
		
		System.out.println("Press \"Y\" to save data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter paint company name");
			pDTO.setName(sc.next());
			System.out.println("Enter paint color");
			pDTO.setColor(sc.next());
			System.out.println("Enter paint price");
			pDTO.setPrice(sc.nextDouble());
			System.out.println("Enter paint expiry year");
			pDTO.setYear(sc.nextInt());
			
			
			PaintService pService = new PaintServiceImpl();
			pService.validateAndSave(pDTO);
		}
		System.out.println("Press \"Y\" to fetch all  data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
			PaintService paService = new PaintServiceImpl();
			List<PaintDTO> paDTOs = paService.validateAndGetAllDetails();
			paDTOs.forEach(System.out::println);
			
		}
		
		System.out.println("Press \"Y\" to update price by name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of paint ");
			System.out.println("Enter correct id of paint");
			System.out.println("Enter new price");
			
			PaintService paiService = new PaintServiceImpl();
			paiService.validateAndUpdatePriceByName(sc.next(),sc.nextInt(),sc.nextDouble());

		}
		
		System.out.println("Press \"Y\" to delete by name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of paint ");
			System.out.println("Enter correct id of paint");
			PaintService painService = new PaintServiceImpl();
			painService.validateAndDeleteDetailsByName(sc.next(),sc.nextInt());
		}
		
		System.out.println("Press \"Y\" to get paint color by paint price ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter paint price");
			PaintService paintService = new PaintServiceImpl();
			String col = paintService.validateAndGetPaintColorByPrice(sc.nextDouble());
			System.out.println(col);
		}
		System.out.println("Press \"Y\" to get details  by paint name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter paint name");
			PaintService paintService = new PaintServiceImpl();
			PaintDTO pnDTO  = paintService.validateAndGetDetailsByName(sc.next());
			System.out.println(pnDTO);
			
			
		}
		
		System.out.println("Press \"Y\" to get  paint price & color details  by paint name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter paint name");
			PaintService paintService = new PaintServiceImpl();
			Object obj[] = paintService.validateAndGetPaintPriceAndPaintColorByName(sc.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
			
			
		}
		System.out.println("Press \" Y \" to get  paint price & color details  by paint expiry year ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter paint expiry year");
			PaintService paintService = new PaintServiceImpl();
			List<Object[]> objec = paintService.validateAndGetPaintPriceAndPaintColorByExpiryYear(sc.nextInt());
			for(Object o2[] :objec) {
				for(Object objectt:o2) {
					System.out.print(objectt +" ");
					
				}
			}
			
			
		}
		
		System.out.println("H:Press \"Y\" to update paint price by name \\\"N\\\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of paint ");
				System.out.println("Enter new price");
				
				PaintService paiService = new PaintServiceImpl();
				int rowAffected=paiService.validateAndUpdatePriceByNameH(sc.next(),sc.nextDouble());
				System.out.println(rowAffected);
			
			
		}
		System.out.println("H:Press \"Y\" to update paint color by name \\\"N\\\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of paint ");
				System.out.println("Enter new color");
				
				PaintService paiService = new PaintServiceImpl();
				int rowAffected=paiService.validateAndUpdateColorByNameH(sc.next(),sc.next());
				System.out.println(rowAffected);
			
			
		}
		System.out.println("H:Press \"Y\" to update paint year of expiry by name \\\"N\\\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of paint ");
				System.out.println("Enter new expiry year");
				
				PaintService paiService = new PaintServiceImpl();
				int rowAffected=paiService.validateAndUpdateYearOfExpiryByNameH(sc.next(),sc.nextInt());
				System.out.println(rowAffected);
			
			
		}
		System.out.println("H:Press \"Y\" to delete paint details by name \\\"N\\\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of paint ");				
				PaintService painService = new PaintServiceImpl();
				int rowAffected=painService.validateAndDeleteByNameH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		System.out.println("H:Press \"Y\" to delete paint details by year \\\"N\\\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter year ");				
				PaintService painService = new PaintServiceImpl();
				int rowAffected=painService.validateAndDeleteByYearH(sc.nextInt());
				System.out.println(rowAffected);
			
			
		}
		System.out.println("H:Press \"Y\" to delete paint details by color \\\"N\\\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter color ");				
				PaintService painService = new PaintServiceImpl();
				int rowAffected=painService.validateAndDeleteByColorH(sc.next());
				System.out.println(rowAffected);
			
			
		}

		
		
		

	}

}
