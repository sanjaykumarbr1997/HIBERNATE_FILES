package com.xworkz.windowsversion_app.windows.service;

import java.util.List;

import com.xworkz.windowsversion_app.windows.dto.WindowsDTO;

public interface WindowsService {

	public void validateAndSave(WindowsDTO suiDTO);

	public List<WindowsDTO> validateAndGetAllDetails();

	public void validateAndUpdateYearByName(String name, int id, int year);

	public void validateAndDeleteByName(String name, int nameInt);

	public String validateAndGetwindowsNewFeaturesByWindowsName(String name);

	public WindowsDTO validateAndGetDetailsByWindowsName(String name);

	public Object[] validateAndGetwindowsReleaseYearAndNewFeaturesByWindowsName(String name);

}
