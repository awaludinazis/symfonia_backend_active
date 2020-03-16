package com.gateway.id.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gateway.id.dao.EbCustomer;
import com.gateway.id.dto.LovCustomerNameDto;
import com.gateway.id.repository.EbCustomerPagingRepository;
import com.gateway.id.repository.EbCustomerRepository;

@Service
public class EbCustomerService {

	@Autowired
	EbCustomerRepository customerRepository;

	@Autowired
	EbCustomerPagingRepository customerPagingRepository;

	public String insertData(EbCustomer customer) {
		String result = "";
		EbCustomer ebCustomerDTO = new EbCustomer();

		if (customer.getEbCustomerId() != null) {
			ebCustomerDTO = findById(customer.getEbCustomerId());
		}
		if (customer.getBillCode() != null) {
			if (customer != null && customer.getState() != null) {
				if (customer.getState().equalsIgnoreCase("create") && ebCustomerDTO.getEbCustomerId() == null
						&& ebCustomerDTO.getCustomerCode() == null) {
					
					customer.setLastBillTm(new Date());
					customer.setModifyTm(new Date());
					customer.setIsActive(0);
					customer.setCustomerCodeParent(customer.getBillCode());

					customerRepository.save(customer);

				} else {
					ebCustomerDTO.setBillCode(customer.getBillCode());
					ebCustomerDTO.setBillTitle(customer.getBillTitle());
					ebCustomerDTO.setCustomerBusiness(customer.getCustomerBusiness());
					ebCustomerDTO.setCustomerCode(customer.getCustomerCode());
					ebCustomerDTO.setCustomerCoprAdd(customer.getCustomerCoprAdd());
					ebCustomerDTO.setCustomerCoprName(customer.getCustomerCoprName());
					ebCustomerDTO.setCustomerFullname(customer.getCustomerFullname());
					ebCustomerDTO.setCustomerShortname(customer.getCustomerShortname());
					ebCustomerDTO.setEndTime(customer.getEndTime());
					ebCustomerDTO.setLastBillTm(customer.getLastBillTm());
					ebCustomerDTO.setModifyTm(new Date());
					ebCustomerDTO.setNextBillTm(customer.getNextBillTm());
					ebCustomerDTO.setPayCycle(customer.getPayCycle());
					ebCustomerDTO.setPercentage(customer.getPercentage());
					ebCustomerDTO.setPrice(customer.getPrice());
					ebCustomerDTO.setReconciliationAdd(customer.getReconciliationAdd());
					ebCustomerDTO.setReconciliationEmail(customer.getReconciliationEmail());
					ebCustomerDTO.setReconciliationHp(customer.getReconciliationHp());
					ebCustomerDTO.setReconciliationName(customer.getReconciliationName());
					ebCustomerDTO.setReconciliationTel(customer.getReconciliationTel());
					ebCustomerDTO.setStartTime(customer.getStartTime());
					ebCustomerDTO.setTax(customer.getTax());
					ebCustomerDTO.setTipe(customer.getTipe());
					ebCustomerDTO.setVat(customer.getVat());

					customerRepository.save(ebCustomerDTO);

				}

			} else {
				return result = "DATA KOSONG !";
			}
		} else {
			return result = "BILL CODE TIDAK BOLEH KOSONG !";
		}

		return result = "SUCCESS UPDATE DATA!";
	}

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

	public EbCustomer findByCustomerCode(String customerCode) {

		EbCustomer customer = new EbCustomer();

		if (customerCode != null) {
			customer = customerRepository.findByCustomerCode(customerCode);

		}

		return customer;
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

	public List<EbCustomer> findAll() {
		List<EbCustomer> list = new ArrayList<>();

		list = customerRepository.findAll();

		return list;
	}

	public Page<EbCustomer> pagingSearchData(int start, int length, String sort, String column, String customerCode,
			String customerFullname, String customerBusiness, Integer payCycle, Integer isActive) {
		Sort.Direction direction = Sort.Direction.ASC;

		if (sort.equalsIgnoreCase("desc")) {
			direction = Sort.Direction.DESC;
		}

		Pageable pageable = PageRequest.of(start, length, direction, column);

		Page<EbCustomer> page = customerPagingRepository.searchParams(pageable, customerCode, customerFullname,
				customerBusiness, payCycle, isActive);

		page.getContent().forEach((customerStaticData) -> {
			String startTime = "";
			String endTime = "";
			String nextBilling = "";

			if (customerStaticData.getStartTime() != null) {
				startTime = convertDate(customerStaticData.getStartTime());
			}
			if (customerStaticData.getEndTime() != null) {
				endTime = convertDate(customerStaticData.getEndTime());
			}
			if (customerStaticData.getNextBillTm() != null) {
				nextBilling = convertDate(customerStaticData.getNextBillTm());
			}

			customerStaticData.setStartTimeString(startTime);
			customerStaticData.setEndTimeString(endTime);
			customerStaticData.setNextBillTimeString(nextBilling);

		});

		return page;
	}

	private String convertDate(Date date) {
		String result = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		String strDate = dateFormat.format(date);
		result = strDate;

		return result;
	}

	public EbCustomer findById(Long id) {

		EbCustomer customerDto = new EbCustomer();
		Optional<EbCustomer> customerID;

		if (id != null) {
			customerID = customerRepository.findById(id);

			if (customerID != null && !customerID.toString().equalsIgnoreCase("Optional.empty")) {
				customerDto = customerID.get();
			}
			return customerDto;
		} else {
			return customerDto;
		}

	}

}
