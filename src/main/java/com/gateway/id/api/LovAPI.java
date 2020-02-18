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

import com.gateway.id.dto.LovCustomerNameDto;
import com.gateway.id.dto.LovDistrictDto;
import com.gateway.id.service.EbCustomerService;
import com.gateway.id.service.TbDistrictService;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
public class LovAPI {

	@Autowired
	TbDistrictService tbDistrictService;

	@Autowired
	EbCustomerService customerService;

	private static final Logger LOG = LoggerFactory.getLogger(LovAPI.class);

	@RequestMapping(path = "/lov/ping", method = RequestMethod.GET)
	public ResponseEntity<String> echo() {
		return new ResponseEntity<String>("SUCCESS!!!", HttpStatus.OK);
	}

	@RequestMapping(path = "/lov/getLovDistrict", method = RequestMethod.POST)
	public ResponseEntity<String> getAllData(@RequestParam("distType") String distType) {

		List<LovDistrictDto> lovs = new ArrayList<>();
		Gson gson = new Gson();
		String result = "";

		lovs = tbDistrictService.findByDistType(distType);

		if (lovs != null && lovs.size() > 0) {
			result = gson.toJson(lovs);

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

}
