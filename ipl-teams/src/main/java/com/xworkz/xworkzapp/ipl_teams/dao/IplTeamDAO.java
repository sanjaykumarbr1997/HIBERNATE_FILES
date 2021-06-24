package com.xworkz.xworkzapp.ipl_teams.dao;

import java.util.List;

import com.xworkz.xworkzapp.ipl_teams.dto.IplTeamDTO;

public interface IplTeamDAO {

	 public void save(IplTeamDTO iplDTO);

	public IplTeamDTO getDetailsByName(String name,int id);

	public void deleteDetails(int idd);

	public void updateDetails(String name, int id, int players);

	public List<IplTeamDTO> getAllDetails();

	public String getIplTeamLocationByIplTeamName(String name);

	public IplTeamDTO getDetailsByIplTeamName(String name);

	public Object[] getIplTeamLocationAndNoOfPlayersByIplTeamName(String name);
	
	

}
