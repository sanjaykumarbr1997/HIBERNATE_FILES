package com.xworkz.xworkzapp.ipl_teams;

import java.util.Scanner;

import com.xworkz.xworkzapp.ipl_teams.dto.IplTeamDTO;
import com.xworkz.xworkzapp.ipl_teams.service.IplTeamService;
import com.xworkz.xworkzapp.ipl_teams.service.IplTeamServiceImpl;


public class Tester {
	
	public static void main(String[] args) {
		
		System.out.println("Ipl data ");
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter no of new records to store");
		int rec = sc.nextInt();
		for(int i=0;i<rec;i++) {
			System.out.println("enter team id");
			int id1 = sc.nextInt();
			System.out.println("enter team  name");
			String s1 = sc.next();
			System.out.println("enter  no of players in team");
			int p1 = sc.nextInt();
			System.out.println("enter team home location");
			String s3 = sc.next();
			
		IplTeamDTO iplDTO = new IplTeamDTO();
		iplDTO.setTeamId(id1);
		iplDTO.setTeamName(s1);
		iplDTO.setNoOfPlayers(p1);
		iplDTO.setLocation(s3);
		
		IplTeamService iplService = new IplTeamServiceImpl();
		iplService.validateAndSave(iplDTO);
		
		}
		
		System.out.println("Enter no of details to get by Name:");
		int up = sc.nextInt();
		
		for(int j=0;j<up;j++) {
			
			System.out.println("Enter team name");
			String name = sc.next();
			System.out.println("Enter correct team id");
			int id1 = sc.nextInt();			
		IplTeamService iplService = new IplTeamServiceImpl();

		IplTeamDTO iDTO = iplService.validateAndGetDetailsByName(name,id1);
		System.out.println(iDTO);
		}
		
		
		
		
		
		System.out.println("Enter number of records to delete");
		int del = sc.nextInt();
		
		for(int l=0;l<del;l++) {
		System.out.println("Enter id to delete ");
		int idd = sc.nextInt();		
		IplTeamService iplServic = new IplTeamServiceImpl();
		iplServic.validateAndDeleteById(idd);
		System.out.println("deleted");
		}
		
		
		
		System.out.println("Enter number of records to update no. of players by name");
		int uid = sc.nextInt();
		for(int m=0;m<uid;m++) {
			System.out.println("enter team name to update noOfPlayers");
			String nam = sc.next();
			
			System.out.println("enter correct team id");
			int id3 = sc.nextInt();
			System.out.println("enter no of players");
			int players = sc.nextInt();
		IplTeamService iplSService = new IplTeamServiceImpl();
		System.out.println("updating details by name");
		iplSService.validateAndUpdateRangeByName(nam,id3,players);
		}
		
			
		
		sc.close();
	}

}
