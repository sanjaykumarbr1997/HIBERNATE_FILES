package com.xworkz.paymentmerchants_app.paymentmerchant.dto;

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
@Table(name="payment_merchant_table")

@NamedQueries(
		{
		@NamedQuery(name = "fetchDetailsByName", query = "select dto from PaymentMerchantDTO dto where dto.name=:nm"),
		@NamedQuery(name = "fetchCEOAndEmailDetailsByName", query = "select dto.ceo,dto.email from PaymentMerchantDTO dto where dto.name=:nm"),
		@NamedQuery(name = "fetchAllCEOAndEmailDetailsByLocation", query = "select dto.ceo,dto.email from PaymentMerchantDTO dto where dto.hq=:lc"),
		@NamedQuery(name = "updateCEOByName", query = "update PaymentMerchantDTO dto set dto.ceo=:ce where dto.name=:nam "),
		@NamedQuery(name = "deleteDetailsByHq", query = "delete from PaymentMerchantDTO dto  where dto.hq=:headq ")	
			
			
		}) 

public class PaymentMerchantDTO implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.AUTO) 
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="CEO")
	private String ceo;
	@Column(name="hq")
	private String hq;
	@Column(name="email")
	private String email;
	@Override
	public String toString() {
		return "PaymentMerchantDTO [id=" + id + ", name=" + name + ", ceo=" + ceo + ", hq=" + hq + ", email=" + email
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
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getHq() {
		return hq;
	}
	public void setHq(String hq) {
		this.hq = hq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
