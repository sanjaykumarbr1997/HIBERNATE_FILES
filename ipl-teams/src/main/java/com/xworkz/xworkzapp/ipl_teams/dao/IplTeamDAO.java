package com.xworkz.xworkzapp.ipl_teams.dao;

import com.xworkz.xworkzapp.ipl_teams.dto.IplTeamDTO;

public interface IplTeamDAO {

	 public void save(IplTeamDTO iplDTO);

	public IplTeamDTO getDetailsByName(String name,int id);

	public void deleteDetails(int idd);

	public void updateDetails(String name, int id, int players);
	
	public void a();

}
