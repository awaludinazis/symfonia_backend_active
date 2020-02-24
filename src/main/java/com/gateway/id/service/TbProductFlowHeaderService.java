package com.gateway.id.service;

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

}
