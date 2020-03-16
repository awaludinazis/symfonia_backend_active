package com.gateway.id.dto;

import java.util.List;

public class ConvertListLovDto {

	private String name;
	private List<LovDto> lovDtos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LovDto> getLovDtos() {
		return lovDtos;
	}

	public void setLovDtos(List<LovDto> lovDtos) {
		this.lovDtos = lovDtos;
	}

}
