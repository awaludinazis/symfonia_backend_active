package com.gateway.id.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbDistrict;
import com.gateway.id.dao.TbProductFlowHeader;

@Repository
public interface TbProductFlowHeaderRepository extends JpaRepository<TbProductFlowHeader, Long> {

	@Query("SELECT c FROM TbProductFlowHeader c WHERE (:customerCode is null or c.customerCode = :customerCode) "
			+ "and (:customerName is null or c.customerName = :customerName) and (:status is null or c.status = :status)")
	List<TbProductFlowHeader> search(@Param("customerCode") String customerCode,
			@Param("customerName") String customerName, @Param("status") Integer status);
	
	TbProductFlowHeader findByCustomerCode(String distCode);

}
