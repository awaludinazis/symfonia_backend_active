package com.gateway.id.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbProductFlow;

@Repository
public interface TbProductFlowRepository extends JpaRepository<TbProductFlow, Long> {

	TbProductFlow findByCustomerCodeAndSourceCodeAndDestCodeAndProductCode(String customerCode, String sourceCode,
			String destCode, String productCode);
	
	List<TbProductFlow> findByCustomerCode(String customerCode);
	
//	@Query(value = "{call symfonia.sp_data_download_product(:p_customerCode)}", nativeQuery = true)
//	public List<Map<String, Object>> generateData(@Param("p_customerCode") String p_customerCode);
	
}
