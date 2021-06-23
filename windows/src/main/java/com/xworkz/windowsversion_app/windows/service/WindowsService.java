package com.xworkz.windowsversion_app.windows.service;

import java.util.List;

import com.xworkz.windowsversion_app.windows.dto.WindowsDTO;

public interface WindowsService {

	public void validateAndSave(WindowsDTO suiDTO);

	public List<WindowsDTO> validateAndGetAllDetails();

	public void validateAndUpdateColorByName(String next, int nextInt, String next2);

	public void validateAndDeleteColorByName(String next, int nextInt);

}
