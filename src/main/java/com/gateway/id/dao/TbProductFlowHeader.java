package com.gateway.id.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product_flow_header")
public class TbProductFlowHeader {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "customer_code")
	private String customerCode;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "quotation_no")
	private String quotationNo;

	@Column(name = "quotation_desc")
	private String quotationDesc;

	@Column(name = "status")
	private Integer status;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_tm")
	private Date createdTm;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_tm")
	private Date modifiedTm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public String getQuotationDesc() {
		return quotationDesc;
	}

	public void setQuotationDesc(String quotationDesc) {
		this.quotationDesc = quotationDesc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTm() {
		return createdTm;
	}

	public void setCreatedTm(Date createdTm) {
		this.createdTm = createdTm;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedTm() {
		return modifiedTm;
	}

	public void setModifiedTm(Date modifiedTm) {
		this.modifiedTm = modifiedTm;
	}

	@Override
	public String toString() {
		return "TbProductFlowHeader [id=" + id + ", customerCode=" + customerCode + ", customerName=" + customerName
				+ ", quotationNo=" + quotationNo + ", quotationDesc=" + quotationDesc + ", status=" + status
				+ ", createdBy=" + createdBy + ", createdTm=" + createdTm + ", modifiedBy=" + modifiedBy
				+ ", modifiedTm=" + modifiedTm + "]";
	}

}
