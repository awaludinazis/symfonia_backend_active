package com.gateway.id.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gateway.id.dao.TbProductFlowHeader;
import com.gateway.id.repository.TbProductFlowHeaderPagingRepository;
import com.gateway.id.repository.TbProductFlowHeaderRepository;

@Service
public class TbProductFlowHeaderService {

	@Autowired
	TbProductFlowHeaderPagingRepository flowHeaderPagingRepository;

	@Autowired
	TbProductFlowHeaderRepository flowHeaderRepository;

	public Page<TbProductFlowHeader> pagingData(int start, int length, String sort, String column) {
		Sort.Direction direction = Sort.Direction.ASC;

		if (sort.equalsIgnoreCase("desc")) {
			direction = Sort.Direction.DESC;
		}

		Pageable pageable = PageRequest.of(start, length, direction, column);

		Page<TbProductFlowHeader> page = flowHeaderPagingRepository.findAll(pageable);

		return page;
	}

	public Page<TbProductFlowHeader> pagingSearchData(int start, int length, String sort, String column,
			String customerCode, String customerName, Integer status) {
		Sort.Direction direction = Sort.Direction.ASC;

		if (sort.equalsIgnoreCase("desc")) {
			direction = Sort.Direction.DESC;
		}

		Pageable pageable = PageRequest.of(start, length, direction, column);

		Page<TbProductFlowHeader> page = flowHeaderPagingRepository
				.findTbProductFlowHeaderByCustomerCodeAndCustomerNameAndStatus(pageable, customerCode, customerName,
						status);

		return page;
	}

	public List<TbProductFlowHeader> pagingSearchingData(int start, int length, String sort, String column,
			String customerCode, String customerName, Integer status) {

		List<TbProductFlowHeader> list = flowHeaderRepository.search(customerCode, customerName, status);

		return list;
	}

	public String insertHeaderBasicPrice(TbProductFlowHeader paramHeader) {
		String result = "";
		TbProductFlowHeader productFlowHeader = new TbProductFlowHeader();

		try {
			if (paramHeader.getCustomerCode() != null) {
				productFlowHeader = flowHeaderRepository.findByCustomerCode(paramHeader.getCustomerCode());
			} else {
				return result = "Data tidak boleh kosong!";
			}

			if (productFlowHeader == null || !productFlowHeader.getCustomerCode().equalsIgnoreCase(paramHeader.getCustomerCode())) {
				TbProductFlowHeader header = new TbProductFlowHeader();
				header.setCreatedBy("admin");
				header.setCreatedTm(new Date());
				header.setCustomerCode(paramHeader.getCustomerCode());
				header.setCustomerName(paramHeader.getCustomerName());
				header.setModifiedBy("admin");
				header.setModifiedTm(new Date());
				header.setStatus(0);

				flowHeaderRepository.save(header);

				return result = "Success menambahkan data";

			} else {
				return result = "Maaf tidak dapat mendaftarkan customer ini karena data ini sudah tersedia";
			}
		} catch (Exception e) {
			result = e.getMessage();

		}

		return result;
	}

}
