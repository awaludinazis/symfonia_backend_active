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
@Table(name = "eb_customer")
public class EbCustomer {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "modify_tm")
	private Date modifyTm;

	@Column(name = "is_active")
	private Integer isActive;

	@Column(name = "tax")
	private Integer tax;

	@Column(name = "tipe")
	private Integer tipe;

	@Column(name = "price")
	private Integer price;

	@Column(name = "percentage")
	private Double percentage;

	@Transient
	private String state;

	@Transient
	private String startTimeString;

	@Transient
	private String endTimeString;

	@Transient
	private String nextBillTimeString;

	@Column(name = "sa_no")
	private String saNo;

	@Column(name = "request_type")
	private String requestType;

	@Column(name = "partner_bill_code")
	private String partnerBillCode;

	@Column(name = "item_type")
	private String itemType;

	@Column(name = "item_type_others")
	private String itemTypeOthers;

	@Column(name = "comp_name")
	private String compName;

	@Column(name = "comp_id_number")
	private String compIdNumber;

	@Column(name = "comp_industry")
	private String compIndustry;

	@Column(name = "comp_address")
	private String compAddress;

	@Column(name = "comp_phone")
	private String compPhone;

	@Column(name = "comp_no_hp")
	private String compNoHp;

	@Column(name = "personal_name")
	private String personalName;

	@Column(name = "personal_job_title")
	private String personalJobTitle;

	@Column(name = "personal_siup_no")
	private String personalSiupNo;

	@Column(name = "personal_npwp")
	private String personalNpwp;

	@Column(name = "personal_email")
	private String personalEmail;

	@Column(name = "personal_fax_no")
	private String personalFaxNo;

	@Column(name = "personal_address")
	private String personalAddress;

	@Column(name = "cs_name")
	private String csName;

	@Column(name = "cs_address")
	private String csAddress;

	@Column(name = "cs_contact_name")
	private String csContactName;

	@Column(name = "cs_hp")
	private String csHp;

	@Column(name = "cs_email")
	private String csEmail;

	@Column(name = "finance_name")
	private String financeName;

	@Column(name = "finance_address")
	private String financeAddress;

	@Column(name = "finance_contact_name")
	private String financeContactName;

	@Column(name = "finance_hp")
	private String financeHp;

	@Column(name = "finance_email")
	private String financeEmail;

	@Column(name = "service_profile")
	private String serviceProfile;

	@Column(name = "pickup_address")
	private String pickupAddress;

	@Column(name = "payment_surcharge")
	private String paymentSurcharge;

	@Column(name = "payment_billing_cycle")
	private String paymentBillingCycle;

	@Column(name = "payment_term_of_payment")
	private String paymentTermOfPayment;

	@Column(name = "doc_company")
	private String docCompany;

	@Column(name = "doc_personel")
	private String docPersonel;

	@Column(name = "sign_sales_name	")
	private String signSalesName;

	@Column(name = "sign_sales_date")
	private Date signSalesDate;

	@Column(name = "sign_vp_sales_name")
	private String signVpSalesName;

	@Column(name = "sign_vp_sales_date")
	private Date signVpSalesDate;

	@Column(name = "sign_finance_name")
	private String signFinanceName;

	@Column(name = "sign_finance_date")
	private Date signFinanceDate;

	@Column(name = "sign_vp_finance_name")
	private String signVpFinanceName;

	@Column(name = "sign_vp_finance_date")
	private Date signVpFinanceDate;

	@Column(name = "partner_sign_date")
	private Date partnerSignDate;

	@Column(name = "status")
	private String status;

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

	public Integer getTax() {
		return tax;
	}

	public void setTax(Integer tax) {
		this.tax = tax;
	}

	public Integer getTipe() {
		return tipe;
	}

	public void setTipe(Integer tipe) {
		this.tipe = tipe;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStartTimeString() {
		return startTimeString;
	}

	public void setStartTimeString(String startTimeString) {
		this.startTimeString = startTimeString;
	}

	public String getEndTimeString() {
		return endTimeString;
	}

	public void setEndTimeString(String endTimeString) {
		this.endTimeString = endTimeString;
	}

	public String getNextBillTimeString() {
		return nextBillTimeString;
	}

	public void setNextBillTimeString(String nextBillTimeString) {
		this.nextBillTimeString = nextBillTimeString;
	}

	public String getSaNo() {
		return saNo;
	}

	public void setSaNo(String saNo) {
		this.saNo = saNo;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getPartnerBillCode() {
		return partnerBillCode;
	}

	public void setPartnerBillCode(String partnerBillCode) {
		this.partnerBillCode = partnerBillCode;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemTypeOthers() {
		return itemTypeOthers;
	}

	public void setItemTypeOthers(String itemTypeOthers) {
		this.itemTypeOthers = itemTypeOthers;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompIdNumber() {
		return compIdNumber;
	}

	public void setCompIdNumber(String compIdNumber) {
		this.compIdNumber = compIdNumber;
	}

	public String getCompIndustry() {
		return compIndustry;
	}

	public void setCompIndustry(String compIndustry) {
		this.compIndustry = compIndustry;
	}

	public String getCompAddress() {
		return compAddress;
	}

	public void setCompAddress(String compAddress) {
		this.compAddress = compAddress;
	}

	public String getCompPhone() {
		return compPhone;
	}

	public void setCompPhone(String compPhone) {
		this.compPhone = compPhone;
	}

	public String getCompNoHp() {
		return compNoHp;
	}

	public void setCompNoHp(String compNoHp) {
		this.compNoHp = compNoHp;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getPersonalJobTitle() {
		return personalJobTitle;
	}

	public void setPersonalJobTitle(String personalJobTitle) {
		this.personalJobTitle = personalJobTitle;
	}

	public String getPersonalSiupNo() {
		return personalSiupNo;
	}

	public void setPersonalSiupNo(String personalSiupNo) {
		this.personalSiupNo = personalSiupNo;
	}

	public String getPersonalNpwp() {
		return personalNpwp;
	}

	public void setPersonalNpwp(String personalNpwp) {
		this.personalNpwp = personalNpwp;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getPersonalFaxNo() {
		return personalFaxNo;
	}

	public void setPersonalFaxNo(String personalFaxNo) {
		this.personalFaxNo = personalFaxNo;
	}

	public String getPersonalAddress() {
		return personalAddress;
	}

	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public String getCsAddress() {
		return csAddress;
	}

	public void setCsAddress(String csAddress) {
		this.csAddress = csAddress;
	}

	public String getCsContactName() {
		return csContactName;
	}

	public void setCsContactName(String csContactName) {
		this.csContactName = csContactName;
	}

	public String getCsHp() {
		return csHp;
	}

	public void setCsHp(String csHp) {
		this.csHp = csHp;
	}

	public String getCsEmail() {
		return csEmail;
	}

	public void setCsEmail(String csEmail) {
		this.csEmail = csEmail;
	}

	public String getFinanceName() {
		return financeName;
	}

	public void setFinanceName(String financeName) {
		this.financeName = financeName;
	}

	public String getFinanceAddress() {
		return financeAddress;
	}

	public void setFinanceAddress(String financeAddress) {
		this.financeAddress = financeAddress;
	}

	public String getFinanceContactName() {
		return financeContactName;
	}

	public void setFinanceContactName(String financeContactName) {
		this.financeContactName = financeContactName;
	}

	public String getFinanceHp() {
		return financeHp;
	}

	public void setFinanceHp(String financeHp) {
		this.financeHp = financeHp;
	}

	public String getFinanceEmail() {
		return financeEmail;
	}

	public void setFinanceEmail(String financeEmail) {
		this.financeEmail = financeEmail;
	}

	public String getServiceProfile() {
		return serviceProfile;
	}

	public void setServiceProfile(String serviceProfile) {
		this.serviceProfile = serviceProfile;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getPaymentSurcharge() {
		return paymentSurcharge;
	}

	public void setPaymentSurcharge(String paymentSurcharge) {
		this.paymentSurcharge = paymentSurcharge;
	}

	public String getPaymentBillingCycle() {
		return paymentBillingCycle;
	}

	public void setPaymentBillingCycle(String paymentBillingCycle) {
		this.paymentBillingCycle = paymentBillingCycle;
	}

	public String getPaymentTermOfPayment() {
		return paymentTermOfPayment;
	}

	public void setPaymentTermOfPayment(String paymentTermOfPayment) {
		this.paymentTermOfPayment = paymentTermOfPayment;
	}

	public String getDocCompany() {
		return docCompany;
	}

	public void setDocCompany(String docCompany) {
		this.docCompany = docCompany;
	}

	public String getDocPersonel() {
		return docPersonel;
	}

	public void setDocPersonel(String docPersonel) {
		this.docPersonel = docPersonel;
	}

	public String getSignSalesName() {
		return signSalesName;
	}

	public void setSignSalesName(String signSalesName) {
		this.signSalesName = signSalesName;
	}

	public Date getSignSalesDate() {
		return signSalesDate;
	}

	public void setSignSalesDate(Date signSalesDate) {
		this.signSalesDate = signSalesDate;
	}

	public String getSignVpSalesName() {
		return signVpSalesName;
	}

	public void setSignVpSalesName(String signVpSalesName) {
		this.signVpSalesName = signVpSalesName;
	}

	public Date getSignVpSalesDate() {
		return signVpSalesDate;
	}

	public void setSignVpSalesDate(Date signVpSalesDate) {
		this.signVpSalesDate = signVpSalesDate;
	}

	public String getSignFinanceName() {
		return signFinanceName;
	}

	public void setSignFinanceName(String signFinanceName) {
		this.signFinanceName = signFinanceName;
	}

	public Date getSignFinanceDate() {
		return signFinanceDate;
	}

	public void setSignFinanceDate(Date signFinanceDate) {
		this.signFinanceDate = signFinanceDate;
	}

	public String getSignVpFinanceName() {
		return signVpFinanceName;
	}

	public void setSignVpFinanceName(String signVpFinanceName) {
		this.signVpFinanceName = signVpFinanceName;
	}

	public Date getSignVpFinanceDate() {
		return signVpFinanceDate;
	}

	public void setSignVpFinanceDate(Date signVpFinanceDate) {
		this.signVpFinanceDate = signVpFinanceDate;
	}

	public Date getPartnerSignDate() {
		return partnerSignDate;
	}

	public void setPartnerSignDate(Date partnerSignDate) {
		this.partnerSignDate = partnerSignDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EbCustomer [ebCustomerId=" + ebCustomerId + ", customerCode=" + customerCode + ", customerCodeParent="
				+ customerCodeParent + ", customerFullname=" + customerFullname + ", customerShortname="
				+ customerShortname + ", customerCoprName=" + customerCoprName + ", customerCoprAdd=" + customerCoprAdd
				+ ", customerBusiness=" + customerBusiness + ", reconciliationName=" + reconciliationName
				+ ", reconciliationHp=" + reconciliationHp + ", reconciliationTel=" + reconciliationTel
				+ ", reconciliationEmail=" + reconciliationEmail + ", reconciliationAdd=" + reconciliationAdd
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", lastBillTm=" + lastBillTm + ", nextBillTm="
				+ nextBillTm + ", payCycle=" + payCycle + ", billTitle=" + billTitle + ", billCode=" + billCode
				+ ", vat=" + vat + ", modifyTm=" + modifyTm + ", isActive=" + isActive + ", tax=" + tax + ", tipe="
				+ tipe + ", price=" + price + ", percentage=" + percentage + ", state=" + state + ", startTimeString="
				+ startTimeString + ", endTimeString=" + endTimeString + ", nextBillTimeString=" + nextBillTimeString
				+ ", saNo=" + saNo + ", requestType=" + requestType + ", partnerBillCode=" + partnerBillCode
				+ ", itemType=" + itemType + ", itemTypeOthers=" + itemTypeOthers + ", compName=" + compName
				+ ", compIdNumber=" + compIdNumber + ", compIndustry=" + compIndustry + ", compAddress=" + compAddress
				+ ", compPhone=" + compPhone + ", compNoHp=" + compNoHp + ", personalName=" + personalName
				+ ", personalJobTitle=" + personalJobTitle + ", personalSiupNo=" + personalSiupNo + ", personalNpwp="
				+ personalNpwp + ", personalEmail=" + personalEmail + ", personalFaxNo=" + personalFaxNo
				+ ", personalAddress=" + personalAddress + ", csName=" + csName + ", csAddress=" + csAddress
				+ ", csContactName=" + csContactName + ", csHp=" + csHp + ", csEmail=" + csEmail + ", financeName="
				+ financeName + ", financeAddress=" + financeAddress + ", financeContactName=" + financeContactName
				+ ", financeHp=" + financeHp + ", financeEmail=" + financeEmail + ", serviceProfile=" + serviceProfile
				+ ", pickupAddress=" + pickupAddress + ", paymentSurcharge=" + paymentSurcharge
				+ ", paymentBillingCycle=" + paymentBillingCycle + ", paymentTermOfPayment=" + paymentTermOfPayment
				+ ", docCompany=" + docCompany + ", docPersonel=" + docPersonel + ", signSalesName=" + signSalesName
				+ ", signSalesDate=" + signSalesDate + ", signVpSalesName=" + signVpSalesName + ", signVpSalesDate="
				+ signVpSalesDate + ", signFinanceName=" + signFinanceName + ", signFinanceDate=" + signFinanceDate
				+ ", signVpFinanceName=" + signVpFinanceName + ", signVpFinanceDate=" + signVpFinanceDate
				+ ", partnerSignDate=" + partnerSignDate + ", status=" + status + "]";
	}
	
	

}
