package com.gateway.id.dto;

import java.util.List;

public class LovDistrictSearchableDto {

	private String name;
	private List<LovDistrictDto> listDto;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LovDistrictDto> getListDto() {
		return listDto;
	}

	public void setListDto(List<LovDistrictDto> listDto) {
		this.listDto = listDto;
	}

}
