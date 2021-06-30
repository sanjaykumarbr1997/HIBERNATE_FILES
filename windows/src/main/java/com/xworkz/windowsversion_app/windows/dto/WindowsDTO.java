package com.xworkz.windowsversion_app.windows.dto;

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
	@NamedQuery(name = "getwindowsNewFeaturesByWindowsName", query = "select dto.newFeatures from WindowsDTO dto where dto.name=:nnn"),
	@NamedQuery(name = "getDetailsByWindowsName", query = "select dto from WindowsDTO dto where dto.name=:nan"),
	@NamedQuery(name = "getwindowsReleaseYearAndNewFeaturesByWindowsName", query = "select dto.releaseYear,dto.newFeatures from WindowsDTO dto where dto.name=:nm"),
	@NamedQuery(name = "getwindowsNameAndwindowsNewFeaturesBywindowsReleaseYear", query = "select dto.name,dto.newFeatures from WindowsDTO dto where dto.releaseYear=:ry "),
	@NamedQuery(name = "updateReleaseYearByNameH", query = "update WindowsDTO dto set dto.releaseYear = :ryy where dto.name=:nn"),
	@NamedQuery(name = "updateFearureByNameH", query = "update WindowsDTO dto set dto.newFeatures = :nf where dto.name=:nn"),
	@NamedQuery(name = "deleteByNameH", query = "delete from WindowsDTO dto where dto.name=:nn "),
	@NamedQuery(name = "deleteByYearH", query = "delete from WindowsDTO dto where dto.releaseYear=:ry "),
	@NamedQuery(name = "deleteByFeatureH", query = "delete from WindowsDTO dto where dto.newFeatures=:fy")
})
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
	private String newFeatures;
	@Override
	public String toString() {
		return "WindowsDTO [id=" + id + ", name=" + name + ", releaseYear=" + releaseYear + ", newFeatures="
				+ newFeatures + "]";
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
	public String getnewFeatures() {
		return newFeatures;
	}
	public void setnewFeatures(String newFeatures) {
		this.newFeatures = newFeatures;
	}
	
	
}