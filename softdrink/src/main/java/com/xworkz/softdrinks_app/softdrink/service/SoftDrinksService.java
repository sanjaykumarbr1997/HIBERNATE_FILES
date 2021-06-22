package com.xworkz.softdrinks_app.softdrink.service;

import java.util.List;

import com.xworkz.softdrinks_app.softdrink.dto.SoftDrinksDTO;

public interface SoftDrinksService {

	public void validateAndSave(SoftDrinksDTO sDTO);

	public List<SoftDrinksDTO> validateAndGetAllDetails();

	public void validateAndUpdateColorByName(String name, int id, String color);

	public void validateAndDeleteColorByName(String name, int id);

}
