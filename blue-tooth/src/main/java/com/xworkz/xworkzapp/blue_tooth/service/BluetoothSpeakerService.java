package com.xworkz.xworkzapp.blue_tooth.service;

import java.util.List;

import com.xworkz.xworkzapp.blue_tooth.dto.BluetoothSpeakerDTO;

public interface BluetoothSpeakerService {

	void validateAndSave(BluetoothSpeakerDTO bluetoothSpeakerDTO);

	public BluetoothSpeakerDTO validateAndGetBrandById(int id);
	
	public List<BluetoothSpeakerDTO> validateAndGetAllDetails();

	void validateAndDeleteById(int id);

	void validateAndUpdateRangeByName(int id,String range);

	String validateAndGetBluetoothNameByBrand(String brand);


	BluetoothSpeakerDTO validateAndGetDetailsByBluetoothBrand(String brand);

	Object[] validateAndGetBluetoothRangeAndbluetoothNameByBrand(String brand);

	List<Object[]> validateAndGetbluetoothRangeAndbluetoothNameBybluetoothCompanyName(String brand);

	int validateAndUpdateNameByBrandH(String brand, String name);

	int validateAndUpdateRangeByNameH(String brand, String range);

	int validateAndDeleteByBrandH(String brand);

	int validateAndDeleteByRangeH(String range);

	int validateAndDeleteByBluetoothNameH(String bluetoothName);

}
