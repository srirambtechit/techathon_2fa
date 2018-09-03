package com.digitalbank.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_PAYEES")
public class CustomerPayee {
	
	@Column(name="CUST_ID")
	private String custNumber;
	
	@EmbeddedId
	private PayeePrimaryDetails payeePrimaryDetails;
	
	@Column(name="PAYEE_NAME")
	private String payeeName;
	
	public CustomerPayee() {
	}

	public String getCustNumber() {
		return custNumber;
	}

	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}

	public PayeePrimaryDetails getPayeePrimaryDetails() {
		return payeePrimaryDetails;
	}

	public void setPayeePrimaryDetails(PayeePrimaryDetails payeePrimaryDetails) {
		this.payeePrimaryDetails = payeePrimaryDetails;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	
}
