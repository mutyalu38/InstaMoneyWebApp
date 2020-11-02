package com.gtids.InstaMoney.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tblbankadmin")
public class TblBankAdmin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

//	auto_increment
	// @Column( name = "\"userName\"")
	@NotNull(message = "UserName must be required")
	@NotEmpty(message = "UserName must be required")
	private String UserName;
	// @Column(name = "password")
	@NotNull(message = "Password must be required")
	@NotEmpty(message = "Password must be required")
	private String Password;
	private String mobile;
	private String session;
	private String branch;

	@Temporal(TemporalType.TIMESTAMP)
	private Date UpdationDate;
	public Date getUpdationDate() {
		return UpdationDate;
	}

	public void setUpdationDate(Date updationDate) {
		UpdationDate = updationDate;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public String getSession() {
		return session;
	}

	public String getBranch() {
		return branch;
	}

//	UpdationDate;
//	timestamp
//	NO
//	current_timestamp()
//	on update current_timestamp()
//	Query results operations

}
