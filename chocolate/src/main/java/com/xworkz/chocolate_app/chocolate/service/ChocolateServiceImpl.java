package com.xworkz.chocolate_app.chocolate.service;

import java.util.List;

import com.xworkz.chocolate_app.chocolate.dao.ChocolateDAO;
import com.xworkz.chocolate_app.chocolate.dao.ChocolateDAOImpl;
import com.xworkz.chocolate_app.chocolate.dto.ChocoloateDTO;

public class ChocolateServiceImpl implements ChocolateService {
	
	private ChocolateDAO cDAO;
	public ChocolateServiceImpl() {
		cDAO = new ChocolateDAOImpl();
	}

	@Override
	public void validateAndSave(ChocoloateDTO cDTO) {
		if(cDTO!=null) {
			cDAO.save(cDTO);
		}
		else {
			System.out.println("DTO cant be null");
		}
		

	}

	@Override
	public List<ChocoloateDTO> validateAndGetAllDetails() {
		return cDAO.getAllDetails();
	}

	@Override
	public void validateAndUpdateColorByName(String name, int id, String color) {
		if(name!=null) {
			cDAO.updateColorByName(name,id,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

	@Override
	public void validateAndDeleteColorByName(String name, int id) {
		if(name!=null) {
			cDAO.deleteColorByName(name,id);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}

	@Override
	public String validateAndGetChocolateCompanyByChocolateName(String name) {
		if(name!=null) {
			return cDAO.getChocolateCompanyByChocolateName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public ChocoloateDTO validateAndGetDetailsByChocolatename(String name) {
		if(name!=null) {
			return cDAO.getDetailsByChocolatename(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public Object[] validateAndGetChocolatePriceAndChocolateColorByChocolateName(String name) {
		if(name!=null) {
			return cDAO.getChocolatePriceAndChocolateColorByChocolateName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public List<Object[]> validateAndGetchocolatePriceAndchocolateColorByChocolateName(String name) {
		if(name!=null) {
			return cDAO.getchocolatePriceAndchocolateColorByChocolateName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public int validateAndUpdatePriceByNameH(String name, double price) {
		if(name!=null) {
			return cDAO.updatePriceByNameH(name,price);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndUpdateColorByNameH(String name, String color) {
		if(name!=null) {
			return cDAO.updateColorByNameH(name,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndUpdateChocolateCompanyByNameH(String name, String companyName) {
		if(name!=null) {
			return cDAO.updateCompanyNameByNameH(name,companyName);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByNameH(String name) {
		if(name!=null) {
			return cDAO.deleteByNameH(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByPriceH(double price) {
		if(price!=0) {
			return cDAO.deleteByPriceH(price);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByColorH(String color) {
		if(color!=null) {
			return cDAO.deleteByColorH(color);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}
	
	

}
