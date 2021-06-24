package com.xworkz.chocolate_app.chocolate.service;

import java.util.List;

import com.xworkz.chocolate_app.chocolate.dto.ChocoloateDTO;

public interface ChocolateService {

	public void validateAndSave(ChocoloateDTO cDTO);

	public List<ChocoloateDTO> validateAndGetAllDetails();

	public void validateAndUpdateColorByName(String name, int id, String color);

	public void validateAndDeleteColorByName(String name, int id);

	public String validateAndGetChocolateCompanyByChocolateName(String name);

	public ChocoloateDTO validateAndGetDetailsByChocolatename(String name);

	public Object[] validateAndGetChocolatePriceAndChocolateColorByChocolateName(String name);

	public List<Object[]> validateAndGetchocolatePriceAndchocolateColorByChocolateName(String name);

	public int validateAndUpdatePriceByNameH(String name, double price);

	public int validateAndUpdateColorByNameH(String naem, String color);

	public int validateAndUpdateChocolateCompanyByNameH(String name, String companyName);

	public int validateAndDeleteByNameH(String name);

	public int validateAndDeleteByPriceH(double price);

	public int validateAndDeleteByColorH(String color);


	
}
