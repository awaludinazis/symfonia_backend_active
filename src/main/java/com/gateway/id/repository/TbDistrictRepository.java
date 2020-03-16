package com.gateway.id.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateway.id.dao.TbDistrict;

@Repository
public interface TbDistrictRepository extends JpaRepository<TbDistrict, Long> {

	List<TbDistrict> findByDistType(String distType);

	TbDistrict findByDistCode(String distCode);

	TbDistrict findByDistTypeAndDistCode(String flowType, String distCode);

}
