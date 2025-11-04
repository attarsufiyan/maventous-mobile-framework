package TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.dcentmass.maventous_mobile_framework.WelcomePage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import Utils.AppiumUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public WelcomePage welcomepage;

	@BeforeClass
	public void Configuration() throws URISyntaxException, IOException {

		
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String ipaddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		
		
		service=startAppiumServer(ipaddress,Integer.parseInt(port));
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndriodDeviceName"));
		options.setApp(
				System.getProperty("user.dir")+"\\src\\test\\java\\apk\\Maventous.apk");

		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		welcomepage= new WelcomePage(driver);
		
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();
	}

	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);
	}

	public void scrollAtElement(String element) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + element + "\"))"));
	}

	// Swipe from left to right
	public void swipe(WebElement categoriesList) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap<>();
		params.put("elementId", ((RemoteWebElement) categoriesList).getId());
		params.put("direction", "left"); // swipe from left to right
		params.put("percent", 1.0); // how much to swipe (0.0 to 1.0)

		js.executeScript("mobile: swipeGesture", params);
	}

	// Category
	public void scrollAndClickExactByTextHorizontal(String expectedText) {
		// Scroll horizontally so that expectedText is visible
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.sucotech.myapplication.dev:id/categoriesList\")).setAsHorizontalList()"
						+ ".scrollIntoView(new UiSelector().text(\"" + expectedText + "\"))"));

		// Find all visible category elements by their label id and click only the one
		// with exact text
		List<WebElement> categories = driver.findElements(AppiumBy.id("com.sucotech.myapplication.dev:id/label"));
		boolean found = false;
		for (WebElement category : categories) {
			if (category.getText().equals(expectedText)) {
				category.click();
				found = true;
				break;
			}
		}

	}

	// Subcategory
	public void scrollAndClickExactByTextVertical(String expectedText) {
		// Scroll vertically so that expectedText is visible
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.sucotech.myapplication.dev:id/each_cat_rv\")).setAsVerticalList()"
						+ ".scrollIntoView(new UiSelector().text(\"" + expectedText + "\"))"));

		// Find all visible elements by their label id and click only the one with exact
		// text
		List<WebElement> elements = driver.findElements(AppiumBy.id("com.sucotech.myapplication.dev:id/label"));
		boolean found = false;
		for (WebElement el : elements) {
			if (el.getText().equals(expectedText)) {
				el.click();
				found = true;
				break;
			}
		}

	}

	public void scrollAndClickByPartialTextVertical(String partialText) {
		// Scroll vertically inside recyclerView_detail until partialText is visible
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.sucotech.myapplication.dev:id/recyclerView_detail\"))"
						+ ".scrollIntoView(new UiSelector().textContains(\"" + partialText + "\"))"));

		// Find all visible course titles by their resource-id (assumed same, update if
		// different)
		List<WebElement> courses = driver.findElements(AppiumBy.id("com.sucotech.myapplication.dev:id/popular_title"));
		boolean found = false;
		for (WebElement course : courses) {
			if (course.getText().contains(partialText)) {
				course.click();
				found = true;
				break;
			}
		}

	}
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		 
		 
		// System.getProperty("user.dir")+"\\src\\test\\java\\testData\\Ed-Tech.json")
		    // conver json file content to json string
	    String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		  		    ObjectMapper mapper = new ObjectMapper();
		    List<HashMap<String, String>> data = mapper.readValue(jsonContent,
		            new TypeReference<List<HashMap<String, String>>>() {
		            });

		    return data;
		}

}
