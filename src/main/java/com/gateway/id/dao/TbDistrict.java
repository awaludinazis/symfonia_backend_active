package com.gateway.id.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_district")
public class TbDistrict {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "DIST_CODE")
	private String distCode;

	@Column(name = "DIST_NAME")
	private String distName;

	@Column(name = "DIST_TYPE")
	private String distType;

	@Column(name = "PARENT_DIST_CODE")
	private String parentDistCode;

	@Column(name = "VALID_FLG")
	private Integer validFlg;

	@Column(name = "TOKOPEDIA_ID")
	private String tokopediaId;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	@Column(name = "AREA_CODE")
	private String areaCode;

	@Column(name = "CURRENCY_CODE")
	private String currencyCode;

	@Column(name = "IS_DELIVERY")
	private Integer isDelivery;

	@Column(name = "IS_RECEIVE")
	private Integer isReceive;

	@Column(name = "CREATED_EMP_CODE")
	private String createdEmpCode;

	@Column(name = "CREATED_TM")
	private Date createdTm;

	@Column(name = "MODIFIED_EMP_CODE")
	private String modifiedEmpCode;

	@Column(name = "MODIFIED_TM")
	private Date modifiedTm;

	@Column(name = "POSTAL_CODE")
	private String postalCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistCode() {
		return distCode;
	}

	public void setDistCode(String distCode) {
		this.distCode = distCode;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}

	public String getDistType() {
		return distType;
	}

	public void setDistType(String distType) {
		this.distType = distType;
	}

	public String getParentDistCode() {
		return parentDistCode;
	}

	public void setParentDistCode(String parentDistCode) {
		this.parentDistCode = parentDistCode;
	}

	public Integer getValidFlg() {
		return validFlg;
	}

	public void setValidFlg(Integer validFlg) {
		this.validFlg = validFlg;
	}

	public String getTokopediaId() {
		return tokopediaId;
	}

	public void setTokopediaId(String tokopediaId) {
		this.tokopediaId = tokopediaId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getIsDelivery() {
		return isDelivery;
	}

	public void setIsDelivery(Integer isDelivery) {
		this.isDelivery = isDelivery;
	}

	public Integer getIsReceive() {
		return isReceive;
	}

	public void setIsReceive(Integer isReceive) {
		this.isReceive = isReceive;
	}

	public String getCreatedEmpCode() {
		return createdEmpCode;
	}

	public void setCreatedEmpCode(String createdEmpCode) {
		this.createdEmpCode = createdEmpCode;
	}

	public Date getCreatedTm() {
		return createdTm;
	}

	public void setCreatedTm(Date createdTm) {
		this.createdTm = createdTm;
	}

	public String getModifiedEmpCode() {
		return modifiedEmpCode;
	}

	public void setModifiedEmpCode(String modifiedEmpCode) {
		this.modifiedEmpCode = modifiedEmpCode;
	}

	public Date getModifiedTm() {
		return modifiedTm;
	}

	public void setModifiedTm(Date modifiedTm) {
		this.modifiedTm = modifiedTm;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "TbDistrict [id=" + id + ", distCode=" + distCode + ", distName=" + distName + ", distType=" + distType
				+ ", parentDistCode=" + parentDistCode + ", validFlg=" + validFlg + ", tokopediaId=" + tokopediaId
				+ ", countryCode=" + countryCode + ", areaCode=" + areaCode + ", currencyCode=" + currencyCode
				+ ", isDelivery=" + isDelivery + ", isReceive=" + isReceive + ", createdEmpCode=" + createdEmpCode
				+ ", createdTm=" + createdTm + ", modifiedEmpCode=" + modifiedEmpCode + ", modifiedTm=" + modifiedTm
				+ ", postalCode=" + postalCode + "]";
	}

}
