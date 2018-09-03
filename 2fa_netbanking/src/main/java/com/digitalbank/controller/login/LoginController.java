package com.digitalbank.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(value="/digitalBank/login",method= {RequestMethod.POST,RequestMethod.GET})
	public String userLogin(@RequestParam(name="custNumber",required=false,defaultValue="1234") String custNumber,@RequestParam(name="custPassword",required=false,defaultValue="password") String password) {
		return "/dashboard.html";
	}
	

}
