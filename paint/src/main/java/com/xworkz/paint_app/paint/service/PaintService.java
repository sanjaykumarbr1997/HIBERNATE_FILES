package com.xworkz.paint_app.paint.service;

import java.util.List;

import com.xworkz.paint_app.paint.dto.PaintDTO;

public interface PaintService {

	public void validateAndSave(PaintDTO pDTO);

	public List<PaintDTO> validateAndGetAllDetails();

	public void validateAndUpdatePriceByName(String name, int id, double price);

	public void validateAndDeleteDetailsByName(String name, int id);

	public String validateAndGetPaintColorByPrice(double price);

	public PaintDTO validateAndGetDetailsByName(String name);

	public Object[] validateAndGetPaintPriceAndPaintColorByName(String name);

	public List<Object[]> validateAndGetPaintPriceAndPaintColorByExpiryYear(int year);

	public int validateAndUpdatePriceByNameH(String name, double price);

	public int validateAndDeletPriceByNameH(String name);

	

}
