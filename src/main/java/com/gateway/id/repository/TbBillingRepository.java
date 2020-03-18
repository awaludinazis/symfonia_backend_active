package com.gateway.id.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbBilling;

@Repository
public interface TbBillingRepository extends JpaRepository<TbBilling, Long> {

}
