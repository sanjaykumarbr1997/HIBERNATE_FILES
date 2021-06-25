package com.xworkz.xworkzapp.ipl_teams.service;

import java.util.List;

import com.xworkz.xworkzapp.ipl_teams.dao.IplTeamDAO;
import com.xworkz.xworkzapp.ipl_teams.dao.IplTeamDAOImpl;
import com.xworkz.xworkzapp.ipl_teams.dto.IplTeamDTO;

public class IplTeamServiceImpl implements IplTeamService {
	
	private IplTeamDAO iplDAO;
	
	public IplTeamServiceImpl() {
		iplDAO = new IplTeamDAOImpl();
	}
	
	

	public void validateAndSave(IplTeamDTO iplDTO) {
		if(iplDTO!=null) {
			
			iplDAO.save(iplDTO);
			
		}
		else {
			System.out.println("Object cant be empty");
		}
		
	}



	public IplTeamDTO validateAndGetDetailsByName(String name,int id) {
		
		if(name!= null) {
			return iplDAO.getDetailsByName(name,id);
		}
		else {
			System.out.println("name cant be empty");
		}
		return null;
	}



	public void validateAndDeleteById(int idd) {
		if(idd!=0) {
			iplDAO.deleteDetails(idd);
		}
		else {
			System.out.println("id cant be empty");
		}
	}



	public void validateAndUpdateRangeByName(String name,int id, int players) {
		if(name!=null&&players>10&&players<14) {
			iplDAO.updateDetails(name,id,players);
		}
		
	}



	@Override
	public List<IplTeamDTO> validateAndGetAllDetails() {
		return iplDAO.getAllDetails();
	}



	@Override
	public String validateAndGetIplTeamLocationByIplTeamName(String name) {
		if(name!=null) {
			return iplDAO.getIplTeamLocationByIplTeamName(name);
		}
		else {
			System.out.println("name cant be empty");
		}
		return null;
	}



	@Override
	public IplTeamDTO validateAndGetDetailsByIplTeamName(String name) {
		if(name!=null) {
			return iplDAO.getDetailsByIplTeamName(name);
		}
		else {
			System.out.println("name cant be empty");
		}
		return null;
	}



	@Override
	public Object[] validateAndGetIplTeamLocationAndNoOfPlayersByIplTeamName(String name) {
		if(name!=null) {
			return iplDAO.getIplTeamLocationAndNoOfPlayersByIplTeamName(name);
		}
		else {
			System.out.println("name cant be empty");
		}
		return null;
	}



	@Override
	public List<Object[]> validateAndGetiplTeamNameAndNoofPlayersByiplTeamLocation(String location) {
		if(location!=null) {
			return iplDAO.getiplTeamNameAndNoofPlayersByiplTeamLocation(location);
		}
		else {
			System.out.println("location cant be empty");
		}
		return null;
	}



	@Override
	public int validateAndUpdateNoOfPlayersByNameH(String name, int players) {
		if(name!=null ) {
			return iplDAO.updateNoOfPlayersByNameH(name,players);
		}
		return 0;
	}



	@Override
	public int validateAndUpdateTeamNameByLocationH(String location, String name) {
		if(name!=null ) {
			return iplDAO.updateTeamNameByLocation(location,name);
		}
		return 0;
	}



	@Override
	public int validateAndDeleteByNameH(String name) {
		if(name!=null ) {
			return iplDAO.deleteByNameH(name);
		}
		return 0;
	}



	@Override
	public int validateAndDeleteByLocationH(String location) {
		if(location!=null ) {
			return iplDAO.deleteLocationH(location);
		}
		return 0;
	}



	@Override
	public int validateAndDeleteBySizeH(int size) {
		if(size!=0) {
			return iplDAO.deleteBySizeH(size);
		}
		return 0;
	}

}
