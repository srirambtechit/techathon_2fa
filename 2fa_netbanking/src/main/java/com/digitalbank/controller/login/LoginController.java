package com.digitalbank.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/digitalBank/login", method = { RequestMethod.POST, RequestMethod.GET },produces="application/json")
	public @ResponseBody String userLogin(
			@RequestParam(name = "custNumber", required = false, defaultValue = "1234") String custNumber,
			@RequestParam(name = "custPassword", required = false, defaultValue = "password") String password) {

		if ("2909930000".equals(custNumber) && "123456".equals(password)) {
			return "{\"login\":\"success\",\"custNumber\"," + custNumber + "}";
		}

		else {
			return "{\"login\":\"failure\"}";
		}

		//return "/dashboard.html";
	}

}
