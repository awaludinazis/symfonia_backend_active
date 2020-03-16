package com.gateway.id.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.gateway.id.dao.EbCustomer;
import com.gateway.id.dao.TbProductFlow;
import com.gateway.id.dto.DownloadBasicPriceDto;
import com.gateway.id.dto.LovDistrictDto;
import com.gateway.id.dto.TbProductFlowDto;
import com.gateway.id.repository.CommonFunctionRepository;
import com.gateway.id.repository.EbCustomerRepository;
import com.gateway.id.repository.TbProductFlowPagingRepository;
import com.gateway.id.repository.TbProductFlowRepository;

@Service
public class TbProductFlowService {

	@Autowired
	TbProductFlowRepository productFlowRepository;

	@Autowired
	TbProductFlowPagingRepository pagingRepository;

	@Autowired
	EbCustomerService customerService;

	@Autowired
	TbDistrictService districtService;

	@Autowired
	CommonFunctionRepository commonFunctionRepository;

	public String insertDataList(List<TbProductFlow> tbProductFlows) {

		String result = "";

		if (tbProductFlows.size() > 0) {

			for (TbProductFlow productFlow : tbProductFlows) {
				LovDistrictDto valid = validationSave(productFlow);
				if (valid.getDistCode().equalsIgnoreCase("TRUE")) {
					return result = "INFO : " + valid.getDistName() + "\nDATA YANG SAMA TIDAK BOLEH DI INSERT 2x !!!";
				} else {
					TbProductFlow flow = new TbProductFlow();

					flow = findById(productFlow.getId());

					if (flow.getId() == 0 || flow.getCustomerCode() == null) {
						productFlowRepository.save(productFlow);
					} else {
						flow.setAgingType(productFlow.getAgingType());
						flow.setCreatedBy(productFlow.getCreatedBy());
						flow.setCreatedTm(productFlow.getCreatedTm());
						flow.setCurrencyCarry(productFlow.getCurrencyCarry());
						flow.setCurrencyType(productFlow.getCurrencyType());
						flow.setCustomerCode(productFlow.getCustomerCode());
						flow.setDestCode(productFlow.getDestCode());
						flow.setFlowType(productFlow.getFlowType());
						flow.setInvalidDate(productFlow.getInvalidDate());
						flow.setIsSale(productFlow.getIsSale());
						flow.setModifiedBy(productFlow.getModifiedBy());
						flow.setModifiedTm(productFlow.getModifiedTm());
						flow.setPayCountry(productFlow.getPayCountry());
						flow.setPriceCode(productFlow.getPriceCode());
						flow.setProductCode(productFlow.getProductCode());
						flow.setSourceCode(productFlow.getSourceCode());
						flow.setValidDate(productFlow.getValidDate());

						productFlowRepository.save(flow);

					}

				}

			}

		} else {
			return result = "DATA KOSONG !";
		}

		return result = "SUCCESS UPDATE DATA!";
	}

	public String insertData(TbProductFlow productFlow) {

		String result = "";

		if (productFlow != null && productFlow.getProductCode() != "" && productFlow.getSourceCode() != ""
				&& productFlow.getDestCode() != "") {
			LovDistrictDto valid = validationSave(productFlow);

			if (valid.getDistCode().equalsIgnoreCase("TRUE") && productFlow.getState().equalsIgnoreCase("create")) {
				return result = "INFO : " + valid.getDistName() + " DATA YANG SAMA TIDAK BOLEH DI INSERT 2x !!!";
			} else {
				TbProductFlow flow = new TbProductFlow();

				flow = findById(productFlow.getId());

				if (flow.getId() == 0 || flow.getCustomerCode() == null) {

					productFlow.setCreatedTm(new Date());
					productFlow.setModifiedTm(new Date());
					productFlow.setValidDate(productFlow.getValidDate());
					productFlow.setInvalidDate(productFlow.getInvalidDate());
					productFlow.setCreatedBy("Admin");
					productFlow.setModifiedBy("Admin");
					productFlow.setStatus(0);
					productFlow.setIsSale(0);

					productFlowRepository.save(productFlow);
				} else {
					flow.setAgingType(productFlow.getAgingType());
					flow.setCreatedBy(productFlow.getCreatedBy());
					flow.setCreatedTm(productFlow.getCreatedTm());
					flow.setCurrencyCarry(productFlow.getCurrencyCarry());
					flow.setCurrencyType(productFlow.getCurrencyType());
					flow.setCustomerCode(productFlow.getCustomerCode());
					flow.setDestCode(productFlow.getDestCode());
					flow.setFlowType(productFlow.getFlowType());
					flow.setInvalidDate(productFlow.getInvalidDate());
					flow.setIsSale(productFlow.getIsSale());
					flow.setModifiedBy(productFlow.getModifiedBy());
					flow.setModifiedTm(new Date());
					flow.setPayCountry(productFlow.getPayCountry());
					flow.setPriceCode(productFlow.getPriceCode());
					flow.setProductCode(productFlow.getProductCode());
					flow.setSourceCode(productFlow.getSourceCode());
					flow.setValidDate(productFlow.getValidDate());

					productFlowRepository.save(flow);

				}

			}

		} else {
			return result = "DATA KOSONG !";
		}

		return result = "SUCCESS UPDATE DATA!";
	}

