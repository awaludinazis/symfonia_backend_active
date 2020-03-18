package com.gateway.id.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.id.dao.TbBilling;
import com.gateway.id.repository.TbBillingRepository;

@Service
public class TbBillingService {

	@Autowired
	TbBillingRepository billingRepository;

	public String insertData(TbBilling billing) {
		TbBilling tbBilling = new TbBilling();
		String result = "";
		
		
		
		return result;
	}
	
	
}
