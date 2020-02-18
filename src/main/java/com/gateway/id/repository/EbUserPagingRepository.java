package com.gateway.id.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.EbUser;

@Repository
public interface EbUserPagingRepository extends PagingAndSortingRepository<EbUser, Long>{

	Page<EbUser> findAll(Pageable pageable);
	
}
