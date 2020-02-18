package com.gateway.id.service;

import java.util.ArrayList;
import java.util.List;
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
import com.gateway.id.dto.LovDistrictDto;
import com.gateway.id.dto.TbProductFlowDto;
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

	public String insertData(List<TbProductFlow> tbProductFlows) {

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

//	public List<TbProductFlowDto> findAll() {
//
//		List<TbProductFlow> list = new ArrayList<>();
//		List<TbProductFlowDto> result = new ArrayList<>();
//
//		list = productFlowRepository.findAll();
//
//		if (list != null && list.size() > 0) {
//
//			for (TbProductFlow productFlow : list) {
//				TbProductFlowDto flowDto = new TbProductFlowDto();
//				String customerName = "";
//				String customerCode = "";
//
//				customerCode = productFlow.getCustomerCode();
//				customerName = customerService.getCustomerName(customerCode);
//
//				flowDto.setAgingType(productFlow.getAgingType());
//				flowDto.setCreatedBy(productFlow.getCreatedBy());
//				flowDto.setCreatedTm(productFlow.getCreatedTm());
//				flowDto.setCurrencyCarry(productFlow.getCurrencyCarry());
//				flowDto.setCustomerCode(productFlow.getCustomerCode());
//				flowDto.setCustomerName(customerName);
//				flowDto.setDestCode(productFlow.getDestCode());
//				flowDto.setFlowType(productFlow.getFlowType());
//				flowDto.setId(productFlow.getId());
//				flowDto.setInvalidDate(productFlow.getInvalidDate());
//				flowDto.setIsSale(productFlow.getIsSale());
//				flowDto.setModifiedBy(productFlow.getModifiedBy());
//				flowDto.setModifiedTm(productFlow.getModifiedTm());
//				flowDto.setPayCountry(productFlow.getPayCountry());
//				flowDto.setPriceCode(productFlow.getPriceCode());
//				flowDto.setProductCode(productFlow.getProductCode());
//				flowDto.setSourceCode(productFlow.getSourceCode());
//				flowDto.setStatus(productFlow.getStatus());
//				flowDto.setValidDate(productFlow.getValidDate());
//
//				result.add(flowDto);
//			}
//		}
//
//		return result;
//	}

	public Boolean deleteDataById(Long id) {

		if (id != null) {
			productFlowRepository.deleteById(id);

			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	public Boolean deleteStatus(Long id) {

		TbProductFlow productFlow = new TbProductFlow();

		if (id != null) {
			productFlow = findById(id);

			// Active status = 1, Inactive = 0
			productFlow.setStatus(1);
			productFlowRepository.save(productFlow);

			return Boolean.TRUE;
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

		Page<TbProductFlow> page = pagingRepository.findByCustomerCode(pageable, custCode);

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

		Page<TbProductFlow> page = pagingRepository.findByCustomerCode(pageable, customerCode);

		return page;
	}

	private List<TbProductFlow> groupingList(List<TbProductFlow> list) {
		List<TbProductFlow> result = new ArrayList<>();
		List<TbProductFlow> resultsda = new ArrayList<>();

		if (list != null) {
			for (TbProductFlow flow : list) {
				if (result.size() > 0) {
					for (TbProductFlow xxx : result) {
						if (xxx.getCustomerCode().equalsIgnoreCase(flow.getCustomerCode())) {
							result.add(flow);
						}
					}
				} else {
					result.add(flow);
				}

			}
		}

//		if (list != null && list.size() > 0) {
//			for (TbProductFlow rates : result) {
//				Boolean isAvailable = Boolean.FALSE;
//				for (TbProductFlow customer : list) {
//					if (result != null) {
//						if (!rates.getCustomerCode().equalsIgnoreCase(customer.getCustomerCode())) {
//							resultsda.add(customer);
//							isAvailable = Boolean.TRUE;
//						}
//					}
//
//				}
//				if (!isAvailable) {
//					result.add(rates);
//				}
//			}
//
//		}

		Map<String, List<TbProductFlow>> studlistGrouped = list.stream()
				.collect(Collectors.groupingBy(w -> w.getCustomerCode()));

		return result;
	}

}
