package com.digitalbank.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Column(name="CUST_ID")
	private String custNumber;
	
	@Column(name="ACCOUNT_NAME")
	private String accName;
	
	@EmbeddedId
	private AccountPrimaryDetails accountPrimaryDetails;
	
	@Column(name="BALANCE")
	private double accBalance;
	
	public Account() {
	}

	public String getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public AccountPrimaryDetails getAccountPrimaryDetails() {
		return accountPrimaryDetails;
	}

	public void setAccountPrimaryDetails(AccountPrimaryDetails accountPrimaryDetails) {
		this.accountPrimaryDetails = accountPrimaryDetails;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	
	
	

}
