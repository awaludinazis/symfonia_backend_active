package com.gateway.id.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gateway.id.dao.TbProductFlowHeader;
import com.gateway.id.repository.TbProductFlowHeaderPagingRepository;

@Service
public class TbProductFlowHeaderService {

	@Autowired
	TbProductFlowHeaderPagingRepository flowHeaderPagingRepository;

	public Page<TbProductFlowHeader> pagingData(int start, int length, String sort, String column) {
		Sort.Direction direction = Sort.Direction.ASC;

		if (sort.equalsIgnoreCase("desc")) {
			direction = Sort.Direction.DESC;
		}

		Pageable pageable = PageRequest.of(start, length, direction, column);

		Page<TbProductFlowHeader> page = flowHeaderPagingRepository.findAll(pageable);

		return page;
	}

}
