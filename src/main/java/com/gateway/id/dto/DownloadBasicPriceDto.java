package com.gateway.id.dto;

public class DownloadBasicPriceDto {

	private String no;
	private String provinceOrigin;
	private String cityOrigin;
	private String provinceDestination;
	private String cityDestination;
	private String productCode;
	private String priceCode;
	private String sla;
	private String updated;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getProvinceOrigin() {
		return provinceOrigin;
	}

	public void setProvinceOrigin(String provinceOrigin) {
		this.provinceOrigin = provinceOrigin;
	}

	public String getCityOrigin() {
		return cityOrigin;
	}

	public void setCityOrigin(String cityOrigin) {
		this.cityOrigin = cityOrigin;
	}

	public String getProvinceDestination() {
		return provinceDestination;
	}

	public void setProvinceDestination(String provinceDestination) {
		this.provinceDestination = provinceDestination;
	}

	public String getCityDestination() {
		return cityDestination;
	}

	public void setCityDestination(String cityDestination) {
		this.cityDestination = cityDestination;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}

	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
