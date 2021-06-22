package com.xworkz.suitcase_app.suitcase.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
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
