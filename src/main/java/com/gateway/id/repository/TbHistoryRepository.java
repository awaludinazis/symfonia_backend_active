package com.gateway.id.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbHistory;

@Repository
public interface TbHistoryRepository extends JpaRepository<TbHistory, Long> {

}
