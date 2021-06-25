package com.xworkz.windowsversion_app.windows;

import java.util.List;
import java.util.Scanner;

import com.xworkz.windowsversion_app.windows.dto.WindowsDTO;
import com.xworkz.windowsversion_app.windows.service.WindowsService;
import com.xworkz.windowsversion_app.windows.service.WindowsServiceImpl;


public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press \"Y\" to save date ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			WindowsDTO wiDTO = new WindowsDTO(); 
			System.out.println("Enter the details:");
			
			System.out.println("Enter windows name");
			wiDTO.setName(sc.next());
			System.out.println("Enter windows release year");
			wiDTO.setReleaseYear(sc.nextInt());
			System.out.println("Enter windows new features");
			wiDTO.setnewFeatures(sc.next());
			
			WindowsService wssService = new WindowsServiceImpl();
			wssService.validateAndSave(wiDTO);
			
		}
		
		System.out.println("Press \"Y\" to read all data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			WindowsService sService = new WindowsServiceImpl();
			List<WindowsDTO> suDTOs = sService.validateAndGetAllDetails();
			suDTOs.forEach(System.out::println);
		}
		
		
		System.out.println("Press \"Y\" to update data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of windows to update release year");
			System.out.println("Enter correct id of windows");
			System.out.println("Enter new year");
			WindowsService windowService = new WindowsServiceImpl();
			windowService.validateAndUpdateYearByName(sc.next(),sc.nextInt(),sc.nextInt());	
		}
		
		System.out.println("Press \"Y\" to delete data ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter name of windows to delete");
			System.out.println("Enter correct id of windows");
			WindowsService windooService = new WindowsServiceImpl();
			windooService.validateAndDeleteByName(sc.next(),sc.nextInt());	
		}
		
		System.out.println("Press \"Y\" to get windows new features by windows  name,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter windows  name");
			WindowsService wndwService= new WindowsServiceImpl();
			String colu = wndwService.validateAndGetwindowsNewFeaturesByWindowsName(sc.next());
			System.out.println(colu);
		}
		System.out.println("Press \"Y\" to get details of  windows by windows  name ,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter windows  name");
			WindowsService wwwwiService= new WindowsServiceImpl();
			WindowsDTO  stsDTO  = wwwwiService.validateAndGetDetailsByWindowsName(sc.next());
			System.out.println(stsDTO );
			
			
		}
		
		System.out.println("Press \"Y\" to get  windows release year & features by windows price,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter windows  name");
			WindowsService  wndwsService= new WindowsServiceImpl();
			Object obj[] = wndwsService.validateAndGetwindowsReleaseYearAndNewFeaturesByWindowsName(sc.next());
			for(Object o1 :obj) {
				System.out.println(o1);
			}
		
		}
		
		
		
		System.out.println("H: Press \"Y\" to get  windows name & new feature details  by windows release year,if not  press \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			System.out.println("Enter windows release year");
			WindowsService WindowsService = new WindowsServiceImpl();
			List<Object[]> objec = WindowsService.validateAndGetwindowsNameAndwindowsNewFeaturesBywindowsReleaseYear(sc.nextInt());
			for(Object o2[] :objec) {
				for(Object objectt:o2) {
					System.out.print(objectt +" ");
					
				}
			}
			
			
		}
		
		System.out.println("H:Press \"Y\" to update windows release year by windows name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of windows ");
				System.out.println("Enter new release year");
				
				WindowsService WindowsService = new WindowsServiceImpl();
				int rowAffected=WindowsService.validateAndUpdateReleaseYearByNameH(sc.next(),sc.nextInt());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to update windows new featured by windows name \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of windows ");
				System.out.println("Enter new feature");
				
				WindowsService WindowsService = new WindowsServiceImpl();
				int rowAffected=WindowsService.validateAndUpdateFearureByNameH(sc.next(),sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		
		
		System.out.println("H:Press \"Y\" to delete windows details by name  \"N\" ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter name of windows ");				
				WindowsService WindowsService = new WindowsServiceImpl();
				int rowAffected=WindowsService.validateAndDeleteByNameH(sc.next());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete windows details by windows year  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter year ");				
				WindowsService WindowsService = new WindowsServiceImpl();
				int rowAffected=WindowsService.validateAndDeleteByYearH(sc.nextInt());
				System.out.println(rowAffected);
			
			
		}
		
		System.out.println("H:Press \"Y\" to delete windows details by features  \"N\"  ");
		if(sc.next().equalsIgnoreCase("Y")) {
			
				System.out.println("Enter feature");				
				WindowsService WindowsService = new WindowsServiceImpl();
				int rowAffected=WindowsService.validateAndDeleteByFeatureH(sc.next());
				System.out.println(rowAffected);
			
			
		} 
		sc.close();
	}

}
