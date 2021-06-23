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
		
		
		
		
		
		
		

	}

}
