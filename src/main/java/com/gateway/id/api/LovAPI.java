package com.gateway.id.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.id.dto.ConvertListLovDto;
import com.gateway.id.dto.LovCustomerNameDto;
import com.gateway.id.dto.LovDistrictDto;
import com.gateway.id.dto.LovDistrictSearchableDto;
import com.gateway.id.dto.LovDto;
import com.gateway.id.service.EbCustomerService;
import com.gateway.id.service.TbDistrictService;
import com.gateway.id.service.TbMasterProductService;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
public class LovAPI {

	@Autowired
	TbDistrictService tbDistrictService;

	@Autowired
	EbCustomerService customerService;

	@Autowired
	TbMasterProductService masterProductService;

	private static final Logger LOG = LoggerFactory.getLogger(LovAPI.class);

	@RequestMapping(path = "/lov/ping", method = RequestMethod.GET)
	public ResponseEntity<String> echo() {
		return new ResponseEntity<String>("SUCCESS!!!", HttpStatus.OK);
	}

	@RequestMapping(path = "/lov/getLovDistrict", method = RequestMethod.POST)
	public ResponseEntity<String> getAllData(@RequestParam("distType") String distType) {

		List<LovDistrictDto> lovs = new ArrayList<>();
		LovDistrictSearchableDto searchableDto = new LovDistrictSearchableDto();
		Gson gson = new Gson();
		String result = "";
		String constructDistType = "";
		if (distType != null) {
			constructDistType = distType.substring(0, 1);

			lovs = tbDistrictService.findByDistType(constructDistType);
		}

		if (lovs != null && lovs.size() > 0) {
			searchableDto.setName("District Searchable");
			searchableDto.setListDto(lovs);
			result = gson.toJson(searchableDto);

			return new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Gagal Memuat Data!", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/lov/getLovCustomer", method = RequestMethod.POST)
	public ResponseEntity<String> getLovCustomer() {

		List<LovCustomerNameDto> lovs = new ArrayList<>();
		Gson gson = new Gson();
		String result = "";

		lovs = customerService.getLovCustomerName();

		if (lovs != null && lovs.size() > 0) {
			result = gson.toJson(lovs);

			return new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Gagal Memuat Data!", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/lov/getLovDistrictType", method = RequestMethod.POST)
	public ResponseEntity<String> getLovDistrictType() {

		List<LovDistrictDto> lovs = new ArrayList<>();
		Gson gson = new Gson();
		String result = "";

		lovs = tbDistrictService.getLovDistrictType();

		if (lovs != null && lovs.size() > 0) {
			result = gson.toJson(lovs);

			return new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Gagal Memuat Data!", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/lov/getLovAllProduct", method = RequestMethod.POST)
	public ResponseEntity<String> getLovAllProduct() {

		ConvertListLovDto convertListLovDto = new ConvertListLovDto();
		List<LovDto> lovs = new ArrayList<>();
		Gson gson = new Gson();
		String result = "";

		lovs = masterProductService.getAllProduct();

		if (lovs != null && lovs.size() > 0) {
			convertListLovDto.setName("lov dto");
			convertListLovDto.setLovDtos(lovs);
			result = gson.toJson(convertListLovDto);

			return new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Gagal Memuat Data!", HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(path = "/lov/getCustomerInput", method = RequestMethod.POST)
	public ResponseEntity<String> getCustomerInput() {

		ConvertListLovDto convertListLovDto = new ConvertListLovDto();
		List<LovDto> lovs = new ArrayList<>();
		Gson gson = new Gson();
		String result = "";

		lovs = customerService.getLovCustomerInput();

		if (lovs != null && lovs.size() > 0) {
			convertListLovDto.setName("lov customer dto");
			convertListLovDto.setLovDtos(lovs);
			result = gson.toJson(convertListLovDto);

			return new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Gagal Memuat Data!", HttpStatus.BAD_REQUEST);
		}

	}

}
