package com.digitalbank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalbank.model.Account;
import com.digitalbank.model.AccountPrimaryDetails;
import com.digitalbank.repository.AccountRepository;

@Component
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAccountDetails(String custNumber) {
		return accountRepository.findByCustNumber(custNumber);
	}
	
	@Transactional
	public String payPayee(String custNumber,AccountPrimaryDetails accountPrimaryDetails,Double paymentAmount) {
		
		int updCnt = accountRepository.payPayee(custNumber,accountPrimaryDetails,paymentAmount);
		System.out.println("Updated Count " + updCnt);
		if(updCnt > 0) 
			return "Payment Updated";
		else
			return "Payment Not Updated";
	}
	
	
}
