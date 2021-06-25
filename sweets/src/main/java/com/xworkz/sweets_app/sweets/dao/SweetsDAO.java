package com.xworkz.sweets_app.sweets.dao;

import java.util.List;

import com.xworkz.sweets_app.sweets.dto.SweetsDTO;

public interface SweetsDAO {

	public void save(SweetsDTO sDTO);

	public SweetsDTO getDetailsByName(int id, String name);

	public void updateColorByName(int id, String name, String color);

	public void deleteByName(int id, String name);

	public List<SweetsDTO> getAllDetails();

	public String getSweetsColorBySweetName(String name);

	public SweetsDTO getDetailsBySweetName(String name);

	public Object[] getsweetShapeAndColorBySweetName(String name);

	public List<Object[]> getsweetPriceAndsweetColorBysweetshape(String shape);

	public int updatePriceByNameH(String name, double price);

	public int updateColorByNameH(String name, String color);

	public int updatesweetshapeByNameH(String name, String shape);

	public int deleteByNameH(String name);

	public int deleteByPriceH(double price);

	public int deleteByColorH(String color);

}
