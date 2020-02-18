package com.gateway.id.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbProductFlow;

@Repository
public interface TbProductFlowRepository extends JpaRepository<TbProductFlow, Long> {

	TbProductFlow findByCustomerCodeAndSourceCodeAndDestCodeAndProductCode(String customerCode, String sourceCode,
			String destCode, String productCode);
	
	List<TbProductFlow> findByCustomerCode(String customerCode);
	
}
