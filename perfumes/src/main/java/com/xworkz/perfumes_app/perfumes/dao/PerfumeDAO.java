package com.xworkz.perfumes_app.perfumes.dao;

import com.xworkz.perfumes_app.perfumes.dto.PerfumeDTO;

public interface PerfumeDAO {

	void save(PerfumeDTO pDTO);

	public PerfumeDTO getDetailsByName(int id, String name);

	public void updateColorByName(int id, String name, String color);

	public void deleteDetailsByName(int id, String name);

}
