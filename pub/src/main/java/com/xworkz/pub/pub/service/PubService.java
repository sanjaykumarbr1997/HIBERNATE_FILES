package com.xworkz.pub.pub.service;

import com.xworkz.pub.pub.dto.PubDTO;

public interface PubService {

	public void validateAndSave(PubDTO pDTO);

	public PubDTO validateAndGetDetailsByName(String name, int id);

	public void validateAndUpdateContactDetailsByName(String name, int id, String contact);

	public void checking();


	public void delete(int id);



}
