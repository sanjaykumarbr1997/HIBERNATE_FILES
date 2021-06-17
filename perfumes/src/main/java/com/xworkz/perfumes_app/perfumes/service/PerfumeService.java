package com.xworkz.perfumes_app.perfumes.service;

import com.xworkz.perfumes_app.perfumes.dto.PerfumeDTO;

public interface PerfumeService {

	void vaidateAndSave(PerfumeDTO pDTO);

	public PerfumeDTO validateAndGetDetailsByName(int id, String name);

	void validateAndUpdateColorByName(int id, String name, String color);

	void validateAndDeleteDetailsByName(int id, String name);
	
	
}
