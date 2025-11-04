package com.dcentmass.maventous_mobile_framework;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidActions {

	AndroidDriver driver;

	HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public String getToastMessage() {

		By toastlocator = By.xpath("(//android.widget.Toast)[1]");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastlocator));

		String text = toastElement.getAttribute("name");
		if (text == null || text.isEmpty()) {
			text = toastElement.getText();
		}
		return text;
	}
	
	public String gettoastmsg() {
		String toastmsg = driver
				.findElement(AppiumBy.xpath("//android.widget.Toast[@text=\"Invalid credentials. Please try again.\"]"))
				.getText();
		return toastmsg;
	    }
	
	

}
