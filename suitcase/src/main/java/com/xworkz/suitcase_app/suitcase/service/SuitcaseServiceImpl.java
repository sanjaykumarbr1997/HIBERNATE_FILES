package com.xworkz.suitcase_app.suitcase.service;

import java.util.List;

import com.xworkz.suitcase_app.suitcase.dao.SuitcaseDAO;
import com.xworkz.suitcase_app.suitcase.dao.SuitcaseDAOImpl;
import com.xworkz.suitcase_app.suitcase.dto.SuitcaseDTO;

public class SuitcaseServiceImpl implements SuitcaseService {
	private SuitcaseDAO suitDAO;
	
	public SuitcaseServiceImpl() {
		suitDAO = new SuitcaseDAOImpl();
	}

	public void validateAndSave(SuitcaseDTO suiDTO) {
		if(suiDTO!=null) {
			suitDAO.save(suiDTO);
		}
		else {
			System.out.println("DTO cant be null");
		}
		

	}

	@Override
	public List<SuitcaseDTO> validateAndGetAllDetails() {
		return suitDAO.getAllDetails();
	}

	@Override
	public void validateAndUpdateColorByName(String name, int id, String color) {
		if(name!=null) {
			suitDAO.updateColorByName(name,id,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

	@Override
	public void validateAndDeleteColorByName(String name, int id) {
		if(name!=null) {
			suitDAO.deleteColorByName(name,id);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

	@Override
	public String validateAndGetSuitcaseColorBySuitcaseName(String name) {
		if(name!=null) {
			return suitDAO.getSuitcaseColorBySuitcaseName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public SuitcaseDTO validateAndGetDetailsBySuitcaseName(String name) {
		if(name!=null) {
			return suitDAO.getDetailsBySuitcaseName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public Object[] validateAndGetSuitcaseSizeAndColorBysuitcaseName(String name) {
		if(name!=null) {
			return suitDAO.getSuitcaseSizeAndColorBysuitcaseName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public List<Object[]> validateAndGetsuitcaseNameAndsuitcaseColorBysuitcaseSize(String size) {
		if(size!=null) {
			return suitDAO.getsuitcaseNameAndsuitcaseColorBysuitcaseSize(size);
		}
		else {
			System.out.println("size cant be null");
		}
		return null;
	}

	@Override
	public int validateAndUpdateSizeByNameH(String name, String size) {
		if(size!=null) {
			return suitDAO.updateSizeByNameH(name,size);
		}
		else {
			System.out.println("size cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndUpdateColorByNameH(String name, String color) {
		if(name!=null) {
			return suitDAO.updateColorByNameH(name,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByNameH(String name) {
		if(name!=null) {
			return suitDAO.deleteByNameH(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByColorH(String color) {
		if(color!=null) {
			return suitDAO.deleteByColorH(color);
		}
		else {
			System.out.println("color cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteBySizeH(String size) {
		if(size!=null) {
			return suitDAO.deleteBySizeH(size);
		}
		else {
			System.out.println("size cant be null");
		}
		return 0;
	}

	

}
