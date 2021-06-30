package com.xworkz.paint_app.paint.dto;

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
	@NamedQuery(name = "getPintColorByPrice", query = "select dto.color from PaintDTO dto where dto.price = :pri"),
	@NamedQuery(name = "getDetailsByName", query = "select dto from PaintDTO dto where dto.name = :nam"),
	@NamedQuery(name = "getPaintPriceAndPaintColorByName", query = "select dto.price,dto.color from PaintDTO dto where dto.name = :na"),
	@NamedQuery(name = "getPaintPriceAndPaintColorByExpiryYear", query = "select dto.price,dto.color from PaintDTO dto where dto.year=:yer"),
	@NamedQuery(name = "updatePriceByNameH", query = "update PaintDTO dto set dto.price=:pr where dto.name =:name"),
	@NamedQuery(name = "updateColorByNameH", query = "update PaintDTO dto set dto.color='\"+ color+\"' where dto.name='\"+name+\"'"),
	@NamedQuery(name = "updateYearOfExpiryByNameH", query = "update PaintDTO dto set dto.year=\"+ year+\" where dto.name='\"+name+\"'"),
	@NamedQuery(name = "deleteByNameH", query = "delete from PaintDTO dto where dto.name =:name"),
	@NamedQuery(name = "deleteByYearH", query = "delete from PaintDTO dto where dto.year = :yr"),
	@NamedQuery(name = "deleteByColorH", query = "delete from PaintDTO dto where dto.color = :colo")
	
	
	
})
@Table(name="paint_table")
public class PaintDTO implements Serializable {
	
	@Id
	@Column(name="paint_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="paint_name")
	private String name;
	@Column(name="paint_price")
	private double price;
	@Column(name="paint_color")
	private String color;
	@Column(name="paint_year_of_expiry")
	private int year;
	@Override
	public String toString() {
		return "PaintDTO [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + ", year=" + year
				+ "]";
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	

}
