package com.xworkz.pub.pub;

import java.io.Serializable;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xworkz.pub.pub.dto.PubDTO;
import com.xworkz.pub.pub.service.PubService;
import com.xworkz.pub.pub.service.PubServiceImpl;


public class Tester {
	public static void main(String[] args) {
		
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter \"Y\" to save data or enter \"N ");
	if(sc.next().equalsIgnoreCase("Y")) {
	PubDTO pDTO = new PubDTO();
	System.out.println("Enter id");
	pDTO.setId(sc.nextInt());
	System.out.println("Enter name ");
	pDTO.setName(sc.next());
	System.out.println("Enter location");
	pDTO.setLocation(sc.next());
	System.out.println("Enter contact number");
	pDTO.setContactNo(sc.next());
	
	PubService pService = new PubServiceImpl();
	pService.validateAndSave(pDTO);
	
	
	}
	System.out.println("Enter \"Y\" to get details by name or enter \"N");
	if(sc.next().equalsIgnoreCase("Y")) {
		PubService pService = new PubServiceImpl();
		System.out.println("Enter name to fetch details");
		System.out.println("Enter correct id");
		PubDTO puDTO = pService.validateAndGetDetailsByName(sc.next(),sc.nextInt());
		
		System.out.println(puDTO);
	}
	System.out.println("Enter \"Y\" to update contact details by name or enter \"N");
	if(sc.next().equalsIgnoreCase("Y")) {
		PubService pService = new PubServiceImpl();
		System.out.println("Enter name");
		System.out.println("Enter correct id");
		System.out.println("Enter contact no");
		pService.validateAndUpdateContactDetailsByName(sc.next(),sc.nextInt(),sc.next());
		
	}
	
	System.out.println("checking out merge and update press \"Y\" to enter ");
	if(sc.next().equalsIgnoreCase("Y")) {
		PubService pService = new PubServiceImpl();
		pService.checking();
	
	}
	
	System.out.println("press \"Y\" to delete or press \"N \" to cancel");
	if(sc.next().equalsIgnoreCase("Y")) {
		PubService pService = new PubServiceImpl();
		System.out.println("Enter id to delete");
		pService.delete(sc.nextInt());
	}
	
	
	sc.close();
	}
	
	
	

}