	private LovDistrictDto validationSave(TbProductFlow productFlow) {

		List<TbProductFlow> list = new ArrayList<>();
		LovDistrictDto result = new LovDistrictDto();
		list = productFlowRepository.findByCustomerCode(productFlow.getCustomerCode());

		if (list.size() > 0) {
			for (TbProductFlow flow : list) {
				String oldString = productFlow.getSourceCode() + " " + productFlow.getDestCode() + " "
						+ productFlow.getProductCode();
				String newString = flow.getSourceCode() + " " + flow.getDestCode() + " " + flow.getProductCode();

				if (oldString.equalsIgnoreCase(newString)) {
					result.setDistCode("TRUE");
					result.setDistName(newString);
					return result;
				}
			}
		}
		result.setDistCode("FALSE");

		return result;
	}

	public Boolean deleteStatusById(Long id) {

		TbProductFlow productFlow = new TbProductFlow();

		if (id != null) {
			productFlow = findById(id);
			if (productFlow.getSourceCode() != null && productFlow.getDestCode() != null) {
				// Active status = 1, Inactive = 0
				productFlow.setStatus(1);
				productFlow.setModifiedTm(new Date());
				productFlowRepository.save(productFlow);
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}

		} else {
			return Boolean.FALSE;
		}

	}

	public TbProductFlow findItem(String customerCode, String sourceCode, String destCode, String productCode) {

		TbProductFlow productFlow = new TbProductFlow();

		if (customerCode != null && sourceCode != null && destCode != null) {
			productFlow = productFlowRepository.findByCustomerCodeAndSourceCodeAndDestCodeAndProductCode(customerCode,
					sourceCode, destCode, productCode);

			return productFlow;
		} else {
			return productFlow;
		}

	}

	public TbProductFlow findById(Long id) {

		TbProductFlow productFlow = new TbProductFlow();
		Optional<TbProductFlow> flow;

		if (id != null) {
			flow = productFlowRepository.findById(id);

			if (flow != null && !flow.toString().equalsIgnoreCase("Optional.empty")) {
				productFlow = flow.get();
			}
			return productFlow;
		} else {
			return productFlow;
		}

	}

	public Page<TbProductFlow> pagingData(int start, int length, String sort, String column) {
		Sort.Direction direction = Sort.Direction.ASC;

		if (sort.equalsIgnoreCase("desc")) {
			direction = Sort.Direction.DESC;
		}

		Pageable pageable = PageRequest.of(start, length, direction, column);

		Page<TbProductFlow> page = pagingRepository.findAll(pageable);

		page.getContent().forEach((tbProductFlow) -> {
			String customerName = "";
			String customerCode = "";
			String distNameSource = "";
			String distNameDestination = "";

			customerCode = tbProductFlow.getCustomerCode();
			customerName = customerService.getCustomerName(customerCode);
			distNameSource = districtService.findByDistName(tbProductFlow.getSourceCode());
			distNameDestination = districtService.findByDistName(tbProductFlow.getDestCode());

			tbProductFlow.setCustomerName(customerName);
			tbProductFlow.setSourceCode(distNameSource);
			tbProductFlow.setDestCode(distNameDestination);

		});

		return page;
	}

	public Page<TbProductFlow> searchData(int start, int length, String sort, String column, String custCode) {
		Sort.Direction direction = Sort.Direction.ASC;

		if (sort.equalsIgnoreCase("desc")) {
			direction = Sort.Direction.DESC;
		}

		Pageable pageable = PageRequest.of(start, length, direction, column);

		Page<TbProductFlow> page = pagingRepository.findByCustomerCodeAndStatus(pageable, custCode, 0);

		page.getContent().forEach((tbProductFlow) -> {
			String customerName = "";
			String customerCode = "";
			String distNameSource = "";
			String distNameDestination = "";

			customerCode = tbProductFlow.getCustomerCode();
			customerName = customerService.getCustomerName(customerCode);
			distNameSource = districtService.findByDistName(tbProductFlow.getSourceCode());
			distNameDestination = districtService.findByDistName(tbProductFlow.getDestCode());

			tbProductFlow.setCustomerName(customerName);
			tbProductFlow.setSourceCode(distNameSource);
			tbProductFlow.setDestCode(distNameDestination);

		});

		return page;
	}

	public Page<TbProductFlow> pagingDataByCustomerCode(int start, int length, String sort, String column,
			String customerCode) {
		Sort.Direction direction = Sort.Direction.ASC;

		if (sort.equalsIgnoreCase("desc")) {
			direction = Sort.Direction.DESC;
		}

		Pageable pageable = PageRequest.of(start, length, direction, column);

		Page<TbProductFlow> page = pagingRepository.findByCustomerCodeAndStatus(pageable, customerCode, 0);

		page.getContent().forEach((tbProductFlow) -> {
			String validDate = "";
			String invalidDate = "";
			String createdTm = "";

			validDate = convertDate(tbProductFlow.getValidDate());
			invalidDate = convertDate(tbProductFlow.getInvalidDate());
			createdTm = convertDate(tbProductFlow.getCreatedTm());

			tbProductFlow.setValidString(validDate);
			tbProductFlow.setInvalidString(invalidDate);
			tbProductFlow.setCreateTmString(createdTm);

		});

		return page;
	}

	private String convertDate(Date date) {
		String result = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		String strDate = dateFormat.format(date);
		result = strDate;

		return result;
	}

	public List<DownloadBasicPriceDto> downloadData(String customerCode) {

		List<DownloadBasicPriceDto> list = new ArrayList<>();

		list = commonFunctionRepository.getFunctionProductFlow(customerCode);

		return list;
	}

	public TbProductFlowDto getAllData() {
		TbProductFlowDto list = new TbProductFlowDto();
		List<TbProductFlow> products = new ArrayList<>();

		products = productFlowRepository.findAll();

		if (products.size() > 0) {
			list.setProductFlows(products);
		}

		return list;
	}

}
