package com.redbus.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.redbus.pages.SearchPage;
import com.redbus.testUtils.CommonAssertions;
import com.redbus.testUtils.CommonTestCase;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

public class SearchTest extends ExtentReport {
	public static final Logger log = Logger.getLogger(SearchTest.class);
	public static String sheetName = "SearchPageData";

	@Test
	public void valid_search() throws InterruptedException {
		log.info("Valid Test: When User wants to search buses ");
		extentTest = extent.startTest("Valid scenario:  When User wants to search buses");
		SearchPage search = new SearchPage(driver);
		search.clickBusTicket();

		log.info("Bus Ticket Button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Bus Ticket Button clicked successfully!!");

		CommonAssertions.busTicketpage_Assertion();
		String testName = "Valid Test- Valid From and Valid To Location";

		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String from = testData.get("From");
		String to = testData.get("To");
		String date = testData.get("Date");
		CommonUtils.toCheckExecutionRequired(executionRequired);
		search.enter_source(from);
		log.info("from location successfully entered!!");
		extentTest.log(LogStatus.INFO, "from location successfully entered!!");

		search.enter_dest(to);
		log.info("To location successfully entered!!");
		extentTest.log(LogStatus.INFO, "To location successfully entered!!");

		search.date(date);
		log.info("Journey date successfully entered!!");
		extentTest.log(LogStatus.INFO, "Journey date successfully entered!!");

		search.clickOnSearchBusesButton();
		log.info("successfully clicked on search buses button!!");
		extentTest.log(LogStatus.INFO, "successfully clicked on search buses button!!");
		Thread.sleep(5000);
		// Assertion Check for after Search Page
		CommonAssertions.afterSearchPage_Assertion();
		extentTest.log(LogStatus.INFO, "Test Case Passes-  When User wants to search buses");

	}

	@Test
	public void invalid_searchCheck() throws InterruptedException {
		log.info("Valid Test: When User enters the valid From Location and Invalid To Location ");
		extentTest = extent
				.startTest("Valid scenario: When User enters the valid From Location and Invalid To Location ");
		SearchPage search = new SearchPage(driver);
		search.clickBusTicket();

		log.info("Bus Ticket Button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Bus Ticket Button clicked successfully!!");

		CommonAssertions.busTicketpage_Assertion();
		String testName = "Invalid Test- Valid From and Invalid To Location";

		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String from = testData.get("From");
		String to = testData.get("To");
		String date = testData.get("Date");
		CommonUtils.toCheckExecutionRequired(executionRequired);
		search.enter_source(from);
		log.info("from location successfully entered!!");
		extentTest.log(LogStatus.INFO, "from location successfully entered!!");

		search.enter_dest(to);
		log.info("To location successfully entered!!");
		extentTest.log(LogStatus.INFO, "To location successfully entered!!");

		search.date(date);
		log.info("Journey date successfully entered!!");
		extentTest.log(LogStatus.INFO, "Journey date successfully entered!!");

		search.clickOnSearchBusesButton();
		log.info("successfully clicked on search buses button!!");
		extentTest.log(LogStatus.INFO, "successfully clicked on search buses button!!");

		CommonAssertions.busTicketpage_Assertion();
		log.info("user is unable to search due to wrong From Location!!");
		extentTest.log(LogStatus.INFO, "user is unable to search due to wrong From Location!!");
		Thread.sleep(5000);
		extentTest.log(LogStatus.INFO,
				"Test Case Passes- When User enters the valid From Location and Invalid To Location ");
	}

	@Test
	public void invalid_searchCheck2() {
		log.info("Valid Test: When User enters the valid From Location and Invalid To Location ");
		extentTest = extent
				.startTest("Valid scenario: When User enters the valid From Location and Invalid To Location ");
		SearchPage search = new SearchPage(driver);
		search.clickBusTicket();

		log.info("Bus Ticket Button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Bus Ticket Button clicked successfully!!");

		CommonAssertions.busTicketpage_Assertion();
		String testName = "Invalid Test- Invalid From and Valid To Location";

		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String from = testData.get("From");
		String to = testData.get("To");
		String date = testData.get("Date");
		CommonUtils.toCheckExecutionRequired(executionRequired);
		search.enter_source(from);
		log.info("from location successfully entered!!");
		extentTest.log(LogStatus.INFO, "from location successfully entered!!");

		search.enter_dest(to);
		log.info("To location successfully entered!!");
		extentTest.log(LogStatus.INFO, "To location successfully entered!!");

		search.date(date);
		log.info("Journey date successfully entered!!");
		extentTest.log(LogStatus.INFO, "Journey date successfully entered!!");

		search.clickOnSearchBusesButton();
		log.info("successfully clicked on search buses button!!");
		extentTest.log(LogStatus.INFO, "successfully clicked on search buses button!!");

		CommonAssertions.busTicketpage_Assertion();
		log.info("user is unable to search due to wrong To Location!!");
		extentTest.log(LogStatus.INFO, "user is unable to search due to wrong To Location!!");

		extentTest.log(LogStatus.INFO,
				"Test Case Passes- When User enters the valid From Location and Invalid To Location ");
	}

