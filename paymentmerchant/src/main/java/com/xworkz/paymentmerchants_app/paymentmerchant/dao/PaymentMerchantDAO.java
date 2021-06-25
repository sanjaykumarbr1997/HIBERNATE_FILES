package com.xworkz.paymentmerchants_app.paymentmerchant.dao;

import java.util.List;

import com.xworkz.paymentmerchants_app.paymentmerchant.dto.PaymentMerchantDTO;

public interface PaymentMerchantDAO {

	public void save(PaymentMerchantDTO pDTO);

	public PaymentMerchantDTO fetchDetailsByName(String name);

	public Object[] fetchCEOAndEmailDetailsByName(String name);

	public List<Object[]> fetchAllCEOAndEmailDetailsByLocation(String hqLocation);

	public int updateCEOByName(String name,String ceo);

	public int deleteDetailsByHq(String hq);


}
