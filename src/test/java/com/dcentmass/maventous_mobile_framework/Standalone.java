package com.dcentmass.maventous_mobile_framework;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Standalone extends BaseTest {

	@Test
	public void Cofiguration() throws MalformedURLException, URISyntaxException, InterruptedException {

//		AppiumDriverLocalService service = new AppiumServiceBuilder()
//				.withAppiumJS(
//						new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
//
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("Maventous APK");
//		options.setApp(
//				"D:\\Maventous API Framework\\maventous_mobile_framework\\src\\test\\java\\resources\\Maventous.apk");
//
//		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

		driver.findElement(AppiumBy.id("com.sucotech.myapplication.dev:id/nextBtn")).click();
		driver.findElement(AppiumBy.id("com.sucotech.myapplication.dev:id/nextBtn")).click();
		driver.findElement(AppiumBy.id("com.sucotech.myapplication.dev:id/startBtn")).click();

		driver.findElement(AppiumBy.id("com.sucotech.myapplication.dev:id/btnSignIn")).click();

		driver.findElement(AppiumBy.id("com.sucotech.myapplication.dev:id/etSignInEmail"))
				.sendKeys("student@student.com");

		driver.findElement(AppiumBy.id("com.sucotech.myapplication.dev:id/etSignInPassword"))
				.sendKeys("studentpassword");
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.sucotech.myapplication.dev:id/buttonSignIn")).click();
		Thread.sleep(4000);

		// scrollAtElement("Popular Teachers");
		// scrollToEndAction();

		driver.findElement(AppiumBy.id("com.sucotech.myapplication.dev:id/nav_fav")).click();
		driver.findElement(AppiumBy.id("com.sucotech.myapplication.dev:id/btnViewCourse")).click();
		String msg = driver.findElement(AppiumBy.id("android:id/message")).getText();
		Assert.assertEquals(msg, "Course available after activation. Please visit our website for more information.");

	}

}
