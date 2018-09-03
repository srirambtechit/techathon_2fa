package com.digitalbank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbank.model.Account;
import com.digitalbank.model.Customer;
import com.digitalbank.model.CustomerPayee;
import com.digitalbank.service.AccountService;
import com.digitalbank.service.CustomerPayeeService;
import com.digitalbank.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerPayeeService customerPayeeService;

	@GetMapping("/digitalBank/customer")
	public Optional<Customer> getCustomerDetails(@RequestParam(name = "custNumber") String custNumber) {
		return customerService.getCustomerDetails(custNumber);
	}

	@GetMapping("/digitalBank/customer/accounts")
	public List<Account> getAccountDetails(@RequestParam(name = "custNumber") String custNumber) {
		return accountService.getAccountDetails(custNumber);
	}
	
	@GetMapping("/digitalBank/customer/payees")
	public List<CustomerPayee> getPayeeDetails(@RequestParam(name="custNumber") String custNumber) {
		return customerPayeeService.getPayeeDetails(custNumber);
	}

}
