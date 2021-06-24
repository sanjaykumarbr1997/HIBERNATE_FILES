package com.xworkz.paint_app.paint.service;

import java.util.List;

import com.xworkz.paint_app.paint.dao.PaintDAO;
import com.xworkz.paint_app.paint.dao.PaintDAOImpl;
import com.xworkz.paint_app.paint.dto.PaintDTO;

public class PaintServiceImpl implements PaintService {
	private PaintDAO pDAO;
	
	public PaintServiceImpl() {
		pDAO = new PaintDAOImpl();
	}

	public void validateAndSave(PaintDTO pDTO) {
		
		if(pDTO!=null) {
			pDAO.save(pDTO);
			
		}
		else {
			System.out.println("DTO cant be empty");
		}

	}

	@Override
	public List<PaintDTO> validateAndGetAllDetails() {
		return pDAO.getAllDetails();
	}

	@Override
	public void validateAndUpdatePriceByName(String name, int id, double price) {
		if(name!=null) {
			pDAO.updatePriceByName(name,id,price);
			
		}
		else {
			System.out.println("Name cant be empty");
		}
		
	}

	@Override
	public void validateAndDeleteDetailsByName(String name, int id) {
		if(name!=null) {
			pDAO.deleteDetailsByName(name,id);
			
		}
		else {
			System.out.println("Name cant be empty");
		}
		
	}

	@Override
	public String validateAndGetPaintColorByPrice(double price) {
		if(price!=0) {
			return pDAO.getPintColorByPrice(price);
		}
		else {
			System.out.println("Price cant be zero ");
		}
		return null;
	}

	@Override
	public PaintDTO validateAndGetDetailsByName(String name) {
		if(name!=null) {
			return pDAO.getDetailsByName(name);
		}
		else {
			System.out.println("Name cant be null ");
		}
		return null;
	}

	@Override
	public Object[] validateAndGetPaintPriceAndPaintColorByName(String name) {
		if(name!=null) {
			return pDAO.getPaintPriceAndPaintColorByName(name);
		}
		else {
			System.out.println("Name cant be null ");
		}
		return null;
	}

	@Override
	public List<Object[]> validateAndGetPaintPriceAndPaintColorByExpiryYear(int year) {
		if(year!=0) {
		return pDAO.getPaintPriceAndPaintColorByExpiryYear(year);
		}
		else {
			System.out.println("year cant be null");
		}
		return null;
	}

	@Override
	public int validateAndUpdatePriceByNameH(String name, double price) {
		if(name!=null) {
			return pDAO.updatePriceByNameH(name,price);
			}
			else {
				System.out.println("year cant be null");
			}
			return (Integer) null;
	}

	@Override
	public int validateAndDeletPriceByNameH(String name) {
		if(name!=null) {
			return pDAO.deletPriceByNameH(name);
			}
			else {
				System.out.println("year cant be null");
			}
			return (Integer) null;
	}


}
