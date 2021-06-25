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

	public List<WindowsDTO> validateAndGetAllDetails() {
		return wDAO.getAllDetails();
	}

	public void validateAndUpdateYearByName(String name, int id, int year) {
		if(name!=null) {
			wDAO.updateColorByName(name,id,year);
		}
		else {
			System.out.println("Name cant be null");
		}
		
	}

	public void validateAndDeleteByName(String name, int id) {
		if(name!=null) {
			wDAO.deleteByName(name,id);
		}
		else {
			System.out.println("Name cant be null");
		}
		
		
	}

	@Override
	public String validateAndGetwindowsNewFeaturesByWindowsName(String name) {
		if(name!=null) {
			return wDAO.getwindowsNewFeaturesByWindowsName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public WindowsDTO validateAndGetDetailsByWindowsName(String name) {
		if(name!=null) {
			return wDAO.getDetailsByWindowsName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public Object[] validateAndGetwindowsReleaseYearAndNewFeaturesByWindowsName(String name) {
		if(name!=null) {
			return wDAO.getwindowsReleaseYearAndNewFeaturesByWindowsName(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public List<Object[]> validateAndGetwindowsNameAndwindowsNewFeaturesBywindowsReleaseYear(int releaseYear) {
		if(releaseYear!=0) {
			return wDAO.getwindowsNameAndwindowsNewFeaturesBywindowsReleaseYear(releaseYear);
		}
		else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public int validateAndUpdateReleaseYearByNameH(String name, int releaseYear) {
		if(releaseYear!=0) {
			return wDAO.updateReleaseYearByNameH(name,releaseYear);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndUpdateFearureByNameH(String name, String feature) {
		if(name!=null) {
			return wDAO.updateFearureByNameH(name,feature);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByNameH(String name) {
		if(name!=null) {
			return wDAO.deleteByNameH(name);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByYearH(int year) {
		if(year!=0) {
			return wDAO.deleteByYearH(year);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

	@Override
	public int validateAndDeleteByFeatureH(String feature) {
		if(feature!=null) {
			return wDAO.deleteByFeatureH(feature);
		}
		else {
			System.out.println("Name cant be null");
		}
		return 0;
	}

}
