package com.redbus.utils;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.redbus.base.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ExtentReport extends BaseClass {
	
	public static final Logger log = Logger.getLogger(ExtentReport.class);

	// for reports
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	// CREATING THE EXTENT REPORT
	@BeforeSuite
	public void setExtent() {
		extent = new ExtentReports(CommonUtils.prop.getProperty("REPORT_PATH"));
	}

	// TAKING THE SCREENSHOTS FOR FAILED SCENARIOS
	@AfterMethod
	public void attachScreenshot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotPath = Screenshots.takeScreenShot(driver, result.getName());
			System.out.println(screenshotPath);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			log.info("Screenshot captured!! ");

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}
		extent.endTest(extentTest);
	}

	@AfterMethod
	public static void reportclose() {
		extent.endTest(extentTest);	
		log.info("Report Generated");
	}

	// STOP THE REPORT GENERATION
	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}
}
