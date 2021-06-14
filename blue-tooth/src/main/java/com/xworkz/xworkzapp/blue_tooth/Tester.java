package com.xworkz.xworkzapp.blue_tooth;

import com.xworkz.xworkzapp.blue_tooth.dto.BluetoothSpeakerDTO;
import com.xworkz.xworkzapp.blue_tooth.service.BluetoothSpeakerService;
import com.xworkz.xworkzapp.blue_tooth.service.BluetoothSpeakerServiceImpl;

public class Tester {

	public static void main(String[] args) {
		
		BluetoothSpeakerDTO bluetoothSpeakerDTO = new BluetoothSpeakerDTO();
		bluetoothSpeakerDTO.setBluetoothId(1);
		bluetoothSpeakerDTO.setBluetoothName("v2.0");
		bluetoothSpeakerDTO.setBrand("Boat");
		bluetoothSpeakerDTO.setRange("2m");
		
		
		BluetoothSpeakerService bluetoothSpeakerService = new BluetoothSpeakerServiceImpl();
		bluetoothSpeakerService.validateAndSave(bluetoothSpeakerDTO);

	}

}
