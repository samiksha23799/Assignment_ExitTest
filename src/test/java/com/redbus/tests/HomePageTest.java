package com.redbus.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.redbus.base.BaseClass;
import com.redbus.pages.BusTicketPage;
import com.redbus.pages.HomePage;
import com.redbus.testUtils.CommonAssertions;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends ExtentReport {

	public static final Logger log = Logger.getLogger(HomePageTest.class);
	private String sheetName = "HomePageData";

	@Test()
	public void rbuscares_donateanonymously() throws InterruptedException {
		log.info("Valid Test: When User navigates to rbuscare page to donation ");
		extentTest = extent.startTest("Valid scenario:  When User navigates to rbuscare page for donation ");
		HomePage hp = new HomePage(driver);
		String oldTab = driver.getWindowHandle();
		hp.click_rbus_care();
		log.info("RBus Care clicked successfully!!");
		extentTest.log(LogStatus.INFO, "RBus Care clicked successfully!!");

		// switching the driver to new tab
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		log.info("Driver is in new tab now");
		extentTest.log(LogStatus.INFO, "Driver is in new tab now");

		// Assertion
		CommonAssertions.rbusCarepageAssertion();

		hp.click_donateAmount();
		log.info("Successfully selects the amount of donation!!");
		extentTest.log(LogStatus.INFO, "Successfully selects the amount of donation");

		hp.modeofdonation_anonymously();
		log.info("Successfully selects the mode of donation!!");
		extentTest.log(LogStatus.INFO, "Successfully selects the mode of donation");

		hp.click_donatebtn();
		log.info("Successfully clicks the donate button!!");
		extentTest.log(LogStatus.INFO, "Successfully clicks the donate button");

//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = hp.get_PaymentOption();
		AssertJUnit.assertEquals("Select a payment option", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "Select a payment option" + ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + "Select a payment option" + ",Expected: " + expectedTitle2);

		// close the new tab
		driver.close();

		// switch back to the parent tab
		driver.switchTo().window(oldTab);
		log.info("Back to Parent Driver");
		extentTest.log(LogStatus.INFO, "Back to Parent Driver");
		CommonAssertions.homepageAssertion();

		log.info("User Comes back to old tab");
		extentTest.log(LogStatus.INFO, "Test Case Passes   When User navigates to rbuscare page");
	}

	@Test()
	public void rbuscares_toDonateCustomAmount() throws InterruptedException {
		log.info("Valid Test: When User navigates to rbuscare page to for Custom donation ");
		extentTest = extent.startTest("Valid scenario:  When User navigates to rbuscare page for Custom donation ");
		HomePage hp = new HomePage(driver);
		String testName = "To enter the amount for donation";
		String oldTab = driver.getWindowHandle();
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String amount = testData.get("Amount");
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		hp.click_rbus_care();
		log.info("RBus Care clicked successfully!!");
		extentTest.log(LogStatus.INFO, "RBus Care clicked successfully!!");

		// switching the driver to new tab
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		log.info("Driver is in new tab now");
		extentTest.log(LogStatus.INFO, "Driver is in new tab now");

		// Assertion
		CommonAssertions.rbusCarepageAssertion();

		hp.otherAmount(amount);
		log.info("Successfully enters the amount of donation!!");
		extentTest.log(LogStatus.INFO, "Successfully enters the amount of donation");

		hp.modeofdonation_anonymously();
		log.info("Successfully selects the mode of donation!!");
		extentTest.log(LogStatus.INFO, "Successfully selects the mode of donation");

		hp.click_donatebtn();
		log.info("Successfully clicks the donate button!!");
		extentTest.log(LogStatus.INFO, "Successfully clicks the donate button");

		log.info("User successfully navigated to payment gateway");
		extentTest.log(LogStatus.INFO, "User successfully navigated to payment gateway");
		// waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = hp.get_PaymentOption();
		AssertJUnit.assertEquals("Select a payment option", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "Select a payment option" + ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + "Select a payment option" + ",Expected: " + expectedTitle2);

		// close the new tab
		driver.close();

		// switch back to the parent tab
		driver.switchTo().window(oldTab);
		log.info("Back to Parent Driver");
		extentTest.log(LogStatus.INFO, "Back to Parent Driver");
		CommonAssertions.homepageAssertion();

		log.info("User Comes back to old tab");
		extentTest.log(LogStatus.INFO, "Test Case Passes  When User navigates to rbuscare page for Custom donation");
	}

	@Test
	public void invalid_todownloadappViaLink() throws InterruptedException {
		log.info(
				"Invalid Test: When User wants to download the redbus app by sending the link msg on wrong phone number ");
		extentTest = extent.startTest(
				"Invalid Test: When User wants to download the redbus app by sending the link msg on wrong phone number  ");
		String testName = "Invalid Scenario -User send the download link on phone by entering wrong number";
		// Scroll the page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 950);");

		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String ph_number = testData.get("Phone Number");

		CommonUtils.toCheckExecutionRequired(executionRequired);

		HomePage hp = new HomePage(driver);

		hp.enter_ph(ph_number);
		log.info(ph_number + "entered");
		extentTest.log(LogStatus.INFO, ph_number + "entered");

		hp.click_sendLinkbtn();

		log.info("successfully clicked on send link button!!");
		extentTest.log(LogStatus.INFO, "successfully clicked on send link button!!");

//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = hp.get_error_msg();
		AssertJUnit.assertEquals("Invalid Mobile No", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "Invalid Mobile No" + ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + "Invalid Mobile No" + ",Expected: " + expectedTitle2);

		extentTest.log(LogStatus.INFO,
				"Test Case Passes -When User wants to download the redbus app by sending the link msg on wrong phone number");

	}

	@Test
	public void invalid_todownloadappViaLink1() throws InterruptedException {
		log.info(
				"Invalid Test: When User wants to download the redbus app by sending the link msg on phone without providing phone no. ");
		extentTest = extent.startTest(
				"Invalid Test: When User wants to download the redbus app by sending the link msg on phone without providing phone no. ");
		// Scroll the page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 950);");

		HomePage hp = new HomePage(driver);

		hp.click_sendLinkbtn();
		log.info("successfully clicked on send link button!!");
		extentTest.log(LogStatus.INFO, "successfully clicked on send link button!!");

//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = hp.get_error_msg2();
		AssertJUnit.assertEquals("Enter the mobile number", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "Enter the mobile number" + ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + "Enter the mobile number" + ",Expected: " + expectedTitle2);

		extentTest.log(LogStatus.INFO,
				"Test Case Passes -When User wants to download the redbus app by sending the link msg on phone without providing phone no.");

	}

	@Test()
	public void rbuscares_navigatePaymentGateway() throws InterruptedException {
		log.info("Valid Test: When User navigates to Payment Gateway for donation ");
		extentTest = extent.startTest("Valid scenario:  When User navigates to Payment Gateway for donation ");
		HomePage hp = new HomePage(driver);
		String testName = "To enter the amount for donation";
		String oldTab = driver.getWindowHandle();
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String amount = testData.get("Amount");
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		hp.click_rbus_care();
		log.info("RBus Care clicked successfully!!");
		extentTest.log(LogStatus.INFO, "RBus Care clicked successfully!!");

		// switching the driver to new tab
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		log.info("Driver is in new tab now");
		extentTest.log(LogStatus.INFO, "Driver is in new tab now");

		// Assertion
		CommonAssertions.rbusCarepageAssertion();

		hp.otherAmount(amount);
		log.info("Successfully enters the amount of donation!!");
		extentTest.log(LogStatus.INFO, "Successfully enters the amount of donation");

		hp.modeofdonation_anonymously();
		log.info("Successfully selects the mode of donation!!");
		extentTest.log(LogStatus.INFO, "Successfully selects the mode of donation");

		hp.click_donatebtn();
		log.info("Successfully clicks the donate button!!");
		extentTest.log(LogStatus.INFO, "Successfully clicks the donate button");

		// waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = hp.get_PaymentOption();
		AssertJUnit.assertEquals("Select a payment option", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "Select a payment option" + ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + "Select a payment option" + ",Expected: " + expectedTitle2);

		hp.Select_paymentMode();
		log.info("User successfully navigated to payment gateway");
		extentTest.log(LogStatus.INFO, "User successfully navigated to payment gateway");

		hp.Select_bank();
		log.info("User successfully selects the bank");
		extentTest.log(LogStatus.INFO, "User successfully selects the bank");

		// Scroll the page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 400);");
		hp.click_paynow();
		log.info("User successfully click the Pay now button");
		extentTest.log(LogStatus.INFO, "User successfully click the Paynow button");
		
		CommonAssertions.paymentPage_Assertion();
		// close the new tab
		driver.close();

		// switch back to the parent tab
		driver.switchTo().window(oldTab);
		log.info("Back to Parent Driver");
		extentTest.log(LogStatus.INFO, "Back to Parent Driver");
		CommonAssertions.homepageAssertion();

		log.info("User Comes back to old tab");
		extentTest.log(LogStatus.INFO, "Test Case Passes   When User navigates Payment Gateway for donation");
	}
}
