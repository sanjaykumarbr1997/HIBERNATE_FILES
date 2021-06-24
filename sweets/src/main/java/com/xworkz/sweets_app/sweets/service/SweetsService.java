package com.xworkz.sweets_app.sweets.service;

import java.util.List;

import com.xworkz.sweets_app.sweets.dto.SweetsDTO;

public interface SweetsService {

	void valideAndSave(SweetsDTO sDTO);

	public SweetsDTO validateAndGetDetailsByName(int id, String name);

	public void validateAndUpdate(int id, String name, String color);

	void validateAndDelete(int id, String name);

	List<SweetsDTO> validateAndGetAllDetails();

	String validateAndGetSweetsColorBySweetName(String name);

	SweetsDTO validateAndGetDetailsBySweetName(String name);

	Object[] validateAndGetsweetsShapeAndColorBySweetName(String name);

}
