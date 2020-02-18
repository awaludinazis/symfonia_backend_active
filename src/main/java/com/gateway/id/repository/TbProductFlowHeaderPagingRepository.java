package com.gateway.id.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbProductFlowHeader;

@Repository
public interface TbProductFlowHeaderPagingRepository extends PagingAndSortingRepository<TbProductFlowHeader, Long> {

	Page<TbProductFlowHeader> findAll(Pageable pageable);

}
