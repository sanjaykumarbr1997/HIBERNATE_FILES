package com.xworkz.perfumes_app.perfumes;


import java.util.Scanner;

import com.xworkz.perfumes_app.perfumes.dto.PerfumeDTO;
import com.xworkz.perfumes_app.perfumes.service.PerfumeService;
import com.xworkz.perfumes_app.perfumes.service.PerfumeServiceImpl;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		PerfumeDTO pDTO = new PerfumeDTO();
		System.out.println("Enter perfume id");
		pDTO.setPerfumeId(sc.nextInt());
		System.out.println("Enter perfume fragnance");
		pDTO.setPerfumeFragnance(sc.next());
		System.out.println("Enter perfume name");
		pDTO.setPerfumeName(sc.next());
		System.out.println("Enter perfume color");
		pDTO.setPerfumeColor(sc.next());
		System.out.println("Enter perfume price");
		pDTO.setPerfumePrice(sc.nextDouble());
		
		
		PerfumeService perfumeService = new PerfumeServiceImpl();
		perfumeService.vaidateAndSave(pDTO);
		
		
		System.out.println("Enter id and Name to fetch details");
		PerfumeDTO perDTO = perfumeService.validateAndGetDetailsByName(sc.nextInt(),sc.next());
		System.out.println(perDTO);
		System.out.println("details fetched");
		
		System.out.println("Update color by name:");
		System.out.println("Enter id ,perfume name,and new color");
		perfumeService.validateAndUpdateColorByName(sc.nextInt(),sc.next(),sc.next());
		System.out.println("updated");
		
		System.out.println("Delete detais by name:");
		System.out.println("Enter id ,perfume name to delete");
		perfumeService.validateAndDeleteDetailsByName(sc.nextInt(),sc.next());
		System.out.println("details deleted");

	}

}

