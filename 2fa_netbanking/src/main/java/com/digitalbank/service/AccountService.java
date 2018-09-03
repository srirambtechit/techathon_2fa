package com.digitalbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalbank.model.Account;
import com.digitalbank.repository.AccountRepository;

@Component
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAccountDetails(String custNumber) {
		return accountRepository.findByCustNumber(custNumber);
	}
	
	public Account payPayee(Account account) {
		return accountRepository.save(account);
	}
	
	
}
