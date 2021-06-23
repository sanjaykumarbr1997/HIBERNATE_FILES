package com.xworkz.sweets_app.sweets.dao;

import java.util.List;

import com.xworkz.sweets_app.sweets.dto.SweetsDTO;

public interface SweetsDAO {

	public void save(SweetsDTO sDTO);

	public SweetsDTO getDetailsByName(int id, String name);

	public void updateColorByName(int id, String name, String color);

	public void deleteByName(int id, String name);

	public List<SweetsDTO> getAllDetails();

}
