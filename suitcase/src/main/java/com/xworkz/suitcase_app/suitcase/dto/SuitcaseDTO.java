package com.xworkz.suitcase_app.suitcase.dto;

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
	@NamedQuery(name = "getSuitcaseColorBySuitcaseName", query = "select dto.color from SuitcaseDTO dto where dto.name = :nm"),
	@NamedQuery(name = "getDetailsBySuitcaseName", query = "select dto from SuitcaseDTO dto where dto.name = :nam"),
	@NamedQuery(name = "getSuitcaseSizeAndColorBysuitcaseName", query = "select dto.size,dto.color from SuitcaseDTO dto where dto.name = :name'"),
	@NamedQuery(name = "getsuitcaseNameAndsuitcaseColorBysuitcaseSize", query = "select dto.name,dto.color from SuitcaseDTO dto where dto.size=:sz"),
	@NamedQuery(name = "updateSizeByNameH", query = "update SuitcaseDTO dto set dto.size =:sz where dto.name=:nme"),
	@NamedQuery(name = "updateColorByNameH", query = "update SuitcaseDTO dto set dto.color =:clr where dto.name=:nm"),
	@NamedQuery(name = "deleteByNameH", query = "delete from SuitcaseDTO dto where dto.name=:nm"),
	@NamedQuery(name = "deleteByColorH", query = "delete from SuitcaseDTO dto where dto.color=:clr"),
	@NamedQuery(name = "deleteBySizeH", query = "delete from SuitcaseDTO dto where dto.size=:siz")
	
})
@Table(name ="suitcase_table")
public class SuitcaseDTO implements Serializable{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="suitcase_name")
	private String name;
	@Column(name ="suitcase_color")
	private String color;
	@Column(name ="suitcase_size")
	private String size;
	@Override
	public String toString() {
		return "SuitcaseDTO [id=" + id + ", name=" + name + ", color=" + color + ", size=" + size + "]";
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
	
	
	

}
