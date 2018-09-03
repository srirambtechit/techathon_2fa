package com.digitalbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalbank.model.CustomerPayee;
import com.digitalbank.repository.PayeeRepository;

@Component
public class CustomerPayeeService {

	@Autowired
	private PayeeRepository payeeRepository;

	public List<CustomerPayee> getPayeeDetails(String custNumber) {
		return payeeRepository.findByCustNumber(custNumber);
	}
	
	
}
