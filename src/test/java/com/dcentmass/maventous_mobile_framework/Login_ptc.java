package com.dcentmass.maventous_mobile_framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestUtils.BaseTest;

public class Login_ptc extends BaseTest {

	@Test(dataProvider = "getData",groups= {"Smoke"})
	public void validLogin(HashMap<String, String> input)
			throws MalformedURLException, URISyntaxException, InterruptedException {

		welcomepage.clicknextButton();
		welcomepage.clicknextButton();
		SignUpPage signUpPage = welcomepage.clickstartButton();
		SignInPage signInPage = signUpPage.clicksignIn();
		signInPage.enterEmail(input.get("email"));
		signInPage.enterPassword(input.get("pwd"));
		HomePage homepage = signInPage.clickSignIn();
		String message = homepage.getToastMessage();
		Assert.assertEquals(message, "Signin Success. You are in a free trial period");

	}

//	@BeforeMethod
//	public void preSetup() {
//
//		welcomepage.setActivity();
//
//	}

	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\Ed-Tech.json");
		return new Object[][] { { data.get(0) }
				 };
	}


}
