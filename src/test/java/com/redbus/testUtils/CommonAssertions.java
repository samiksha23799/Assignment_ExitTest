package com.redbus.testUtils;

import org.apache.log4j.Logger;
import org.testng.AssertJUnit;

import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class CommonAssertions extends ExtentReport {
	public static final Logger log = Logger.getLogger(CommonAssertions.class);

	// Assertion Check for HomePage
	public static void homepageAssertion() {
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = prop.getProperty("HOME_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
	}

	// Assertion Check for RBusCare Page
	public static void rbusCarepageAssertion() {
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = prop.getProperty("RBUS_CARE_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle2);
	}

	// Assertion Check for BusHire Page
	public static void bushirepage_Assertion() {
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = prop.getProperty("BUSHIRE_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
	}

	// Assertion Check for offer Page
	public static void offersPage_Assertion() {
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = prop.getProperty("OFFERS_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
	}

	// Assertion Check for BusHire Page
	public static void busTicketpage_Assertion() {
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = prop.getProperty("BUS_TICKET_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
	}

	// Assertion Check for RPool Page
	public static void rpoolpage_Assertion() {
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = prop.getProperty("RPOOL_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
	}

	// Assertion Check for after Search Page
	public static void afterSearchPage_Assertion() {
		// waits and assertions
		getImplicitlyWait();
		String expectedTitle = prop.getProperty("SEARCH_BUSES_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
	}

	// Assertion Check for after Google LoginPAge
	public static void googleLoginPage_Assertion() {
//			waits and assertions
		getImplicitlyWait();
		String expectedTitle = prop.getProperty("GOOGLE_SIGN_IN_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
	}

	// Assertion Check for after Google LoginPAge
	public static void paymentPage_Assertion() throws InterruptedException {
//					waits and assertions
		getImplicitlyWait();
		Thread.sleep(7000);
		String expectedTitle = prop.getProperty("PAYMENT_BANK_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
	}

}
