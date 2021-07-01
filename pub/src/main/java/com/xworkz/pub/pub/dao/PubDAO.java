package com.xworkz.pub.pub.dao;

import com.xworkz.pub.pub.dto.PubDTO;

public interface PubDAO {

	public void save(PubDTO pDTO);

	public PubDTO getDetailsByName(String name, int id);

	public void update(String name, int id, String contact);

	public void checking();

	public void delete(int id);

}
