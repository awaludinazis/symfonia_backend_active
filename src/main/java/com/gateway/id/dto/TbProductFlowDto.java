package com.gateway.id.dto;

import java.util.List;

import com.gateway.id.dao.TbProductFlow;

public class TbProductFlowDto {

	private List<TbProductFlow> productFlows;

	public List<TbProductFlow> getProductFlows() {
		return productFlows;
	}

	public void setProductFlows(List<TbProductFlow> productFlows) {
		this.productFlows = productFlows;
	}

}
