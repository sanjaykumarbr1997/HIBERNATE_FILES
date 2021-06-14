package com.xworkz.xworkzapp.blue_tooth.service;

import com.xworkz.xworkzapp.blue_tooth.dao.BluetoothSpeakerDAO;
import com.xworkz.xworkzapp.blue_tooth.dao.BluetoothSpeakerDAOImpl;
import com.xworkz.xworkzapp.blue_tooth.dto.BluetoothSpeakerDTO;

public class BluetoothSpeakerServiceImpl implements BluetoothSpeakerService {
	
	private BluetoothSpeakerDAO bluetoothSpeakerDAO ;
	
	public BluetoothSpeakerServiceImpl(){
		
		bluetoothSpeakerDAO = new BluetoothSpeakerDAOImpl();
		
		
	}
	

	public void validateAndSave(BluetoothSpeakerDTO bluetoothSpeakerDTO) {
		if(bluetoothSpeakerDTO!=null) {
			
			bluetoothSpeakerDAO.save(bluetoothSpeakerDTO);
		}
		else {
			System.out.println("object cant be empty");
		}
		
		
		
	}

}
