package com.gateway.id.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_product_flow")
public class TbProductFlow {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "flow_type")
	private String flowType;

	@Column(name = "source_code")
	private String sourceCode;

	@Column(name = "dest_code")
	private String destCode;

	@Column(name = "pay_country")
	private String payCountry;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "valid_date")
	private Date validDate;

	@Column(name = "invalid_date")
	private Date invalidDate;

	@Column(name = "price_code")
	private String priceCode;

	@Column(name = "currency_type")
	private String currencyType;

	@Column(name = "currency_carry")
	private String currencyCarry;

	@Column(name = "is_sale")
	private Integer isSale;

	@Column(name = "created_tm")
	private Date createdTm;

	@Column(name = "modified_tm")
	private Date modifiedTm;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "aging_type")
	private String agingType;

	@Column(name = "customer_code")
	private String customerCode;

	@Column(name = "status")
	private Integer status;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "round_trip")
	private Integer roundTrip;

	@Transient
	private String state;

	@Transient
	private String validString;

	@Transient
	private String invalidString;

	@Transient
	private String createTmString;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getDestCode() {
		return destCode;
	}

	public void setDestCode(String destCode) {
		this.destCode = destCode;
	}

	public String getPayCountry() {
		return payCountry;
	}

	public void setPayCountry(String payCountry) {
		this.payCountry = payCountry;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public Date getInvalidDate() {
		return invalidDate;
	}

	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}

	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getCurrencyCarry() {
		return currencyCarry;
	}

	public void setCurrencyCarry(String currencyCarry) {
		this.currencyCarry = currencyCarry;
	}

	public Integer getIsSale() {
		return isSale;
	}

	public void setIsSale(Integer isSale) {
		this.isSale = isSale;
	}

	public Date getCreatedTm() {
		return createdTm;
	}

	public void setCreatedTm(Date createdTm) {
		this.createdTm = createdTm;
	}

	public Date getModifiedTm() {
		return modifiedTm;
	}

	public void setModifiedTm(Date modifiedTm) {
		this.modifiedTm = modifiedTm;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getAgingType() {
		return agingType;
	}

	public void setAgingType(String agingType) {
		this.agingType = agingType;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getRoundTrip() {
		return roundTrip;
	}

	public void setRoundTrip(Integer roundTrip) {
		this.roundTrip = roundTrip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getValidString() {
		return validString;
	}

	public void setValidString(String validString) {
		this.validString = validString;
	}

	public String getInvalidString() {
		return invalidString;
	}

	public void setInvalidString(String invalidString) {
		this.invalidString = invalidString;
	}

	public String getCreateTmString() {
		return createTmString;
	}

	public void setCreateTmString(String createTmString) {
		this.createTmString = createTmString;
	}

	@Override
	public String toString() {
		return "TbProductFlow [id=" + id + ", flowType=" + flowType + ", sourceCode=" + sourceCode + ", destCode="
				+ destCode + ", payCountry=" + payCountry + ", productCode=" + productCode + ", validDate=" + validDate
				+ ", invalidDate=" + invalidDate + ", priceCode=" + priceCode + ", currencyType=" + currencyType
				+ ", currencyCarry=" + currencyCarry + ", isSale=" + isSale + ", createdTm=" + createdTm
				+ ", modifiedTm=" + modifiedTm + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", agingType=" + agingType + ", customerCode=" + customerCode + ", status=" + status
				+ ", customerName=" + customerName + ", roundTrip=" + roundTrip + ", state=" + state + ", validString="
				+ validString + ", invalidString=" + invalidString + ", createTmString=" + createTmString + "]";
	}

}
