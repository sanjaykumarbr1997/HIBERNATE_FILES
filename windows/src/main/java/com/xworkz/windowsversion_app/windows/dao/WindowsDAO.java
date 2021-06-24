package com.xworkz.windowsversion_app.windows.dao;

import java.util.List;

import com.xworkz.windowsversion_app.windows.dto.WindowsDTO;

public interface WindowsDAO {

	void save(WindowsDTO wnDTO);

	List<WindowsDTO> getAllDetails();

	void updateColorByName(String name, int id, int year);

	void deleteByName(String name, int id);

	String getwindowsNewFeaturesByWindowsName(String name);

	WindowsDTO getDetailsByWindowsName(String name);

	Object[] getwindowsReleaseYearAndNewFeaturesByWindowsName(String name);

}