	@Test
	public void modifySearch() throws InterruptedException {
		log.info("Valid Test: When User wants to modify search buses ");
		extentTest = extent.startTest("Valid scenario:  When User wants to modify search buses ");
		SearchPage search = new SearchPage(driver);
		search.clickBusTicket();

		log.info("Bus Ticket Button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Bus Ticket Button clicked successfully!!");

		CommonAssertions.busTicketpage_Assertion();
		String testName = "Valid Test- For Modify Bus route";

		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String from = testData.get("From");
		String to = testData.get("To");
		String date = testData.get("Date");
		CommonUtils.toCheckExecutionRequired(executionRequired);
		search.enter_source(from);
		log.info("from location successfully entered!!");
		extentTest.log(LogStatus.INFO, "from location successfully entered!!");

		search.enter_dest(to);
		log.info("To location successfully entered!!");
		extentTest.log(LogStatus.INFO, "To location successfully entered!!");

		search.date(date);
		log.info("Journey date successfully entered!!");
		extentTest.log(LogStatus.INFO, "Journey date successfully entered!!");

		search.clickOnSearchBusesButton();
		log.info("successfully clicked on search buses button!!");
		extentTest.log(LogStatus.INFO, "successfully clicked on search buses button!!");

		// Assertion Check for after Search Page
		CommonAssertions.afterSearchPage_Assertion();

		search.click_modifyButton();
		log.info("successfully clicked on modify buses button!!");
		extentTest.log(LogStatus.INFO, "successfully clicked on modify buses button!!");

		search.click_switchRoute();
		log.info("successfully clicked on switch route button!!");
		extentTest.log(LogStatus.INFO, "successfully clicked on switch route button!!");

		search.searchbtn();
		log.info("Again successfully clicked on search buses button!!");
		extentTest.log(LogStatus.INFO, "againsuccessfully clicked on search buses button!!");

		extentTest.log(LogStatus.INFO, "Test Case Passes- When User wants to modify search buses");
	}

	@Test
	public void valid_tofilterSearches() throws InterruptedException {
		log.info("Valid Test: When User wants to filter the departure time of search bus ");
		extentTest = extent.startTest("Valid scenario:  When User wants to filter the departure time of search bus");

		CommonTestCase.Search();
		SearchPage search = new SearchPage(driver);
		search.departure_filter();
		log.info("Successfully filter the departure time ");
		extentTest.log(LogStatus.INFO, "Successfully filter the departure time");

//		waits and assertions
		getImplicitlyWait();
		CommonAssertions.afterSearchPage_Assertion();

		extentTest.log(LogStatus.INFO, "Test Case Passes- When User wants to filter the departure time of search bus");

	}

	@Test
	public void valid_toselectSeat() throws InterruptedException {
		log.info("Valid Test: When User wants to check the availability of seat after searching the Bus");
		extentTest = extent.startTest(
				"Valid scenario:  When User wants to check the availability of seat after searching the Bus");

		CommonTestCase.Search();
		SearchPage search = new SearchPage(driver);

		// Scroll the page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 400);");

		search.click_viewSeats();
		log.info("Successfully clicked the view Seats button ");
		extentTest.log(LogStatus.INFO, "Successfully clicked the view seat Button");

		search.select_seatPrice();
		log.info("Successfully selects the seat price ");
		extentTest.log(LogStatus.INFO, "Successfully  selects the seat price");

//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = search.verify_seatcheck();
		AssertJUnit.assertEquals("SEAT LEGEND", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "SEAT LEGEND" + ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,
				"Assertion Passes, " + " Actual: " + "SEAT LEGEND" + ",Expected: " + expectedTitle2);

//		waits and assertions
		getImplicitlyWait();
		CommonAssertions.afterSearchPage_Assertion();

		extentTest.log(LogStatus.INFO,
				"Test Case Passes-  When User wants to check the availability of seat after searching the Bus");

	}

}
