package com.xworkz.xworkzapp.ipl_teams.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="Ipl_team_table")
public class IplTeamDTO implements Serializable{
	
	@Id
	@Column(name ="team_id")
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
