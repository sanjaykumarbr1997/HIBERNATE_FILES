package com.xworkz.chocolate_app.chocolate.dto;

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
	@NamedQuery(name = "getAllDetails", query = "select csdto from ChocoloateDTO csdto"),
	@NamedQuery(name = "getChocolateCompanyByChocolateName", query = "Select dto.company from ChocoloateDTO dto where dto.name = :nm"),
	@NamedQuery(name = "getDetailsByChocolatename", query = "Select dto from ChocoloateDTO dto where dto.name = :nm"),
	@NamedQuery(name = "getChocolatePriceAndChocolateColorByChocolateName", query = "Select dto.price,dto.color from ChocoloateDTO dto where dto.name = :nm"),
	@NamedQuery(name = "getchocolatePriceAndchocolateColorByChocolateName", query = "select dto.price,dto.color from ChocoloateDTO dto where dto.company = :nm"),
	@NamedQuery(name = "updatePriceByNameH", query = "update ChocoloateDTO dto set dto.price=:pr  where dto.name = :nm"),
	@NamedQuery(name = "updateColorByNameH", query = "update ChocoloateDTO dto set dto.color=:clr where dto.name = :nm"),
	@NamedQuery(name = "updateCompanyNameByNameH", query = "update ChocoloateDTO dto set dto.company=:cmp where dto.name = :nm"),
	@NamedQuery(name = "deleteByNameH", query = "delete from ChocoloateDTO dto where dto.name = :nm"),
	@NamedQuery(name = "deleteByPriceH", query = "delete from ChocoloateDTO dto where dto.price = :pr"),
	@NamedQuery(name = "deleteByColorH", query = "delete from ChocoloateDTO dto where dto.color = :clr"),
	
	
})
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
