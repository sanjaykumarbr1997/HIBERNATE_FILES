package com.xworkz.perfume.perfume.dto;

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
	
	@NamedQuery(name = "getPerfumeFragnanceByPerfumeName", query = "select dto.perfumeFragnance from PerfumeDTO dto where dto.perfumeName=:name"),
	@NamedQuery(name = "getDetailsByperfumeName", query = "select dto from PerfumeDTO dto where dto.perfumeName=:naa"),
	@NamedQuery(name = "getperfumeColorAndPricesByPerfumeName", query = "select dto.perfumeColor,dto.perfumePrice from PerfumeDTO dto where dto.perfumeName=:naa"),
	@NamedQuery(name = "getperfumePriceAndperfumeColorByperfumeFragnance", query = "select dto.perfumeColor,dto.perfumePrice from PerfumeDTO dto where dto.perfumeFragnance=:frag"),
	@NamedQuery(name = "updatePriceByNameH", query = "update PerfumeDTO dto set dto.perfumePrice =:pri where dto.perfumeName=:na"),
	@NamedQuery(name = "updateColorByNameH", query = "update PerfumeDTO dto set dto.perfumeColor =:cl where dto.perfumeName=:na"),
	@NamedQuery(name = "updateperfumeFragnanceByNameH", query = "update PerfumeDTO dto set dto.perfumeFragnance =:frg where dto.perfumeName=:nam"),
	@NamedQuery(name = "deleteByNameH", query = "delete from PerfumeDTO dto where dto.perfumeName=:na"),
	@NamedQuery(name = "deleteByPriceH", query = "delete from PerfumeDTO dto where dto.perfumePrice=:pri"),
	@NamedQuery(name = "deleteByColorH", query = "delete from PerfumeDTO dto where dto.perfumeColor= :clr")
	
})
@Table(name = "perfume_table")
public class PerfumeDTO implements Serializable {
	
	
	@Id
	@GenericGenerator(name="ref" , strategy="uuid")
	@GeneratedValue(generator ="ref")
	//@GeneratedValue(strategy= GenerationType.AUTO) 
	@Column(name ="perfume_id")
	private String perfumeId;
	@Column(name ="perfume_name")
	private String perfumeName;
	@Column(name ="perfume_color")
	private String perfumeColor;
	@Column(name ="perfume_price")
	private double perfumePrice;
	@Column(name ="perfume_fragnance")
	private String perfumeFragnance;
	
	
	public PerfumeDTO() {
		System.out.println(this.getClass().getSimpleName()+"created");
		
	}

	@Override
	public String toString() {
		return "PerfumeDTO [perfumeId=" + perfumeId + ", perfumeName=" + perfumeName + ", perfumeColor=" + perfumeColor
				+ ", perfumePrice=" + perfumePrice + ", perfumeFragnance=" + perfumeFragnance + "]";
	}

	public String getPerfumeId() {
		return perfumeId;
	}

	public void setPerfumeId(String perfumeId) {
		this.perfumeId = perfumeId;
	}

	public String getPerfumeName() {
		return perfumeName;
	}

	public void setPerfumeName(String perfumeName) {
		this.perfumeName = perfumeName;
	}

	public String getPerfumeColor() {
		return perfumeColor;
	}

	public void setPerfumeColor(String perfumeColor) {
		this.perfumeColor = perfumeColor;
	}

	public double getPerfumePrice() {
		return perfumePrice;
	}

	public void setPerfumePrice(double perfumePrice) {
		this.perfumePrice = perfumePrice;
	}

	public String getPerfumeFragnance() {
		return perfumeFragnance;
	}

	public void setPerfumeFragnance(String perfumeFragnance) {
		this.perfumeFragnance = perfumeFragnance;
	}
	

	
	
	
	

}
