package com.digitalbank.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbank.model.Account;
import com.digitalbank.service.AccountService;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class PaymentController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/digitalBank/payment/paypayee")
	public Account doPayeePayment(Account account) {
		return accountService.payPayee(account);
	}

	@RequestMapping(value="/digitalBank/payment/transactionid",produces="application/json")
	public UUID getPaymentTransactionID() {
		return UUID.randomUUID();
	}
}
