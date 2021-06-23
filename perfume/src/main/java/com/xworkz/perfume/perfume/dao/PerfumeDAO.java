package com.xworkz.perfume.perfume.dao;

import java.util.List;

import com.xworkz.perfume.perfume.dto.PerfumeDTO;

public interface PerfumeDAO {

	void save(PerfumeDTO pDTO);

	public PerfumeDTO getDetailsByName(int id, String name);

	public void updateColorByName(int id, String name, String color);

	public void deleteDetailsByName(int id, String name);

	List<PerfumeDTO> getAllDetails();

}
