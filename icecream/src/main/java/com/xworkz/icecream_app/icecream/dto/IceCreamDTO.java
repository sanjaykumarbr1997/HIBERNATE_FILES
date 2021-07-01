package com.xworkz.icecream_app.icecream.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import static com.xworkz.icecream_app.icecream.resources.StringPrefixSequenceIdGenerator.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.xworkz.icecream_app.icecream.resources.StringPrefixSequenceIdGenerator;

@Entity
@Table(name="ice_cream_table")
public class IceCreamDTO implements Serializable {
	
	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//com.xworkz.icecream_app.icecream.resources
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="ice_seq")
	@GenericGenerator(name = "ice_seq",
	strategy = "com.xworkz.icecream_app.icecream.resources.StringPrefixSequenceIdGenerator",
	parameters = {
			@Parameter(name = StringPrefixSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = StringPrefixSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ICE_"),
			@Parameter(name = StringPrefixSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
			
			
	
	})
	private String id;
	@Column(name="ice_cream_brand")
	private String brand;
	@Column(name="ice_cream_flavour")
	private String flavour;
	@Column(name="ice_cream_color")
	private String color;
	@Override
	public String toString() {
		return "IceCreamDTO [id=" + id + ", brand=" + brand + ", flavour=" + flavour + ", color=" + color + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getFlavour() {
		return flavour;
	}
	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
