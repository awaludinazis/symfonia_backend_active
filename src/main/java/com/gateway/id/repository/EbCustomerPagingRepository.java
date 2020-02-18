package com.gateway.id.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.EbCustomer;

@Repository
public interface EbCustomerPagingRepository extends PagingAndSortingRepository<EbCustomer, Long> {

}
