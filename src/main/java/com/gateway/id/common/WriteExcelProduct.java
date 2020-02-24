package com.gateway.id.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;

import com.gateway.id.dto.DownloadBasicPriceDto;

public class WriteExcelProduct {

	public String generateDataProduct(String customerCode, List<DownloadBasicPriceDto> listPrice, String serverPath) throws IOException {

		String[] columns = { "No", "Province Origin", "City Origin", "Province Destination", "City Destination",
				"Service", "Price/Kg", "SLA" };
		List<DownloadBasicPriceDto> priceDto = new ArrayList<>();

		priceDto = listPrice;

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances of various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Based Price Customer");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create Other rows and cells with employees data
		int rowNum = 1;
		for (DownloadBasicPriceDto price : priceDto) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(price.getNo());
			row.createCell(1).setCellValue(price.getProvinceOrigin());
			row.createCell(2).setCellValue(price.getCityOrigin());
			row.createCell(3).setCellValue(price.getProvinceDestination());
			row.createCell(4).setCellValue(price.getCityDestination());
			row.createCell(5).setCellValue(price.getProductCode());
			row.createCell(6).setCellValue(price.getPriceCode());
			row.createCell(7).setCellValue(price.getSla());

//          Cell dateOfBirthCell = row.createCell(2);
//          dateOfBirthCell.setCellValue(employee.getDateOfBirth());
//          dateOfBirthCell.setCellStyle(dateCellStyle);

		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		String filePath = serverPath;
		String fileName = "";
		Date dateTime = new Date();
		String dateTimeS = getDateEbill(dateTime);
		fileName = dateTimeS + "_" + customerCode + "-" + "basePriceCustomer.xlsx";
		String path = filePath + fileName;

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();

		return path;

	}

	public static String getDateEbill(Date d) {
		if (d == null)
			return "null";

		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");

		return fmtDate.format(d);
	}

}
