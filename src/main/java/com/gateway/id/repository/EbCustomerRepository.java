package com.gateway.id.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.EbCustomer;

@Repository
public interface EbCustomerRepository extends JpaRepository<EbCustomer, Long> {

	EbCustomer findByCustomerCode(String customerCode);

}
