package com.xworkz.chocolate_app.chocolate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chocolate_table")
public class ChocoloateDTO implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="chocolate_id")
	private int id;
	@Column(name="chocolate_name")
	private String name;
	@Column(name="chocolate_color")
	private String color;
	@Column(name="chocolate_price")
	private double price;
	@Column(name="chocolate_company")
	private String company;
	@Override
	public String toString() {
		return "ChocoloateDTO [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", company="
				+ company + "]";
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	
	

}
