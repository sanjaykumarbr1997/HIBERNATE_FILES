package com.xworkz.softdrinks_app.softdrink.dto;

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
	@NamedQuery(name = "getSoftdrinkColorBySoftdrinkName", query = "select dto.color from SoftDrinksDTO dto where dto.name = :nm"),
	@NamedQuery(name = "getDetailsBySoftdrinkName", query = "select dto from SoftDrinksDTO dto where dto.name = :name"),
	@NamedQuery(name = "getSoftdrinkManufactureYearAndPricesBySoftdrinkName", query = "select dto.mfgYear,dto.price from SoftDrinksDTO dto where dto.name = :na"),
	@NamedQuery(name = "getsoftdrinkPriceAndsoftdrinkColorBysoftdrinkmfgyear", query = "select dto.color,dto.price from SoftDrinksDTO dto where dto.mfgYear=:mf "),
	@NamedQuery(name = "updatePriceByNameH", query = "update SoftDrinksDTO dto set dto.price =:pri where dto.name=:na"),
	@NamedQuery(name = "updateColorByNameH", query = "update SoftDrinksDTO dto set dto.color =:clr where dto.name=:naa"),
	@NamedQuery(name = "updateColorByMfgYear", query = "update SoftDrinksDTO dto set dto.mfgYear =:mfy where dto.name=:nam"),
	@NamedQuery(name = "deleteColorByNameH", query = "delete from SoftDrinksDTO dto where dto.name=:nam"),
	@NamedQuery(name = "deleteColorByPriceH", query = "delete from SoftDrinksDTO dto where dto.price=:pri")
})
@Table(name="soft_drinks_table")
public class SoftDrinksDTO implements Serializable {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="soft_drink_name")
	private String name;
	
	@Column(name="soft_drink_price")
	private double price;
	
	@Column(name="soft_drink_color")
	private String color;
	
	@Column(name="soft_drik_mfg_year")
	private int mfgYear;

	@Override
	public String toString() {
		return "SoftDrinksDTO [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + ", mfgYear="
				+ mfgYear + "]";
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

	public int getMfgYear() {
		return mfgYear;
	}

	public void setMfgYear(int mfgYear) {
		this.mfgYear = mfgYear;
	}
	
	
	


	
}
