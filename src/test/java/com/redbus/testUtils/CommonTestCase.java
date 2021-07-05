package com.redbus.testUtils;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.redbus.pages.SearchPage;
import com.redbus.tests.SearchTest;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class CommonTestCase extends ExtentReport{
	public static final Logger log = Logger.getLogger(CommonTestCase.class);
	
	
	public static void Search() {
		SearchPage search = new SearchPage(driver);
		search.clickBusTicket();

		log.info("Bus Ticket Button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Bus Ticket Button clicked successfully!!");

		CommonAssertions.busTicketpage_Assertion();
		String testName = "Valid Test- Valid From and Valid To Location";

		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(SearchTest.sheetName, testName);
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
	}

}
