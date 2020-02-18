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

import com.gateway.id.dto.LovDistrictDto;
import com.gateway.id.dto.TbProductFlowDto;
import com.gateway.id.repository.TbDistrictRepository;
import com.gateway.id.service.TbDistrictService;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
public class TbDistrictAPI {

	private static final Logger LOG = LoggerFactory.getLogger(TbDistrictAPI.class);

	@Autowired
	TbDistrictService tbDistrictService;

	@RequestMapping(path = "/district/ping", method = RequestMethod.GET)
	public ResponseEntity<String> echo() {
		return new ResponseEntity<String>("SUCCESS!!!", HttpStatus.OK);
	}

	

}
