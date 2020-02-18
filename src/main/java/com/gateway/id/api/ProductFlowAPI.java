package com.gateway.id.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.springframework.web.multipart.MultipartFile;

import com.gateway.id.common.UploadFileCommon;
import com.gateway.id.dao.TbProductFlow;
import com.gateway.id.dto.TbProductFlowDto;
import com.gateway.id.service.TbProductFlowService;
import com.google.gson.Gson;

@RestController
@RequestMapping("api")
public class ProductFlowAPI {

	private static final Logger LOG = LoggerFactory.getLogger(ProductFlowAPI.class);

	@Autowired
	TbProductFlowService productFlowService;

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

	@RequestMapping(value = "/productFlow/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file) throws IOException {

		byte[] bytes = file.getBytes();
		String fileName = file.getOriginalFilename();
		String extention = getFileExtension(fileName);
		File excelFile = null;
		Boolean validation = validationExtension(extention);

		if (file != null) {
			excelFile = convertMultiPartToFile(file);
		}

		if (bytes != null && fileName != null && validation) {
			try {

				FileInputStream fileInput = new FileInputStream(excelFile);
				Workbook workbook = WorkbookFactory.create(fileInput);
				Sheet datatypeSheet = workbook.getSheetAt(0);
				Iterator<Row> iterator = datatypeSheet.iterator();

				while (iterator.hasNext()) {

					Row currentRow = iterator.next();
					Iterator<Cell> cellIterator = currentRow.iterator();

					while (cellIterator.hasNext()) {

						Cell currentCell = cellIterator.next();
						// getCellTypeEnum shown as deprecated for version 3.15
						// getCellTypeEnum ill be renamed to getCellType starting from version 4.0
						if (currentCell.getCellTypeEnum() == CellType.STRING) {
							System.out.print(currentCell.getStringCellValue() + "--");
						} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
							System.out.print(currentCell.getNumericCellValue() + "--");
						}

					}
					System.out.println();

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return new ResponseEntity<String>("", HttpStatus.OK);
		}

		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@RequestMapping(path = "/productFlow/resource", method = RequestMethod.POST)
	public void resource() {

		String fileName = "Sampleflowbasedpricecustomer.xlsx";
		ClassLoader classLoader = ProductFlowAPI.class.getClassLoader();

		File file = new File(classLoader.getResource(fileName).getFile());

		// File is found
		System.out.println("File Found : " + file.exists());

	}

	public static String getFileExtension(String fileExtension) {
		String fileName = fileExtension;
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public Boolean validationExtension(String fileName) {

		if (fileName != null) {
			if (fileName.equalsIgnoreCase("xlsx") || fileName.equalsIgnoreCase("xls")) {
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		return Boolean.FALSE;
	}

	public File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
