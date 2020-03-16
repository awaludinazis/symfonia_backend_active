package com.gateway.id.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.id.dao.TbMasterProduct;
import com.gateway.id.dto.LovDto;
import com.gateway.id.repository.TbMasterProductRepository;

@Service
public class TbMasterProductService {

	@Autowired
	TbMasterProductRepository masterProductRepository;

	public List<LovDto> getAllProduct() {
		List<TbMasterProduct> list = new ArrayList<>();
		List<LovDto> result = new ArrayList<>();

		list = masterProductRepository.findAll();

		if (list.size() > 0) {
			for (TbMasterProduct product : list) {
				LovDto dto = new LovDto();

				dto.setLovCode(product.getProductCode());
				dto.setLovName(product.getProductName());

				result.add(dto);
			}
		}

		return result;

	}

}
