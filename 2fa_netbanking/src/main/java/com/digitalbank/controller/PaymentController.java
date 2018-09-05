package com.digitalbank.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbank.model.AccountPrimaryDetails;
import com.digitalbank.model.PaymentTransaction;
import com.digitalbank.service.AccountService;

@RestController
public class PaymentController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/digitalBank/payment/paypayee", method = RequestMethod.POST, produces = "application/json")
	public Map<String, String> doPayeePayment(@RequestBody PaymentTransaction paymentTransaction) {
		AccountPrimaryDetails accountPrimaryDetails = paymentTransaction.getAccount().getAccountPrimaryDetails();

		return new HashMap<String, String>() {
			{
				put("paymentResponse", accountService.payPayee(paymentTransaction.getAccount().getCustNumber(), accountPrimaryDetails, paymentTransaction.getPaymentAmount()));
			}
		};

	}

	@RequestMapping(value = "/digitalBank/payment/transactionid", produces = "application/json")
	public UUID getPaymentTransactionID() {
		return UUID.randomUUID();
	}
}
