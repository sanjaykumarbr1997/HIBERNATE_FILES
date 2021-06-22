package com.xworkz.xworkzapp.ipl_teams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xworkz.xworkzapp.ipl_teams.dto.IplTeamDTO;
import com.xworkz.xworkzapp.ipl_teams.service.IplTeamService;
import com.xworkz.xworkzapp.ipl_teams.service.IplTeamServiceImpl;


public class Tester {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Ipl data ");
		Scanner sc = new Scanner(System.in);
		System.out.println("How do you prefer adding data:");
		System.out.println("Press \"D\" to enter dynamically or press \" E \"to import from Excel ");
		if(sc.next().equalsIgnoreCase("D")) {
		
		
		System.out.println("Enter no of new records to store");
		int rec = sc.nextInt();
		for(int i=0;i<rec;i++) {
			
			System.out.println("enter team  name");
			String s1 = sc.next();
			System.out.println("enter  no of players in team");
			int p1 = sc.nextInt();
			System.out.println("enter team home location");
			String s3 = sc.next();
			
		IplTeamDTO iplDTO = new IplTeamDTO();
		iplDTO.setTeamName(s1);
		iplDTO.setNoOfPlayers(p1);
		iplDTO.setLocation(s3);
		
		IplTeamService iplService = new IplTeamServiceImpl();
		iplService.validateAndSave(iplDTO);
		
		}
		}
		else {
			readXLSXFile("E:\\excel-poi\\Ipl.xlsx");
			
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
		
		writeXLSXFile("E:\\excel-poi\\Ipl.xlsx",iDTO);
		
		
		
		
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
		private static void writeXLSXFile( String file1, IplTeamDTO iDTO) throws IOException  {
			XSSFWorkbook wrk = new XSSFWorkbook();
			XSSFSheet sht = wrk.createSheet("Sheet2");
			
			sht.createRow(iDTO.getTeamId());
			sht.getRow((iDTO.getTeamId())).createCell(0).setCellValue(iDTO.getTeamId());
			sht.getRow((iDTO.getTeamId())).createCell(1).setCellValue(iDTO.getTeamName());
			sht.getRow((iDTO.getTeamId())).createCell(2).setCellValue(iDTO.getNoOfPlayers());
			sht.getRow((iDTO.getTeamId())).createCell(3).setCellValue(iDTO.getLocation());
			
			FileOutputStream osfile = null;
			try {
				osfile = new FileOutputStream(file1);
				wrk.write(osfile);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			osfile.close();
			wrk.close();
		}
	

	private static void readXLSXFile(String file) {
		
		try {
			XSSFWorkbook work = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = work.getSheet("Sheet1");
			XSSFRow row = null  ;
			
			
		int i =1;
		while((row=sheet.getRow(i))!=null) {
		
			IplTeamDTO ipDTO = new IplTeamDTO();
			
			ipDTO.setTeamName(row.getCell(1).getStringCellValue());
			int np = (int)row.getCell(2).getNumericCellValue();
			ipDTO.setNoOfPlayers(np);
			ipDTO.setLocation(row.getCell(3).getStringCellValue());
			i++;
			
			
			IplTeamService iplService = new IplTeamServiceImpl();
			iplService.validateAndSave(ipDTO);
		}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
