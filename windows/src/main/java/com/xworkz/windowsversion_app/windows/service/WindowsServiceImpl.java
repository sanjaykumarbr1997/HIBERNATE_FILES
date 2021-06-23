package com.xworkz.windowsversion_app.windows.service;

import java.util.List;

import com.xworkz.windowsversion_app.windows.dao.WindowsDAO;
import com.xworkz.windowsversion_app.windows.dao.WindowsDAOImpl;
import com.xworkz.windowsversion_app.windows.dto.WindowsDTO;

public class WindowsServiceImpl implements WindowsService {
	private WindowsDAO wDAO ;
	public WindowsServiceImpl() {
		wDAO = new WindowsDAOImpl();
	}

	public void validateAndSave(WindowsDTO wnDTO) {
		if(wnDTO!=null) {
			wDAO.save(wnDTO);
		}
		else {
			System.out.println("DTO cant be null");
		}
		

	}

	@Override
	public List<WindowsDTO> validateAndGetAllDetails() {
		return wDAO.getAllDetails();
	}

	@Override
	public void validateAndUpdateColorByName(String name, int id, String year) {
		if(name!=null) {
			wDAO.updateColorByName(name,id,year);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

	@Override
	public void validateAndDeleteColorByName(String name, int id) {
		if(name!=null) {
			wDAO.deleteColorByName(name,id);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}

}
