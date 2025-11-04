package com.dcentmass.maventous_mobile_framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage {
	
	AndroidDriver driver;
	HomePage homepage;
	private AndroidActions androidActions;
	
	SignInPage(AndroidDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id = "com.sucotech.myapplication.dev:id/etSignInEmail")
	private WebElement email;
	
	@AndroidFindBy(id = "com.sucotech.myapplication.dev:id/etSignInPassword")
	private WebElement password;
	
	@AndroidFindBy(id = "com.sucotech.myapplication.dev:id/buttonSignIn")
	private WebElement signIn;
	
	
	
	public void enterEmail(String emails) {

		email.sendKeys(emails);
	}
	
	public void enterPassword(String  pwd) {
		
		password.sendKeys(pwd);
	}
	
	public HomePage clickSignIn() {
		signIn.click();
		return new HomePage(driver);
		
	}
	
	
	
	
	
	public String gettoastmsg() {
	String toastmsg = driver
			.findElement(AppiumBy.xpath("//android.widget.Toast[@text=\"Invalid credentials. Please try again.\"]"))
			.getText();
	return toastmsg;
    }
}
	
	
	


