package com.xworkz.windowsversion_app.windows.dao;

import java.util.List;

import com.xworkz.windowsversion_app.windows.dto.WindowsDTO;

public interface WindowsDAO {

	void save(WindowsDTO wnDTO);

	List<WindowsDTO> getAllDetails();

	void updateColorByName(String name, int id, String year);

	void deleteColorByName(String name, int id);

}
