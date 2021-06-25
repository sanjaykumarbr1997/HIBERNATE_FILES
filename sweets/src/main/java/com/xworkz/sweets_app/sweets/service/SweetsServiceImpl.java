package com.xworkz.sweets_app.sweets.service;

import java.util.List;

import com.xworkz.sweets_app.sweets.dao.SweetsDAO;
import com.xworkz.sweets_app.sweets.dao.SweetsDAOImpl;
import com.xworkz.sweets_app.sweets.dto.SweetsDTO;

public class SweetsServiceImpl implements SweetsService {
	
	
	private SweetsDAO sDAO ;
	
	public SweetsServiceImpl() {
		sDAO = new SweetsDAOImpl();
	}

	public void valideAndSave(SweetsDTO sDTO) {
		if(sDTO!=null) {
			sDAO.save(sDTO);
		}
		else {
			System.out.println("object cant be empty");
		}
	}

	public SweetsDTO validateAndGetDetailsByName(int id, String name) {
		if(name!=null) {
			return sDAO.getDetailsByName(id,name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	public void validateAndUpdate(int id, String name, String color) {
		if(name!=null) {
			sDAO.updateColorByName(id,name,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}

	public void validateAndDelete(int id, String name) {
		if(name!=null) {
			sDAO.deleteByName(id,name);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}

	public List<SweetsDTO> validateAndGetAllDetails() {
		return sDAO.getAllDetails();
	}

	@Override
	public String validateAndGetSweetsColorBySweetName(String name) {
		if(name!=null) {
			return sDAO.getSweetsColorBySweetName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		return null;
	}

	@Override
	public SweetsDTO validateAndGetDetailsBySweetName(String name) {
		if(name!=null) {
			return sDAO.getDetailsBySweetName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public Object[] validateAndGetsweetsShapeAndColorBySweetName(String name) {
		if(name!=null) {
			return sDAO.getsweetShapeAndColorBySweetName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public List<Object[]> validateAndGetsweetPriceAndsweetColorBysweetshape(String shape) {
		if(shape!=null) {
			return sDAO.getsweetPriceAndsweetColorBysweetshape(shape);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public int validateAndUpdatePriceByNameH(String name, double price) {
		if(name!=null) {
			return sDAO.updatePriceByNameH(name,price);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndUpdateColorByNameH(String name, String color) {
		if(name!=null) {
			return sDAO.updateColorByNameH(name,color);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndUpdatesweetshapeByNameH(String name, String shape) {
		if(name!=null) {
			return sDAO.updatesweetshapeByNameH(name,shape);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByNameH(String name) {
		if(name!=null) {
			return sDAO.deleteByNameH(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByPriceH(double price) {
		if(price!=0) {
			return sDAO.deleteByPriceH(price);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByColorH(String color) {
		if(color!=null) {
			return sDAO.deleteByColorH(color);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

}
