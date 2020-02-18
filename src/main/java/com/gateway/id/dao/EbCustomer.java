package com.gateway.id.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eb_customer")
public class EbCustomer {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eb_customer_id", nullable = false)
	private Long ebCustomerId;

	@Column(name = "customer_code")
	private String customerCode;

	@Column(name = "customer_code_parent")
	private String customerCodeParent;

	@Column(name = "customer_fullname")
	private String customerFullname;

	@Column(name = "customer_shortname")
	private String customerShortname;

	@Column(name = "customer_copr_name")
	private String customerCoprName;

	@Column(name = "customer_copr_add")
	private String customerCoprAdd;

	@Column(name = "customer_business")
	private String customerBusiness;

	@Column(name = "reconciliation_name")
	private String reconciliationName;

	@Column(name = "reconciliation_hp")
	private String reconciliationHp;

	@Column(name = "reconciliation_tel")
	private String reconciliationTel;

	@Column(name = "reconciliation_email")
	private String reconciliationEmail;

	@Column(name = "finance_anteraja_email")
	private String financeAnterajaEmail;

	@Column(name = "reconciliation_add")
	private String reconciliationAdd;

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "end_time")
	private Date endTime;

	@Column(name = "last_bill_tm")
	private Date lastBillTm;

	@Column(name = "next_bill_tm")
	private Date nextBillTm;

	@Column(name = "pay_cycle")
	private Integer payCycle;

	@Column(name = "bill_title")
	private Integer billTitle;

	@Column(name = "bill_code")
	private String billCode;

	@Column(name = "vat")
	private Integer vat;

	@Column(name = "wht23")
	private Integer wht23;

	@Column(name = "source")
	private String source;

	@Column(name = "source_code")
	private String sourceCode;

	@Column(name = "modify_tm")
	private Date modifyTm;

	@Column(name = "is_active")
	private Integer isActive;

	@Column(name = "logout_time")
	private Date logoutTime;

	public Long getEbCustomerId() {
		return ebCustomerId;
	}

	public void setEbCustomerId(Long ebCustomerId) {
		this.ebCustomerId = ebCustomerId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerCodeParent() {
		return customerCodeParent;
	}

	public void setCustomerCodeParent(String customerCodeParent) {
		this.customerCodeParent = customerCodeParent;
	}

	public String getCustomerFullname() {
		return customerFullname;
	}

	public void setCustomerFullname(String customerFullname) {
		this.customerFullname = customerFullname;
	}

	public String getCustomerShortname() {
		return customerShortname;
	}

	public void setCustomerShortname(String customerShortname) {
		this.customerShortname = customerShortname;
	}

	public String getCustomerCoprName() {
		return customerCoprName;
	}

	public void setCustomerCoprName(String customerCoprName) {
		this.customerCoprName = customerCoprName;
	}

	public String getCustomerCoprAdd() {
		return customerCoprAdd;
	}

	public void setCustomerCoprAdd(String customerCoprAdd) {
		this.customerCoprAdd = customerCoprAdd;
	}

	public String getCustomerBusiness() {
		return customerBusiness;
	}

	public void setCustomerBusiness(String customerBusiness) {
		this.customerBusiness = customerBusiness;
	}

	public String getReconciliationName() {
		return reconciliationName;
	}

	public void setReconciliationName(String reconciliationName) {
		this.reconciliationName = reconciliationName;
	}

	public String getReconciliationHp() {
		return reconciliationHp;
	}

	public void setReconciliationHp(String reconciliationHp) {
		this.reconciliationHp = reconciliationHp;
	}

	public String getReconciliationTel() {
		return reconciliationTel;
	}

	public void setReconciliationTel(String reconciliationTel) {
		this.reconciliationTel = reconciliationTel;
	}

	public String getReconciliationEmail() {
		return reconciliationEmail;
	}

	public void setReconciliationEmail(String reconciliationEmail) {
		this.reconciliationEmail = reconciliationEmail;
	}

	public String getFinanceAnterajaEmail() {
		return financeAnterajaEmail;
	}

	public void setFinanceAnterajaEmail(String financeAnterajaEmail) {
		this.financeAnterajaEmail = financeAnterajaEmail;
	}

	public String getReconciliationAdd() {
		return reconciliationAdd;
	}

	public void setReconciliationAdd(String reconciliationAdd) {
		this.reconciliationAdd = reconciliationAdd;
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

	public Date getLastBillTm() {
		return lastBillTm;
	}

	public void setLastBillTm(Date lastBillTm) {
		this.lastBillTm = lastBillTm;
	}

	public Date getNextBillTm() {
		return nextBillTm;
	}

	public void setNextBillTm(Date nextBillTm) {
		this.nextBillTm = nextBillTm;
	}

	public Integer getPayCycle() {
		return payCycle;
	}

	public void setPayCycle(Integer payCycle) {
		this.payCycle = payCycle;
	}

	public Integer getBillTitle() {
		return billTitle;
	}

	public void setBillTitle(Integer billTitle) {
		this.billTitle = billTitle;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public Integer getVat() {
		return vat;
	}

	public void setVat(Integer vat) {
		this.vat = vat;
	}

	public Integer getWht23() {
		return wht23;
	}

	public void setWht23(Integer wht23) {
		this.wht23 = wht23;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public Date getModifyTm() {
		return modifyTm;
	}

	public void setModifyTm(Date modifyTm) {
		this.modifyTm = modifyTm;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	@Override
	public String toString() {
		return "EbCustomer [ebCustomerId=" + ebCustomerId + ", customerCode=" + customerCode + ", customerCodeParent="
				+ customerCodeParent + ", customerFullname=" + customerFullname + ", customerShortname="
				+ customerShortname + ", customerCoprName=" + customerCoprName + ", customerCoprAdd=" + customerCoprAdd
				+ ", customerBusiness=" + customerBusiness + ", reconciliationName=" + reconciliationName
				+ ", reconciliationHp=" + reconciliationHp + ", reconciliationTel=" + reconciliationTel
				+ ", reconciliationEmail=" + reconciliationEmail + ", financeAnterajaEmail=" + financeAnterajaEmail
				+ ", reconciliationAdd=" + reconciliationAdd + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", lastBillTm=" + lastBillTm + ", nextBillTm=" + nextBillTm + ", payCycle=" + payCycle
				+ ", billTitle=" + billTitle + ", billCode=" + billCode + ", vat=" + vat + ", wht23=" + wht23
				+ ", source=" + source + ", sourceCode=" + sourceCode + ", modifyTm=" + modifyTm + ", isActive="
				+ isActive + ", logoutTime=" + logoutTime + "]";
	}

}
