package com.xworkz.sweets_app.sweets.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@NamedQueries({
	@NamedQuery(name = "getSweetsColorBySweetName", query = "select dto.color from SweetsDTO dto where dto.name =:nam"),
	@NamedQuery(name = "getDetailsBySweetName", query = "select dto from SweetsDTO dto where dto.name =:nm"),
	@NamedQuery(name = "getsweetShapeAndColorBySweetName", query = "select dto.shape,dto.color from SweetsDTO dto where dto.name =:name"),
	@NamedQuery(name = "getsweetPriceAndsweetColorBysweetshape", query = "select dto.name,dto.color from SweetsDTO dto where dto.shape=:sha"),
	@NamedQuery(name = "updatePriceByNameH", query = "update SweetsDTO dto set dto.price =:pri where dto.name=:nam"),
	@NamedQuery(name = "updateColorByNameH", query = "update SweetsDTO dto set dto.color =:cl where dto.name=:nm "),
	@NamedQuery(name = "updatesweetshapeByNameH", query = "update SweetsDTO dto set dto.shape =:sh where dto.name=:na"),
	@NamedQuery(name = "deleteByNameH", query = "delete from SweetsDTO dto where dto.name=:nam "),
	@NamedQuery(name = "deleteByPriceH", query = "delete from SweetsDTO dto where dto.price=:pri"),
	@NamedQuery(name = "deleteByColorH", query = "delete from SweetsDTO dto where dto.color=:clr")
})
@Table(name = "sweet_table")
public class SweetsDTO implements Serializable {
	
	@Id
	@Column(name="sweet_id")
	
	@GenericGenerator(name="ref" , strategy="increment")
	@GeneratedValue(generator ="ref")
	//@GeneratedValue(strategy= GenerationType.AUTO) //whenever auto is used there is some changes in hib.cfg.file
	private int sweet_id;
	@Column(name="sweet_name")
	private String name;
	@Column(name="sweet_color")
	private String color;
	@Column(name="sweet_price")
	private double price;
	@Column(name="sweet_shape")
	private String shape;
	
	public SweetsDTO() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}

	

	@Override
	public String toString() {
		return "SweetsDTO [sweet_id=" + sweet_id + ", name=" + name + ", color=" + color + ", price=" + price
				+ ", shape=" + shape + "]";
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

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public int getSweet_id() {
		return sweet_id;
	}

	public void setSweet_id(int sweet_id) {
		this.sweet_id = sweet_id;
	}
	

}
