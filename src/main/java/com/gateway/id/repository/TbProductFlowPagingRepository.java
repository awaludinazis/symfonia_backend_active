package com.gateway.id.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbProductFlow;

@Repository
public interface TbProductFlowPagingRepository extends PagingAndSortingRepository<TbProductFlow, Long> {

	Page<TbProductFlow> findAll(Pageable pageable);
	
	Page<TbProductFlow> findByCustomerCode(Pageable pageable, String customerCode);
	
	@Query("SELECT pr FROM TbProductFlow pr GROUP BY customerCode")
	Page<TbProductFlow> getOrderCustomerCode(Pageable pageable);
	
}
