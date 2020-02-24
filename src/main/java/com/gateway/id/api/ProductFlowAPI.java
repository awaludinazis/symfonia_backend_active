package com.gateway.id.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gateway.id.common.WriteExcelProduct;
import com.gateway.id.dao.TbProductFlow;
import com.gateway.id.dao.TbProductFlowHeader;
import com.gateway.id.dto.DownloadBasicPriceDto;
import com.gateway.id.dto.TbProductFlowDto;
import com.gateway.id.service.TbProductFlowHeaderService;
import com.gateway.id.service.TbProductFlowService;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
public class ProductFlowAPI {

	private static final Logger LOG = LoggerFactory.getLogger(ProductFlowAPI.class);

	@Autowired
	TbProductFlowService productFlowService;

	@Autowired
	TbProductFlowHeaderService productFlowHeaderService;
	
	@Value("${server.path}")
	private String serverPath;

	@RequestMapping(path = "/productFlow/ping", method = RequestMethod.GET)
	public ResponseEntity<String> echo() {
		return new ResponseEntity<String>("SUCCESS!!!", HttpStatus.OK);
	}

	@RequestMapping(path = "/productFlow/insertData", method = RequestMethod.POST)
	public ResponseEntity<String> createCustomer(@RequestBody TbProductFlowDto listProductFlow) {

		String result = "";
		Gson gson = new Gson();

		if (listProductFlow != null && listProductFlow.getProductFlows().size() > 0) {
			try {

				result = productFlowService.insertData(listProductFlow.getProductFlows());

				return new ResponseEntity<String>(gson.toJson(result), HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<String>(gson.toJson("Gagal Menyimpan Data!"), HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<String>(gson.toJson("Data Kosong Harap Isi Data!"), HttpStatus.FORBIDDEN);
	}

//	@RequestMapping(path = "/productFlow/getAllData", method = RequestMethod.GET)
//	public ResponseEntity<String> getAllData() {
//
//		List<TbProductFlowDto> flows = new ArrayList<>();
//		Gson gson = new Gson();
//		String result = "";
//
//		flows = productFlowService.findAll();
//
//		if (flows != null && flows.size() > 0) {
//			result = gson.toJson(flows);
//
//			return new ResponseEntity<String>(result, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<String>("Gagal Memuat Data!", HttpStatus.BAD_REQUEST);
//		}
//
//	}

	@RequestMapping(path = "/productFlow/getById", method = RequestMethod.GET)
	public ResponseEntity<String> getById(@RequestBody TbProductFlow productFlow) {

		TbProductFlow flow = new TbProductFlow();
		Gson gson = new Gson();
		String result = "";

		flow = productFlowService.findById(productFlow.getId());

		if (flow != null) {
			result = gson.toJson(flow);

			return new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Gagal Memuat Data!", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/productFlow/getDeleteById", method = RequestMethod.POST)
	public ResponseEntity<Boolean> getDeleteById(@RequestBody TbProductFlow productFlow) {

		Boolean result = Boolean.FALSE;

		if (productFlow != null) {
			try {

				result = productFlowService.deleteDataById(productFlow.getId());

				return new ResponseEntity<Boolean>(result, HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<Boolean>(result, HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<Boolean>(result, HttpStatus.FORBIDDEN);

	}

	@RequestMapping(path = "/productFlow/deleteStatus", method = RequestMethod.POST)
	public ResponseEntity<Boolean> deleteStatus(@RequestBody TbProductFlow productFlow) {

		Boolean result = Boolean.FALSE;

		if (productFlow != null) {
			try {

				result = productFlowService.deleteStatus(productFlow.getId());

				return new ResponseEntity<Boolean>(result, HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<Boolean>(result, HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<Boolean>(result, HttpStatus.FORBIDDEN);

	}

	@RequestMapping(path = "/productFlow/paging", method = RequestMethod.POST)
	public ResponseEntity<String> paging(@RequestParam("start") int start, @RequestParam("length") int length,
			@RequestParam("sort") String sort, @RequestParam("column") String column) {

		String result = "";
		Page<TbProductFlow> page;
		List<TbProductFlow> list = new ArrayList<>();
		Gson gson = new Gson();

		try {

			page = productFlowService.pagingData(start, length, sort, column);

			result = gson.toJson(page);
			return new ResponseEntity<String>(result, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/productFlow/pagingFlowHeader", method = RequestMethod.POST)
	public ResponseEntity<String> pagingFlowHeader(@RequestParam("start") int start, @RequestParam("length") int length,
			@RequestParam("sort") String sort, @RequestParam("column") String column) {

		String result = "";
		Page<TbProductFlowHeader> page;
		Gson gson = new Gson();

		try {

			page = productFlowHeaderService.pagingData(start, length, sort, column);

			result = gson.toJson(page);
			return new ResponseEntity<String>(result, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/productFlow/pagingByCustomerCode", method = RequestMethod.POST)
	public ResponseEntity<String> pagingByCustomerCode(@RequestParam("start") int start,
			@RequestParam("length") int length, @RequestParam("sort") String sort,
			@RequestParam("column") String column, @RequestParam("customerCode") String customerCode) {

		String result = "";
		Page<TbProductFlow> page;
		List<TbProductFlow> list = new ArrayList<>();
		Gson gson = new Gson();

		try {

			page = productFlowService.pagingDataByCustomerCode(start, length, sort, column, customerCode);

			result = gson.toJson(page);
			return new ResponseEntity<String>(result, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/productFlow/pagingBySearch", method = RequestMethod.POST)
	public ResponseEntity<String> pagingBySearch(@RequestParam("start") int start, @RequestParam("length") int length,
			@RequestParam("sort") String sort, @RequestParam("column") String column,
			@RequestParam("customerCode") String customerCode, @RequestParam("customerName") String customerName,
			@RequestParam("status") Integer status) {

		String result = "";
		Page<TbProductFlowHeader> page;
		Gson gson = new Gson();

		if (customerCode.equalsIgnoreCase("")) {
			customerCode = null;
		}

		if (customerName.equalsIgnoreCase("")) {
			customerName = null;
		}

		if (status == null) {
			status = null;
		}

		try {

			page = productFlowHeaderService.pagingSearchData(start, length, sort, column, customerCode, customerName,
					status);

			result = gson.toJson(page);
			return new ResponseEntity<String>(result, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(path = "/productFlow/downloadProductFlow", method = RequestMethod.GET)
	public ResponseEntity<String> downloadProductFlow(@RequestParam("customerCode") String customerCode,
			HttpServletResponse response) {

		String result = "";
		List<DownloadBasicPriceDto> list = new ArrayList<>();
		Gson gson = new Gson();

		WriteExcelProduct excelProduct = new WriteExcelProduct();

		try {

			list = productFlowService.downloadData(customerCode);

			String filepath = excelProduct.generateDataProduct(customerCode, list, serverPath);

			String filename = customerCode + "-" + "basePriceCustomer.xlsx";

			response.setHeader("Content-disposition", "attachment;filename=" + filename);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

			File myFile = new File(filepath);
			OutputStream out = response.getOutputStream();
			FileInputStream in = new FileInputStream(myFile);
			byte[] buffer = new byte[4096];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			out.flush();
			in.close();

			result = gson.toJson(filepath);
			return new ResponseEntity<String>(result, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}

	}

}
