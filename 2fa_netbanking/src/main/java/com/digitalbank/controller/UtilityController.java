package com.digitalbank.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilityController {

	@RequestMapping(value = "/digitalBank/utility/2FAServiceEndPoint")
	public void set2FAEndPoint(@RequestParam(value = "2FAEndPoint") String twoFAEndPoint) throws IOException {

		try {
			InputStream in = new FileInputStream(
					new File("E:\\Vignesh\\Learnings\\Workspaces\\Net Banking Workspace\\com.digitalbank\\src\\main\\resources\\application.properties"));
			Properties prop = new Properties();
			prop.load(in);
			in.close();

			OutputStream output = new FileOutputStream(
					new File("E:\\Vignesh\\Learnings\\Workspaces\\Net Banking Workspace\\com.digitalbank\\src\\main\\resources\\application.properties"));
			prop.setProperty("rbs.digital.bank.2fa.endpoint", twoFAEndPoint);
			prop.store(output, null);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String get2FAEndPoint() {
		try (InputStream in = new FileInputStream(
				new File("E:\\Vignesh\\Learnings\\Workspaces\\Net Banking Workspace\\com.digitalbank\\src\\main\\resources\\application.properties"))) {
			Properties prop = new Properties();
			prop.load(in);
			return prop.getProperty("rbs.digital.bank.2fa.endpoint");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";

	}

}
