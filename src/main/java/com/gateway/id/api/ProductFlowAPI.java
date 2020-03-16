package com.gateway.id.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.gateway.id.dto.FlowDto;
import com.gateway.id.dto.ListFlowDto;
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

	@RequestMapping(path = "/productFlow/insertDataList", method = RequestMethod.POST)
	public ResponseEntity<String> insertDataList(@RequestBody ListFlowDto listProductFlow) throws ParseException {

		String result = "";
		Gson gson = new Gson();

		List<TbProductFlow> list = new ArrayList<>();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		if (listProductFlow.getListFlowDtos() != null && listProductFlow.getListFlowDtos().size() > 0) {

			for (FlowDto dto : listProductFlow.getListFlowDtos()) {
				TbProductFlow productFlow = new TbProductFlow();

				String invalid = dto.getInvalidDate();
				String valid = dto.getValidDate();

				Date dateinvalid = formatter.parse(invalid);
				Date datevalid = formatter.parse(valid);

				productFlow.setAgingType(dto.getAgingType());
				productFlow.setCreatedBy("Admin");
				productFlow.setCreatedTm(new Date());
				productFlow.setCurrencyCarry("-1");
				productFlow.setCurrencyType("IDR");
				productFlow.setCustomerCode(dto.getCustomerCode());
				productFlow.setCustomerName(dto.getCustomerName());
				productFlow.setDestCode(dto.getDestCode());
				productFlow.setFlowType(dto.getFlowType());
				productFlow.setInvalidDate(dateinvalid);
				productFlow.setValidDate(datevalid);
				productFlow.setIsSale(0);
				productFlow.setModifiedBy("Admin");
				productFlow.setModifiedTm(new Date());
				productFlow.setPayCountry(dto.getPayCountry());
				productFlow.setPriceCode(dto.getPriceCode());
				productFlow.setProductCode(dto.getProductCode());
				productFlow.setRoundTrip(dto.getRoundTrip());
				productFlow.setSourceCode(dto.getSourceCode());
				productFlow.setStatus(0);

				list.add(productFlow);
			}

		}

		if (listProductFlow != null && listProductFlow.getListFlowDtos().size() > 0) {
			try {

				result = productFlowService.insertDataList(list);

				return new ResponseEntity<String>(gson.toJson(result), HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<String>(gson.toJson("Gagal Menyimpan Data!"), HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<String>(gson.toJson("Data Kosong Harap Isi Data!"), HttpStatus.FORBIDDEN);
	}

	@RequestMapping(path = "/productFlow/insertData", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public ResponseEntity<String> insertData(@RequestBody TbProductFlow productFlow) {

		String result = "";
		Gson gson = new Gson();
		String origin = "";
		String destination = "";

		if (productFlow != null && productFlow.getCustomerCode() != null) {
			if (productFlow.getFlowType().equalsIgnoreCase("2-2")) {
				origin = productFlow.getSourceCode();
				destination = productFlow.getDestCode();
				productFlow.setSourceCode(origin.substring(0, 2));
				productFlow.setDestCode(destination.substring(0, 2));
			}
			if (productFlow.getFlowType().equalsIgnoreCase("3-3")) {
				origin = productFlow.getSourceCode();
				destination = productFlow.getDestCode();
				productFlow.setSourceCode(origin.substring(0, 5));
				productFlow.setDestCode(destination.substring(0, 5));
			}
			if (productFlow.getFlowType().equalsIgnoreCase("4-4")) {
				origin = productFlow.getSourceCode();
				destination = productFlow.getDestCode();
				productFlow.setSourceCode(origin.substring(0, 8));
				productFlow.setDestCode(destination.substring(0, 8));
			}

			try {

				result = productFlowService.insertData(productFlow);

				return new ResponseEntity<String>(gson.toJson(result), HttpStatus.OK);

			} catch (Exception e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<String>(gson.toJson("Gagal Menyimpan Data!"), HttpStatus.BAD_REQUEST);
			}
		}

		return new ResponseEntity<String>(gson.toJson("Data Kosong Harap Isi Data!"), HttpStatus.FORBIDDEN);
	}

	@RequestMapping(path = "/productFlow/getAllData", method = RequestMethod.GET)
	public ResponseEntity<String> getAllData() {

		TbProductFlowDto flows = new TbProductFlowDto();
		Gson gson = new Gson();
		String result = "";

		flows = productFlowService.getAllData();

		if (flows != null) {
			result = gson.toJson(flows);

			return new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Gagal Memuat Data!", HttpStatus.BAD_REQUEST);
		}

	}

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

	@RequestMapping(path = "/productFlow/getInactiveDataById", method = RequestMethod.POST)
	public ResponseEntity<Boolean> getInactiveDataById(@RequestParam("id") Integer id) {

		Boolean result = Boolean.FALSE;

		if (id != null) {
			try {
				Long idLong = new Long(id);
				result = productFlowService.deleteStatusById(idLong);

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

			String filename = customerCode + "_" + "basePriceCustomer.xlsx";

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
