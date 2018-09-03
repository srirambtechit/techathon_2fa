package com.digitalbank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AccountPrimaryDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="ACCOUNT_NO")
	private String accNo;
	
	@Column(name="SORT_CODE")
	private String sortCode;
	
	public AccountPrimaryDetails() {
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	
	
}
