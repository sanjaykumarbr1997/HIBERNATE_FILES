package com.xworkz.xworkzapp.ipl_teams.service;

import java.util.List;

import com.xworkz.xworkzapp.ipl_teams.dto.IplTeamDTO;

public interface IplTeamService {

	public void validateAndSave(IplTeamDTO iplDTO);

	public IplTeamDTO validateAndGetDetailsByName(String name,int id);

	public void validateAndDeleteById(int idd);

	public void validateAndUpdateRangeByName(String name,int id, int players);

	public List<IplTeamDTO> validateAndGetAllDetails();

	public String validateAndGetIplTeamLocationByIplTeamName(String name);

	public IplTeamDTO validateAndGetDetailsByIplTeamName(String name);

	public Object[] validateAndGetIplTeamLocationAndNoOfPlayersByIplTeamName(String name);

	public List<Object[]> validateAndGetiplTeamNameAndNoofPlayersByiplTeamLocation(String location);

	public int validateAndUpdateNoOfPlayersByNameH(String name, int noOfPlayers);

	public int validateAndUpdateTeamNameByLocationH(String location, String name);

	public int validateAndDeleteByNameH(String name);

	public int validateAndDeleteByLocationH(String location);

	public int validateAndDeleteBySizeH(int size);


}
