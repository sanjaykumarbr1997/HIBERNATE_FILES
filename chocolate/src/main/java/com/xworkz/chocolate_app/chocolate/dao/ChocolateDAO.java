package com.xworkz.chocolate_app.chocolate.dao;

import java.util.List;

import com.xworkz.chocolate_app.chocolate.dto.ChocoloateDTO;

public interface ChocolateDAO {

	public void save(ChocoloateDTO cDTO);

	public List<ChocoloateDTO> getAllDetails();

	public void updateColorByName(String name, int id, String color);

	public void deleteColorByName(String name, int id);

	public String getChocolateCompanyByChocolateName(String name);

	public ChocoloateDTO getDetailsByChocolatename(String name);

	public Object[] getChocolatePriceAndChocolateColorByChocolateName(String name);

	public List<Object[]> getchocolatePriceAndchocolateColorByChocolateName(String name);

	public int updatePriceByNameH(String name,double price);

	public int updateColorByNameH(String name, String color);

	public int updateCompanyNameByNameH(String name, String companyName);

	public int deleteByNameH(String name);

	public int deleteByPriceH(double price);

	public int deleteByColorH(String color);

}
