package com.xworkz.suitcase_app.suitcase.dao;

import java.util.List;

import com.xworkz.suitcase_app.suitcase.dto.SuitcaseDTO;

public interface SuitcaseDAO {

	public void save(SuitcaseDTO suiDTO);

	public List<SuitcaseDTO> getAllDetails();

	public void updateColorByName(String name, int id, String color);

	public void deleteColorByName(String name, int id);

	public String getSuitcaseColorBySuitcaseName(String name);

	public SuitcaseDTO getDetailsBySuitcaseName(String name);

	public Object[] getSuitcaseSizeAndColorBysuitcaseName(String name);

	public List<Object[]> getsuitcaseNameAndsuitcaseColorBysuitcaseSize(String size);

	public int updateSizeByNameH(String name,String size);


	public int updateColorByNameH(String name, String color);

	public int deleteByNameH(String name);

	public int deleteByColorH(String color);

	public int deleteBySizeH(String size);

}
