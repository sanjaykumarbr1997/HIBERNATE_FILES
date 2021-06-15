package com.xworkz.xworkzapp.blue_tooth.service;

import java.util.List;

import com.xworkz.xworkzapp.blue_tooth.dto.BluetoothSpeakerDTO;

public interface BluetoothSpeakerService {

	void validateAndSave(BluetoothSpeakerDTO bluetoothSpeakerDTO);

	public BluetoothSpeakerDTO validateAndGetBrandById(int id);
	
	public List<BluetoothSpeakerDTO> validateAndGetAllDetails();

	void validateAndDeleteById(int id);

	void validateAndUpdateRangeByName(int id,String range);

}
