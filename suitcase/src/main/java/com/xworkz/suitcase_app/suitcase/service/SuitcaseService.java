package com.xworkz.suitcase_app.suitcase.service;

import java.util.List;

import com.xworkz.suitcase_app.suitcase.dto.SuitcaseDTO;

public interface SuitcaseService {

	public void validateAndSave(SuitcaseDTO suiDTO);

	public List<SuitcaseDTO> validateAndGetAllDetails();

	public void validateAndUpdateColorByName(String name, int id, String color);

	public void validateAndDeleteColorByName(String name, int id);

	public String validateAndGetSuitcaseColorBySuitcaseName(String name);

	public SuitcaseDTO validateAndGetDetailsBySuitcaseName(String name);

	public Object[] validateAndGetSuitcaseSizeAndColorBysuitcaseName(String name);

}
