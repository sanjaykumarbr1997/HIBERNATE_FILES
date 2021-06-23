package com.xworkz.windowsversion_app.windows.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="windows_version_table")
public class  WindowsDTO implements Serializable{
	
	@Id
	@Column(name="wi")
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	@Column(name="windows_name")
	private String name;
	@Column(name ="windows_year")
	private int releaseYear;
	@Column(name="windows_new_features")
	private String new_features;
	@Override
	public String toString() {
		return "WindowsDTO [id=" + id + ", name=" + name + ", releaseYear=" + releaseYear + ", new_features="
				+ new_features + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getNew_features() {
		return new_features;
	}
	public void setNew_features(String new_features) {
		this.new_features = new_features;
	}
	
	
}