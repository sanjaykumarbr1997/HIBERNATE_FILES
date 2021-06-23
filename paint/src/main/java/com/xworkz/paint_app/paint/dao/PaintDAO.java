package com.xworkz.paint_app.paint.dao;

import java.util.List;

import com.xworkz.paint_app.paint.dto.PaintDTO;

public interface PaintDAO {

	public void save(PaintDTO pDTO);

	public List<PaintDTO> getAllDetails();

	public void updatePriceByName(String name, int id, double price);

	public void deleteDetailsByName(String name, int id);

}
