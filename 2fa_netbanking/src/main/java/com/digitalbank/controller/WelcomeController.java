package com.digitalbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/digitalBank")
	public String welcome() {
		return "login.html";
	}
}
