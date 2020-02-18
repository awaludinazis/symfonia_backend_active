package com.gateway.id.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.id.dao.TbDistrict;
import com.gateway.id.dto.LovDistrictDto;
import com.gateway.id.repository.TbDistrictRepository;

@Service
public class TbDistrictService {

	@Autowired
	TbDistrictRepository districtRepository;

	public List<LovDistrictDto> findByDistType(String distType) {

		List<LovDistrictDto> result = new ArrayList<>();
		List<TbDistrict> list = new ArrayList<>();

		list = districtRepository.findByDistType(distType);
		if (list != null && list.size() > 0) {
			for (TbDistrict district : list) {
				LovDistrictDto lovDistrictDto = new LovDistrictDto();
				lovDistrictDto.setDistCode(district.getDistCode());
				lovDistrictDto.setDistName(district.getDistName());

				result.add(lovDistrictDto);
			}
		}
		return result;

	}

	public String findByDistName(String distCode) {
		String result = "";

		TbDistrict dto = new TbDistrict();
		dto = districtRepository.findByDistCode(distCode);
		if (dto.getDistName() != null) {
			result = dto.getDistName();
		}

		return result;
	}

	public List<LovDistrictDto> getLovDistrictType() {

		List<LovDistrictDto> result = new ArrayList<>();

		LovDistrictDto dto1 = new LovDistrictDto();
		dto1.setDistCode("1");
		dto1.setDistName("Country");
		result.add(dto1);

		LovDistrictDto dto2 = new LovDistrictDto();
		dto2.setDistCode("2");
		dto2.setDistName("Province");
		result.add(dto2);

		LovDistrictDto dto3 = new LovDistrictDto();
		dto3.setDistCode("3");
		dto3.setDistName("City");
		result.add(dto3);

		LovDistrictDto dto4 = new LovDistrictDto();
		dto4.setDistCode("4");
		dto4.setDistName("District");
		result.add(dto4);

		LovDistrictDto dto5 = new LovDistrictDto();
		dto5.setDistCode("5");
		dto5.setDistName("Sub-District");
		result.add(dto5);

		return result;

	}
}
