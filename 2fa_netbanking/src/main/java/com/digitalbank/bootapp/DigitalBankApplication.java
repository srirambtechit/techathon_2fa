package com.digitalbank.bootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.digitalbank", "com.digitalbank.controller", "com.digitalbank.controller.welcome", "com.digitalbank.controller.login",
		"com.digitalbank.controller.account", "com.digitalbank.model", "com.digitalbank.repository", "com.digitalbank.service" })
@EnableJpaRepositories(basePackages = { "com.digitalbank", "com.digitalbank.controller", "com.digitalbank.controller.welcome", "com.digitalbank.controller.login",
		"com.digitalbank.controller.account", "com.digitalbank.model", "com.digitalbank.repository", "com.digitalbank.service" })
@EntityScan(basePackages = { "com.digitalbank", "com.digitalbank.controller", "com.digitalbank.controller.welcome", "com.digitalbank.controller.login",
		"com.digitalbank.controller.account", "com.digitalbank.model", "com.digitalbank.repository", "com.digitalbank.service" })
public class DigitalBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankApplication.class, args);
	}
}
