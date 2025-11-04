package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent ;
	
	public static  ExtentReports getReport() {
	
		String path = System.getProperty("user.dir")+"\\reports\\index.html";		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Maventous Mobile Automation Test Report");
		reporter.config().setDocumentTitle("Login Test Result");
		
	    extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sufiyan Attar");
		return extent;
		
		
		
		
	}
	

}
