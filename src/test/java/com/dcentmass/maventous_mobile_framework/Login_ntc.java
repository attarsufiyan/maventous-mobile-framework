package com.dcentmass.maventous_mobile_framework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestUtils.BaseTest;

public class Login_ntc extends BaseTest {

	@Test(dataProvider = "getData")
	public void invalidlogin(HashMap<String, String> input) {

		welcomepage.clicknextButton();
		welcomepage.clicknextButton();
		SignUpPage signUpPage = welcomepage.clickstartButton();
		SignInPage signInPage = signUpPage.clicksignIn();
		signInPage.enterEmail(input.get("email"));
		signInPage.enterPassword(input.get("pwd"));
		HomePage homepage = signInPage.clickSignIn();
		String msg = homepage.gettoastmsg();		
        Assert.assertEquals(msg, "Invalid credentials. Please try again.");

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\testData\\loginntc.json");
		return new Object[][] { { data.get(0) } };
		
	}

}
