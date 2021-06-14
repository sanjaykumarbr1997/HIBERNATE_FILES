package com.xworkz.whatsapp.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
//Hybernate uses DTO to perform CRUD

import com.xworkz.whatsapp.constants.StatusPrivacy;


@SuppressWarnings("serial")
@Entity
@Table(name = "whats_app_table")


public class WhatsAppDTO implements Serializable {
	
	
	@Id
	private int whatsApp_id;
	private String whatsApp_status;
	@Enumerated(EnumType.STRING)
	private StatusPrivacy whatsApp_privacy;
	private String chat;
	private Long contactNo;
	
	public WhatsAppDTO() {
		 System.out.println(this.getClass().getSimpleName()+"created");
	}

	@Override
	public String toString() {
		return "WhatsAppDTO [whatsApp_id=" + whatsApp_id + ", whatsApp_status=" + whatsApp_status
				+ ", whatsApp_privacy=" + whatsApp_privacy + ", chat=" + chat + ", contactNo=" + contactNo + "]";
	}

	public int getWhatsApp_id() {
		return whatsApp_id;
	}

	public void setWhatsApp_id(int whatsApp_id) {
		this.whatsApp_id = whatsApp_id;
	}

	public String getWhatsApp_status() {
		return whatsApp_status;
	}

	public void setWhatsApp_status(String whatsApp_status) {
		this.whatsApp_status = whatsApp_status;
	}

	public StatusPrivacy getWhatsApp_privacy() {
		return whatsApp_privacy;
	}

	public void setWhatsApp_privacy(StatusPrivacy whatsApp_privacy) {
		this.whatsApp_privacy = whatsApp_privacy;
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

}
