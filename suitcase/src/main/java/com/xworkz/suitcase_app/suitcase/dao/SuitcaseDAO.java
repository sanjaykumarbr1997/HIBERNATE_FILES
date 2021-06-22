package com.xworkz.suitcase_app.suitcase.dao;

import java.util.List;

import com.xworkz.suitcase_app.suitcase.dto.SuitcaseDTO;

public interface SuitcaseDAO {

	public void save(SuitcaseDTO suiDTO);

	public List<SuitcaseDTO> getAllDetails();

	public void updateColorByName(String name, int id, String color);

	public void deleteColorByName(String name, int id);

}
