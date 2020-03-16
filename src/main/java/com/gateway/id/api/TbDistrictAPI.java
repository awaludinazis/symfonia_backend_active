package com.gateway.id.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.id.dao.TbDistrict;
import com.gateway.id.dto.LovDistrictDto;
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

	@RequestMapping(path = "/district/getDistName", method = RequestMethod.POST)
	public ResponseEntity<String> getDistName(@RequestParam("distType") String distType, @RequestParam("distCode") String distCode) {

		LovDistrictDto dto = new LovDistrictDto();
		Gson gson = new Gson();
		String result = "";

		dto = tbDistrictService.findDistrictName(distType, distCode);

		if (dto != null) {
			result = gson.toJson(dto);

			return new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Gagal Memuat Data!", HttpStatus.BAD_REQUEST);
		}

	}

}
