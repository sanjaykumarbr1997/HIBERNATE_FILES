package com.xworkz.windowsversion_app.windows;

import java.util.List;
import java.util.Scanner;


import com.xworkz.windowsversion_app.windows.dto.WindowsDTO;
import com.xworkz.windowsversion_app.windows.service.WindowsService;
import com.xworkz.windowsversion_app.windows.service.WindowsServiceImpl;


public class Tester {

	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press \"Y\" to save date ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			WindowsDTO wiDTO = new WindowsDTO(); 
			System.out.println("Enter the details:");
			
			System.out.println("Enter windows name");
			wiDTO.setName(scanner.next());
			System.out.println("Enter windows release year");
			wiDTO.setReleaseYear(scanner.nextInt());
			System.out.println("Enter windows new features");
			wiDTO.setNew_features(scanner.next());
			
			WindowsService wssService = new WindowsServiceImpl();
			wssService.validateAndSave(wiDTO);
			
		}
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			WindowsService sService = new WindowsServiceImpl();
			List<WindowsDTO> suDTOs = sService.validateAndGetAllDetails();
			suDTOs.forEach(System.out::println);
		}
		
		
		System.out.println("Press \"Y\" to update data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of windows to update release year");
			System.out.println("Enter correct id of windows");
			System.out.println("Enter new year");
			WindowsService windowService = new WindowsServiceImpl();
			windowService.validateAndUpdateYearByName(scanner.next(),scanner.nextInt(),scanner.nextInt());	
		}
		
		System.out.println("Press \"Y\" to delete data ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of windows to delete");
			System.out.println("Enter correct id of windows");
			WindowsService windooService = new WindowsServiceImpl();
			windooService.validateAndDeleteByName(scanner.next(),scanner.nextInt());	
		}
		
		System.out.println("Press \"Y\" to get windows new features by windows  name,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter windows  name");
			WindowsService wndwService= new WindowsServiceImpl();
			String colu = wndwService.validateAndGetwindowsNewFeaturesByWindowsName(scanner.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details of  windows by windows  name ,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter windows  name");
			WindowsService wwwwiService= new WindowsServiceImpl();
			WindowsDTO  stsDTO  = wwwwiService.validateAndGetDetailsByWindowsName(scanner.next());
			System.out.println(stsDTO );
			
			
		}
		
		System.out.println("Press \"Y\" to get  windows release year & features by windows price,if not  press \"N\"  ");
		if(scanner.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter windows  name");
			WindowsService  wndwsService= new WindowsServiceImpl();
			Object obj[] = wndwsService.validateAndGetwindowsReleaseYearAndNewFeaturesByWindowsName(scanner.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
		
		}
		

		scanner.close();
	}

}
