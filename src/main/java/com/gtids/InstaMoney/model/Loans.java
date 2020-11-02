package com.gtids.InstaMoney.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.Table;


@Entity
@Table(name="loans")
public class Loans {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date PostingDate;
	@Column(unique = true)
	@NotNull(message = "uniqueId must be required")
	private String uniqueId;
	@NotNull(message = "Bankmitra Name must be required")
	private String bankmitra_name;
	@NotNull(message = "Bankmitra Id must be required")
	private String bankmitra_id;
	@NotNull(message = "Bankmitra Contactno must be required")
	private String bankmitra_contactno;
	@NotNull(message = "Beneficiary Name must be required")
	private String beneficiary_name;
	@NotNull(message = "Beneficiary Phn must be required")
	private String beneficiary_phn;
	@NotNull(message = "Beneficiary Accno must be required")
	private String beneficiary_accno;
	@NotNull(message = "NearestAPGVBBank must be required")
	private String NearestAPGVBBank;
	@NotNull(message = "Beneficiary Lineofactivity must be required")
	private String beneficiary_lineofactivity;
	@NotNull(message = "Beneficiary Fatherhusband must be required")
	private String beneficiary_fatherhusband;
	@NotNull(message = "Beneficiary Dob must be required")
	private String beneficiary_dob;
	@NotNull(message = "Beneficiary Aadhaarno must be required")
	private String beneficiary_aadhaarno;
	@NotNull(message = "Beneficiary Pancard must be required")
	private String beneficiary_pancard;
	@NotNull(message = "Beneficiary Resaddress must be required")
	private String beneficiary_resaddress;
	@NotNull(message = "Business Proname must be required")
	private String business_proname;
	@NotNull(message = "Beneficiary Businessexistence must be required")
	private String beneficiary_businessexistence;
	@NotNull(message = "Beneficiary Education must be required")
	private String beneficiary_education;
	@NotNull(message = "Beneficiary Category must be required")
	private String beneficiary_category;
	@NotNull(message = "Beneficiary Family Child must be required")
	private String beneficiary_family_child;
	@NotNull(message = "Beneficiary Family Adult must be required")
	private String beneficiary_family_adult;
	@NotNull(message = "Beneficiary Sustenance must be required")
	private String beneficiary_sustenance;
	@NotNull(message = "Beneficiary Purpose must be required")
	private String beneficiary_purpose;
	@NotNull(message = "Beneficiary Termloan must be required")
	private String beneficiary_termloan;
	@NotNull(message = "Beneficiary Tenor must be required")
	private String beneficiary_tenor;
	@NotNull(message = "Existing Apgvb Loan must be required")
	private String existing_apgvb_loan;
	@NotNull(message = "Existing Otherbank Loans must be required")
	private String existing_otherbank_loans;
	@NotNull(message = "Own property must be required")
	private String own_property;
	@NotNull(message = "Status must be required")
	private String Status;
	@NotNull(message = "Is_Read must be required")
	private String Is_Read;
	private String remark;
	private String id_details;
	private String conductedon;
	private String conductedby;
	private String observation;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getPostingDate() {
		return PostingDate;
	}
	public void setPostingDate(Date postingDate) {
		PostingDate = postingDate;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getBankmitra_name() {
		return bankmitra_name;
	}
	public void setBankmitra_name(String bankmitra_name) {
		this.bankmitra_name = bankmitra_name;
	}
	public String getBankmitra_id() {
		return bankmitra_id;
	}
	public void setBankmitra_id(String bankmitra_id) {
		this.bankmitra_id = bankmitra_id;
	}
	public String getBankmitra_contactno() {
		return bankmitra_contactno;
	}
	public void setBankmitra_contactno(String bankmitra_contactno) {
		this.bankmitra_contactno = bankmitra_contactno;
	}
	public String getBeneficiary_name() {
		return beneficiary_name;
	}
	public void setBeneficiary_name(String beneficiary_name) {
		this.beneficiary_name = beneficiary_name;
	}
	public String getBeneficiary_phn() {
		return beneficiary_phn;
	}
	public void setBeneficiary_phn(String beneficiary_phn) {
		this.beneficiary_phn = beneficiary_phn;
	}
	public String getBeneficiary_accno() {
		return beneficiary_accno;
	}
	public void setBeneficiary_accno(String beneficiary_accno) {
		this.beneficiary_accno = beneficiary_accno;
	}
	public String getNearestAPGVBBank() {
		return NearestAPGVBBank;
	}
	public void setNearestAPGVBBank(String nearestAPGVBBank) {
		NearestAPGVBBank = nearestAPGVBBank;
	}
	public String getBeneficiary_lineofactivity() {
		return beneficiary_lineofactivity;
	}
	public void setBeneficiary_lineofactivity(String beneficiary_lineofactivity) {
		this.beneficiary_lineofactivity = beneficiary_lineofactivity;
	}
	public String getBeneficiary_fatherhusband() {
		return beneficiary_fatherhusband;
	}
	public void setBeneficiary_fatherhusband(String beneficiary_fatherhusband) {
		this.beneficiary_fatherhusband = beneficiary_fatherhusband;
	}
	public String getBeneficiary_dob() {
		return beneficiary_dob;
	}
	public void setBeneficiary_dob(String beneficiary_dob) {
		this.beneficiary_dob = beneficiary_dob;
	}
	public String getBeneficiary_aadhaarno() {
		return beneficiary_aadhaarno;
	}
	public void setBeneficiary_aadhaarno(String beneficiary_aadhaarno) {
		this.beneficiary_aadhaarno = beneficiary_aadhaarno;
	}
	public String getBeneficiary_pancard() {
		return beneficiary_pancard;
	}
	public void setBeneficiary_pancard(String beneficiary_pancard) {
		this.beneficiary_pancard = beneficiary_pancard;
	}
	public String getBeneficiary_resaddress() {
		return beneficiary_resaddress;
	}
	public void setBeneficiary_resaddress(String beneficiary_resaddress) {
		this.beneficiary_resaddress = beneficiary_resaddress;
	}
	public String getBusiness_proname() {
		return business_proname;
	}
	public void setBusiness_proname(String business_proname) {
		this.business_proname = business_proname;
	}
	public String getBeneficiary_businessexistence() {
		return beneficiary_businessexistence;
	}
	public void setBeneficiary_businessexistence(String beneficiary_businessexistence) {
		this.beneficiary_businessexistence = beneficiary_businessexistence;
	}
	public String getBeneficiary_education() {
		return beneficiary_education;
	}
	public void setBeneficiary_education(String beneficiary_education) {
		this.beneficiary_education = beneficiary_education;
	}
	public String getBeneficiary_category() {
		return beneficiary_category;
	}
	public void setBeneficiary_category(String beneficiary_category) {
		this.beneficiary_category = beneficiary_category;
	}
	public String getBeneficiary_family_child() {
		return beneficiary_family_child;
	}
	public void setBeneficiary_family_child(String beneficiary_family_child) {
		this.beneficiary_family_child = beneficiary_family_child;
	}
	public String getBeneficiary_family_adult() {
		return beneficiary_family_adult;
	}
	public void setBeneficiary_family_adult(String beneficiary_family_adult) {
		this.beneficiary_family_adult = beneficiary_family_adult;
	}
	public String getBeneficiary_sustenance() {
		return beneficiary_sustenance;
	}
	public void setBeneficiary_sustenance(String beneficiary_sustenance) {
		this.beneficiary_sustenance = beneficiary_sustenance;
	}
	public String getBeneficiary_purpose() {
		return beneficiary_purpose;
	}
	public void setBeneficiary_purpose(String beneficiary_purpose) {
		this.beneficiary_purpose = beneficiary_purpose;
	}
	public String getBeneficiary_termloan() {
		return beneficiary_termloan;
	}
	public void setBeneficiary_termloan(String beneficiary_termloan) {
		this.beneficiary_termloan = beneficiary_termloan;
	}
	public String getBeneficiary_tenor() {
		return beneficiary_tenor;
	}
	public void setBeneficiary_tenor(String beneficiary_tenor) {
		this.beneficiary_tenor = beneficiary_tenor;
	}
	public String getExisting_apgvb_loan() {
		return existing_apgvb_loan;
	}
	public void setExisting_apgvb_loan(String existing_apgvb_loan) {
		this.existing_apgvb_loan = existing_apgvb_loan;
	}
	public String getExisting_otherbank_loans() {
		return existing_otherbank_loans;
	}
	public void setExisting_otherbank_loans(String existing_otherbank_loans) {
		this.existing_otherbank_loans = existing_otherbank_loans;
	}
	public String getOwn_property() {
		return own_property;
	}
	public void setOwn_property(String own_property) {
		this.own_property = own_property;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getIs_Read() {
		return Is_Read;
	}
	public void setIs_Read(String is_Read) {
		Is_Read = is_Read;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getId_details() {
		return id_details;
	}
	public void setId_details(String id_details) {
		this.id_details = id_details;
	}
	public String getConductedon() {
		return conductedon;
	}
	public void setConductedon(String conductedon) {
		this.conductedon = conductedon;
	}
	public String getConductedby() {
		return conductedby;
	}
	public void setConductedby(String conductedby) {
		this.conductedby = conductedby;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	

}
