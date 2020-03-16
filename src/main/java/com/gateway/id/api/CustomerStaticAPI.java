package com.gateway.id.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.id.dao.EbCustomer;
import com.gateway.id.dao.TbProductFlow;
import com.gateway.id.dto.TbProductFlowDto;
import com.gateway.id.service.EbCustomerService;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
public class CustomerStaticAPI {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerStaticAPI.class);

	@Autowired
	EbCustomerService customerService;

	@RequestMapping(path = "/customerStatic/ping", method = RequestMethod.GET)
	public ResponseEntity<String> echo() {
		return new ResponseEntity<String>("SUCCESS!!!", HttpStatus.OK);
	}

	@RequestMapping(path = "/customerStatic/insertData", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public ResponseEntity<String> insertData(@RequestBody EbCustomer customer) {

		String result = "";
		Gson gson = new Gson();

		if (customer != null && customer.getState() != null) {
			try {

				result = customerService.insertData(customer);

				return new ResponseEntity<String>(gson.toJson(result), HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<String>(gson.toJson("Gagal Menyimpan Data!"), HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<String>(gson.toJson("Data Kosong Harap Isi Data!"), HttpStatus.FORBIDDEN);
	}

	@RequestMapping(path = "/customerStatic/pagingSearchParam", method = RequestMethod.POST)
	public ResponseEntity<String> pagingSearchParam(@RequestParam("start") int start,
			@RequestParam("length") int length, @RequestParam("sort") String sort,
			@RequestParam("column") String column, @RequestParam("customerCode") String customerCode,
			@RequestParam("customerFullname") String customerFullname,
			@RequestParam("customerBusiness") String customerBusiness, @RequestParam("payCycle") String payCycle,
			@RequestParam("isActive") String isActive) {

		String result = "";
		Page<EbCustomer> page;
		Gson gson = new Gson();
		Integer intPayCycle = null;
		Integer intIsActive = null;

		if (customerCode.equalsIgnoreCase("")) {
			customerCode = null;
		}

		if (customerFullname.equalsIgnoreCase("")) {
			customerFullname = null;
		}

		if (customerBusiness.equalsIgnoreCase("")) {
			customerBusiness = null;
		}

		if (payCycle.equalsIgnoreCase("")) {
			intPayCycle = null;
		} else {
			intPayCycle = Integer.parseInt(payCycle);
		}

		if (isActive.equalsIgnoreCase("")) {
			intIsActive = null;
		} else {
			intIsActive = Integer.parseInt(isActive);
		}

		try {

			page = customerService.pagingSearchData(start, length, sort, column, customerCode, customerFullname,
					customerBusiness, intPayCycle, intIsActive);

			result = gson.toJson(page);
			return new ResponseEntity<String>(result, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/customerStatic/customerCode", method = RequestMethod.POST)
	public ResponseEntity<String> insertDataList(@RequestBody EbCustomer ebCustomer) {

		String result = "";
		Gson gson = new Gson();
		EbCustomer customer = new EbCustomer();

		if (ebCustomer != null && ebCustomer.getCustomerCode() != null) {
			try {

				customer = customerService.findByCustomerCode(ebCustomer.getCustomerCode());
				result = gson.toJson(customer);

				return new ResponseEntity<String>(result, HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<String>(gson.toJson("Gagal Load Data!"), HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<String>(gson.toJson("Data Kosong Harap Isi Data!"), HttpStatus.FORBIDDEN);
	}

	@RequestMapping(path = "/customerStatic/findAll", method = RequestMethod.POST)
	public ResponseEntity<String> findAll() {

		String result = "";
		Gson gson = new Gson();
		List<EbCustomer> customerList = new ArrayList<>();

		try {

			customerList = customerService.findAll();
			result = gson.toJson(customerList);

			return new ResponseEntity<String>(result, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<String>(gson.toJson("Gagal Load Data!"), HttpStatus.BAD_REQUEST);
		}
	}
}
