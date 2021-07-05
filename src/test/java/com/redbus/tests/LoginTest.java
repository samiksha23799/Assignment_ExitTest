package com.redbus.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.redbus.pages.LoginPage;
import com.redbus.testUtils.CommonAssertions;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends ExtentReport {

	public static final Logger log = Logger.getLogger(LoginTest.class);

	private String sheetName = "LoginData";

	

	@Test
	public void invalid_login_PhoneNumber() throws InterruptedException {
		log.info("Valid Test: When User login by entering the wrong phonenumber");
		extentTest = extent.startTest("Invalid scenario:  When User login by entering the wrong phonenumber ");

		LoginPage login = new LoginPage(driver);
		String testName = "Invalid Scenario- Wrong phone number";

		login.click_loginIcon();

		log.info("Login Icon Clicked sucessfully!!");
		extentTest.log(LogStatus.INFO, "Login Icon Clicked sucessfully!!");

		login.click_signIn();

		log.info("SignIn Clicked sucessfully!!");
		extentTest.log(LogStatus.INFO, "SignIn Clicked sucessfully!!");

		driver.switchTo().activeElement();
		driver.switchTo().frame(login.iframe_1);

		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String ph_no = testData.get("Phone Number");
		CommonUtils.toCheckExecutionRequired(executionRequired);

		getImplicitlyWait();
		login.enter_MobileNumber(ph_no);

		log.info("Error msg occured");
		extentTest.log(LogStatus.INFO, "Error msg occured");
		getImplicitlyWait();
		String expectedTitle2 = login.Error_Msg();
		AssertJUnit.assertEquals("Please enter valid mobile number", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "Please enter valid mobile number" + ",Expected: "
				+ expectedTitle2);
		extentTest.log(LogStatus.INFO, "Assertion Passes, " + " Actual: " + "Please enter valid mobile number"
				+ ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO, "Test Case Passes -When User login by entering the wrong phonenumber");
	}
	
	

	
	
	
	



}