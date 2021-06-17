package com.xworkz.sweets_app.sweets.dao;

import com.xworkz.sweets_app.sweets.dto.SweetsDTO;

public interface SweetsDAO {

	void save(SweetsDTO sDTO);

	public SweetsDTO getDetailsByName(int id, String name);

	void updateColorByName(int id, String name, String color);

	void deleteByName(int id, String name);

}
