package com.xworkz.xworkzapp.blue_tooth;

import java.util.List;
import java.util.Scanner;

import com.xworkz.xworkzapp.blue_tooth.dto.BluetoothSpeakerDTO;
import com.xworkz.xworkzapp.blue_tooth.service.BluetoothSpeakerService;
import com.xworkz.xworkzapp.blue_tooth.service.BluetoothSpeakerServiceImpl;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Bluetooth speaker data ");
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter no of new records to store");
		int rec = sc.nextInt();
		for(int i=0;i<rec;i++) {
			System.out.println("enter id");
			int id1 = sc.nextInt();
			System.out.println("enter Bluetooth  Name");
			String s1 = sc.next();
			System.out.println("enter Bluetooth Speaker Brand");
			String s2 = sc.next();
			System.out.println("enter Bluetooth Speaker Range");
			String s3 = sc.next();
			
		BluetoothSpeakerDTO bluetoothSpeakerDTO = new BluetoothSpeakerDTO();
		bluetoothSpeakerDTO.setBluetoothId(id1);
		bluetoothSpeakerDTO.setBluetoothName(s1);
		bluetoothSpeakerDTO.setBrand(s2);
		bluetoothSpeakerDTO.setRange(s3);
		
		BluetoothSpeakerService bluetoothSpeakerService = new BluetoothSpeakerServiceImpl();
		bluetoothSpeakerService.validateAndSave(bluetoothSpeakerDTO);
		
		}
		
		System.out.println("Enter no of details to get by ID:");
		int up = sc.nextInt();
		
		for(int j=0;j<up;j++) {
			int id4 = sc.nextInt();
		BluetoothSpeakerService bluetootSpeakerService = new BluetoothSpeakerServiceImpl();
		System.out.println("Enter id");
		BluetoothSpeakerDTO bD = bluetootSpeakerService.validateAndGetBrandById(id4);
		System.out.println(bD);
		}
		
		
		
		
		//BluetoothSpeakerService bluetoothSService = new BluetoothSpeakerServiceImpl();
		//List<BluetoothSpeakerDTO> bDTOs = bluetoothSService.validateAndGetAllDetails();
		/*for(BluetoothSpeakerDTO bs:bDTOs) {
			System.out.println(bs);
		} */
		
		System.out.println("Enter number of records to delete");
		int del = sc.nextInt();
		
		for(int l=0;l<del;l++) {
		System.out.println("Enter id to delete ");
		int idd = sc.nextInt();		
		BluetoothSpeakerService blueToothSServic = new BluetoothSpeakerServiceImpl();
		blueToothSServic.validateAndDeleteById(idd);
		System.out.println("deleted");
		}
		
		System.out.println("Enter number of records to update by id");
		int uid = sc.nextInt();
		for(int m=0;m<uid;m++) {
			System.out.println("enter id to update");
			int iddd = sc.nextInt();
			System.out.println("enter new range");
			String rang = sc.next();
		BluetoothSpeakerService bluToothSService = new BluetoothSpeakerServiceImpl();
		System.out.println("updating details by range");
		bluToothSService.validateAndUpdateRangeByName(iddd,rang);
		}
		

	}

}
