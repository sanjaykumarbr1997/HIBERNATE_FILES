package com.xworkz.xworkzapp.ipl_teams.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries({
	@NamedQuery(name = "getIplTeamLocationByIplTeamName", query = "select dto.location from IplTeamDTO dto where dto.teamName =:nme "),
	@NamedQuery(name = "getDetailsByIplTeamName", query = "select dto from IplTeamDTO dto where dto.teamName =:nme"),
	@NamedQuery(name = "getIplTeamLocationAndNoOfPlayersByIplTeamName", query = "select dto.location,dto.noOfPlayers from IplTeamDTO dto where dto.teamName =:nme"),
	@NamedQuery(name = "getiplTeamNameAndNoofPlayersByiplTeamLocation", query = "select dto.teamName,dto.noOfPlayers from IplTeamDTO dto where dto.location= :loc "),
	@NamedQuery(name = "updateNoOfPlayersByNameH", query = "update IplTeamDTO dto set dto.noOfPlayers =:play where dto.teamName=:na "),
	@NamedQuery(name = "deleteByNameH", query = "delete from IplTeamDTO dto where dto.teamName = :tn ")
	
})
@Table(name ="ipl_team_table")
public class IplTeamDTO implements Serializable{
	
	@Id
	@Column(name ="team_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int teamId;
	
	@Column(name ="team_name")
	private String teamName;
	
	@Column(name ="no_of_players")
	private int noOfPlayers;
	
	@Column(name ="team_location")
	private String location;
	
	public IplTeamDTO() {
		System.out.println(this.getClass().getSimpleName()+"Created");
	}

	@Override
	public String toString() {
		return "IplTeamDTO [teamId=" + teamId + ", teamName=" + teamName + ", noOfPlayers=" + noOfPlayers
				+ ", location=" + location + "]";
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
