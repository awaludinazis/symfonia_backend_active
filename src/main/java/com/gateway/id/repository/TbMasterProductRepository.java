package com.gateway.id.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbMasterProduct;

@Repository
public interface TbMasterProductRepository extends JpaRepository<TbMasterProduct, Long>{

}
