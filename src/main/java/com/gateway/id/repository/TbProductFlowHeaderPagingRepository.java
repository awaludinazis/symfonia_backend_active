package com.gateway.id.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbProductFlowHeader;

@Repository
public interface TbProductFlowHeaderPagingRepository extends PagingAndSortingRepository<TbProductFlowHeader, Long> {

	Page<TbProductFlowHeader> findAll(Pageable pageable);

//	Page<TbProductFlowHeader> findByCustomerCodeAndCustomerNameAndStatus(Pageable pageable, String customerCode,
//			String customerName, Integer status);

	@Query("SELECT c FROM TbProductFlowHeader c WHERE (:customerCode is null or c.customerCode like %:customerCode%) "
			+ "and (:customerName is null or c.customerName like %:customerName%) and (:status is null or c.status = :status)")
	Page<TbProductFlowHeader> findTbProductFlowHeaderByCustomerCodeAndCustomerNameAndStatus(Pageable pageable , @Param("customerCode") String customerCode,
			@Param("customerName") String customerName, @Param("status") Integer status);

}
