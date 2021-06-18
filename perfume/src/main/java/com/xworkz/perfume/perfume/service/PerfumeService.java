package com.xworkz.perfume.perfume.service;

import com.xworkz.perfume.perfume.dto.PerfumeDTO;

public interface PerfumeService {

	void vaidateAndSave(PerfumeDTO pDTO);

	public PerfumeDTO validateAndGetDetailsByName(int id, String name);

	void validateAndUpdateColorByName(int id, String name, String color);

	void validateAndDeleteDetailsByName(int id, String name);
	
	
}
