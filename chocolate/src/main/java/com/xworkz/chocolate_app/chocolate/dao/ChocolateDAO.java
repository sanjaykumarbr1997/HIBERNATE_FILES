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

}
