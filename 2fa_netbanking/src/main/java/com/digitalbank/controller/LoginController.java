package com.digitalbank.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/digitalBank/login", method = { RequestMethod.POST, RequestMethod.GET }, produces = "application/json")
	public @ResponseBody Map<String, String> userLogin(@RequestParam(name = "custNumber", required = false, defaultValue = "1234") String custNumber,
			@RequestParam(name = "custPassword", required = false, defaultValue = "password") String password) {

		if ("2909930000".equals(custNumber) && "123456".equals(password)) {
			return new HashMap<String, String>() {
				{
					put("login", "success");
				}
			};
		}

		if ("2909930001".equals(custNumber) && "1234567".equals(password)) {
			return new HashMap<String, String>() {
				{
					put("login", "success");
				}
			};
		}

		else {
			return new HashMap<String, String>() {
				{
					put("login", "success");
				}
			};
		}

	}

	@RequestMapping(value = "/digitalBank/dashboard", method = { RequestMethod.POST, RequestMethod.GET }, produces = "text/html")
	public String showDashBoard(ModelMap model, @RequestParam(name = "custNumber", required = false, defaultValue = "1234") String custNumber) {

		model.put("custNumber", custNumber);
		model.put("twoFAEndPoint",UtilityController.get2FAEndPoint());
		return "/WEB-INF/jsp/dashboard.jsp";

	}

}
