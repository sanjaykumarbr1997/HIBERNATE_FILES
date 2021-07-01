package com.xworkz.icecream_app.icecream.service;

import com.xworkz.icecream_app.icecream.dao.IceCreamDAO;
import com.xworkz.icecream_app.icecream.dao.IceCreamDAOImpl;
import com.xworkz.icecream_app.icecream.dto.IceCreamDTO;

public class IceCreamServiceImpl implements IceCreamService {
	private IceCreamDAO iDAO ;
	
	public IceCreamServiceImpl() {
		iDAO = new IceCreamDAOImpl();
	}

	public void validateAndSave(IceCreamDTO iDTO) {
		iDAO.save(iDTO);

	}

}
