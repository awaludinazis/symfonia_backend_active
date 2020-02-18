package com.gateway.id.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.EbUser;

@Repository
public interface EbUserRepository extends JpaRepository<EbUser, Long> {

	EbUser findByUsername(String username);

}
