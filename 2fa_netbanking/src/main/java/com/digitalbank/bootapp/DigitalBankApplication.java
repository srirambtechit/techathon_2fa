package com.digitalbank.bootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.digitalbank","com.digitalbank.controller.welcome","com.digitalbank.controller.login"})
public class DigitalBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankApplication.class, args);
	}
}
