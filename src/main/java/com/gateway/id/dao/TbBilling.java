package com.gateway.id.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_billing")
public class TbBilling {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "client")
	private String client;

	@Column(name = "partner_code")
	private String partnerCode;

	@Column(name = "partner_name")
	private String partnerName;

	@Column(name = "partner_short_name")
	private String partnerShortName;

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "end_time")
	private Date endTime;

	@Column(name = "bill_title")
	private String billTitle;

	@Column(name = "bill_code")
	private String billCode;

	@Column(name = "next_billing_time")
	private Date nextBillingTime;

	@Column(name = "tax")
	private Integer tax;

	@Column(name = "vat")
	private Integer vat;

	@Column(name = "insurance")
	private Integer insurance;

	@Column(name = "insurance_percentage")
	private Integer insurancePercentage;

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

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPartnerShortName() {
		return partnerShortName;
	}

	public void setPartnerShortName(String partnerShortName) {
		this.partnerShortName = partnerShortName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getBillTitle() {
		return billTitle;
	}

	public void setBillTitle(String billTitle) {
		this.billTitle = billTitle;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public Date getNextBillingTime() {
		return nextBillingTime;
	}

	public void setNextBillingTime(Date nextBillingTime) {
		this.nextBillingTime = nextBillingTime;
	}

	public Integer getTax() {
		return tax;
	}

	public void setTax(Integer tax) {
		this.tax = tax;
	}

	public Integer getVat() {
		return vat;
	}

	public void setVat(Integer vat) {
		this.vat = vat;
	}

	public Integer getInsurance() {
		return insurance;
	}

	public void setInsurance(Integer insurance) {
		this.insurance = insurance;
	}

	public Integer getInsurancePercentage() {
		return insurancePercentage;
	}

	public void setInsurancePercentage(Integer insurancePercentage) {
		this.insurancePercentage = insurancePercentage;
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
		return "TbBilling [id=" + id + ", client=" + client + ", partnerCode=" + partnerCode + ", partnerName="
				+ partnerName + ", partnerShortName=" + partnerShortName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", billTitle=" + billTitle + ", billCode=" + billCode + ", nextBillingTime="
				+ nextBillingTime + ", tax=" + tax + ", vat=" + vat + ", insurance=" + insurance
				+ ", insurancePercentage=" + insurancePercentage + ", createdBy=" + createdBy + ", createdTm="
				+ createdTm + ", modifiedBy=" + modifiedBy + ", modifiedTm=" + modifiedTm + "]";
	}

}
