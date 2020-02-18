package com.gateway.id.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.id.dao.EbCustomer;
import com.gateway.id.dto.LovCustomerNameDto;
import com.gateway.id.repository.EbCustomerRepository;

@Service
public class EbCustomerService {

	@Autowired
	EbCustomerRepository customerRepository;

	public String getCustomerName(String customerCode) {

		String result = "";
		EbCustomer customer = new EbCustomer();

		if (customerCode != null) {
			customer = customerRepository.findByCustomerCode(customerCode);

			if (customer != null && customer.getCustomerCoprName() != null) {
				result = customer.getCustomerCoprName();
			}
		}

		return result;
	}

	public List<LovCustomerNameDto> getLovCustomerName() {
		List<LovCustomerNameDto> dtos = new ArrayList<>();
		List<EbCustomer> list = new ArrayList<>();

		list = customerRepository.findAll();
		if (list != null && list.size() > 0) {

			for (EbCustomer customer : list) {
				LovCustomerNameDto nameDto = new LovCustomerNameDto();
				nameDto.setCustomerCode(customer.getCustomerCode());
				nameDto.setCustomerName(customer.getCustomerShortname());

				dtos.add(nameDto);
			}

		}

		return dtos;
	}

}
