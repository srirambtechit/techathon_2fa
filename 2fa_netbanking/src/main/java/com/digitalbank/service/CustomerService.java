package com.digitalbank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalbank.model.Customer;
import com.digitalbank.repository.CustomerRepository;

@Component
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Optional<Customer> getCustomerDetails(String custNumber) {
		return customerRepository.findById(custNumber);
	}
	
	
}
