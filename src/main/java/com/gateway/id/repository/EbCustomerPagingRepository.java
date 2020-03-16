package com.gateway.id.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.EbCustomer;

@Repository
public interface EbCustomerPagingRepository extends PagingAndSortingRepository<EbCustomer, Long> {

	@Query("SELECT c FROM EbCustomer c WHERE (:customerCode is null or c.customerCode like %:customerCode%) "
			+ "and (:customerFullname is null or c.customerFullname like %:customerFullname%) "
			+ "and (:customerBusiness is null or c.customerBusiness like %:customerBusiness%) "
			+ "and (:payCycle is null or c.payCycle = :payCycle) "
			+ "and (:isActive is null or c.isActive = :isActive)")
	Page<EbCustomer> searchParams(Pageable pageable, @Param("customerCode") String customerCode,
			@Param("customerFullname") String customerFullname, @Param("customerBusiness") String customerBusiness,
			@Param("payCycle") Integer payCycle, @Param("isActive") Integer isActive);

	@Query("SELECT c FROM EbCustomer c WHERE (:customerCode is null or c.customerCode like %:customerCode%) "
			+ " and (:customerBusiness is null or c.customerBusiness like %:customerBusiness%) ")
	Page<EbCustomer> search(Pageable pageable, @Param("customerCode") String customerCode,
			@Param("customerBusiness") String customerBusiness);

}
