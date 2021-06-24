package com.xworkz.xworkzapp.blue_tooth.dao;

import java.util.List;

import com.xworkz.xworkzapp.blue_tooth.dto.BluetoothSpeakerDTO;

public interface BluetoothSpeakerDAO {


	void save(BluetoothSpeakerDTO bluetoothSpeakerDTO);

	public BluetoothSpeakerDTO getBrandById(int id);

	public List<BluetoothSpeakerDTO> getAllDetails();

	void deleteById(int id);

	void updateRangeByName(int id,String range);

	BluetoothSpeakerDTO getDetailsByBluetoothBrand(String brand);

	String getBluetoothNameByBrand(String brand);

	Object[] getBluetoothRangeAndbluetoothNameByBrand(String brand);


}
