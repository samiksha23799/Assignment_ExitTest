package com.redbus.tests;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.redbus.pages.TicketDetailsPage;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class TicketDetailsTest extends ExtentReport {
	
	public static final Logger log = Logger.getLogger(TicketDetailsTest.class);
	public String sheetName = "TicketData";

	@Test()
	public void valid_togetETicket() throws InterruptedException {
		log.info("Valid Test: When User wants to get the eTicket of booked journey ");
		extentTest = extent.startTest("Valid scenario:  When User wants to get the eTicket of booked journey");
		String testName = "Valid Scenario- valid ticket number and email";

		TicketDetailsPage ticket = new TicketDetailsPage(driver);
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String ticket_no = testData.get("Ticket Number");
		String email = testData.get("Email Used For Booking");
		
		CommonUtils.toCheckExecutionRequired(executionRequired);

		ticket.click_managebooking();
		log.info("Successfully clicked on Manage Booking Button.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Manage Booking Button.");
		
		ticket.click_showMyTicket();
		log.info("Successfully clicked on Show My Ticket Option.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Show My Ticket Option.");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = ticket.getText_printticketPage();
		AssertJUnit.assertEquals("PRINT TICKET", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "PRINT TICKET"+ ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,"Assertion Passes, " + " Actual: " + "PRINT TICKET"+ ",Expected: " + expectedTitle2);
		
		ticket.enter_ticketNumber(ticket_no);
		log.info("Ticket Number entered is- " + ticket_no);
		extentTest.log(LogStatus.INFO,"Ticket Number entered is- " + ticket_no);
		
		ticket.enter_eMail(email);
		log.info("Email used for booking is- " + email);
		extentTest.log(LogStatus.INFO,"Email used for booking is- " + email);
		
		ticket.click_searchTicket();
		log.info("Successfully clicked on Search Ticket Button.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Search Ticket Button.");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = ticket.getText_eTicketPage();
		AssertJUnit.assertEquals("eTICKET", expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + "eTICKET"+ ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,"Assertion Passes, " + " Actual: " + "eTICKET"+ ",Expected: " + expectedTitle);
		
		extentTest.log(LogStatus.INFO, "Test Case Passes - When User wants to get the eTicket of booked journey!!");
	}
	
	@Test()
	public void invalid_togetETicket() throws InterruptedException {
		log.info("Invalid Test: To get the E-ticket by entering valid Ticket number and invalid email ");
		extentTest = extent.startTest("Invalid Test: To get the E-ticket by entering valid Ticket number and invalid email");
		String testName = "Invalid Scenario- Valid Ticket Number And invalid email";

		TicketDetailsPage ticket = new TicketDetailsPage(driver);
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String ticket_no = testData.get("Ticket Number");
		String email = testData.get("Email Used For Booking");
		
		CommonUtils.toCheckExecutionRequired(executionRequired);

		ticket.click_managebooking();
		log.info("Successfully clicked on Manage Booking Button.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Manage Booking Button.");
		
		ticket.click_showMyTicket();
		log.info("Successfully clicked on Show My Ticket Option.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Show My Ticket Option.");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = ticket.getText_printticketPage();
		AssertJUnit.assertEquals("PRINT TICKET", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "PRINT TICKET"+ ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,"Assertion Passes, " + " Actual: " + "PRINT TICKET"+ ",Expected: " + expectedTitle2);
		
		ticket.enter_ticketNumber(ticket_no);
		log.info("Ticket Number entered is- " + ticket_no);
		extentTest.log(LogStatus.INFO,"Ticket Number entered is- " + ticket_no);
		
		ticket.enter_eMail(email);
		log.info("Email used for booking is- " + email);
		extentTest.log(LogStatus.INFO,"Email used for booking is- " + email);
		
		ticket.click_searchTicket();
		log.info("Successfully clicked on Search Ticket Button.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Search Ticket Button.");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = ticket.getText_error_msg();
		AssertJUnit.assertEquals(CommonUtils.prop.getProperty("ERROR_MSG_FOR_TICKET_TEST"), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.prop.getProperty("ERROR_MSG_FOR_TICKET_TEST") + ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,"Assertion Passes, " + " Actual: " + CommonUtils.prop.getProperty("ERROR_MSG_FOR_TICKET_TEST") + ",Expected: " + expectedTitle);
		
		
		extentTest.log(LogStatus.INFO, "Test Case Passes -  To get the E-ticket by entering valid Ticket number and invalid email");
	}
	
	@Test()
	public void invalid_togetETicket1() throws InterruptedException {
		log.info("Invalid Test: To get the E-ticket by entering valid Ticket number and invalid email ");
		extentTest = extent.startTest("Invalid Test: To get the E-ticket by entering valid Ticket number and invalid email");
		String testName = "Invalid Scenario- invalid Ticket Number And valid email";

		TicketDetailsPage ticket = new TicketDetailsPage(driver);
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String ticket_no = testData.get("Ticket Number");
		String email = testData.get("Email Used For Booking");
		
		CommonUtils.toCheckExecutionRequired(executionRequired);

		ticket.click_managebooking();
		log.info("Successfully clicked on Manage Booking Button.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Manage Booking Button.");
		
		ticket.click_showMyTicket();
		log.info("Successfully clicked on Show My Ticket Option.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Show My Ticket Option.");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = ticket.getText_printticketPage();
		AssertJUnit.assertEquals("PRINT TICKET", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "PRINT TICKET"+ ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,"Assertion Passes, " + " Actual: " + "PRINT TICKET"+ ",Expected: " + expectedTitle2);
		
		ticket.enter_ticketNumber(ticket_no);
		log.info("Ticket Number entered is- " + ticket_no);
		extentTest.log(LogStatus.INFO,"Ticket Number entered is- " + ticket_no);
		
		ticket.enter_eMail(email);
		log.info("Email used for booking is- " + email);
		extentTest.log(LogStatus.INFO,"Email used for booking is- " + email);
		
		ticket.click_searchTicket();
		log.info("Successfully clicked on Search Ticket Button.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Search Ticket Button.");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = ticket.getText_error_msg();
		AssertJUnit.assertEquals("Something went wrong, please try again later!", expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + "Something went wrong, please try again later!"+ ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,"Assertion Passes, " + " Actual: " + "Something went wrong, please try again later!"+ ",Expected: " + expectedTitle);
		
		
		extentTest.log(LogStatus.INFO, "Test Case Passes -  To get the E-ticket by entering valid Ticket number and invalid email");
	}
	
	@Test()
	public void invalid_togetETicket2() throws InterruptedException {
		log.info("Invalid Test: To get the E-ticket by entering invalid Ticket number and invalid email ");
		extentTest = extent.startTest("Invalid Test: To get the E-ticket by entering invalid Ticket number and invalid email");
		String testName = "Invalid Scenario- invalid Ticket Number And invalid email";

		TicketDetailsPage ticket = new TicketDetailsPage(driver);
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		log.info(testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String ticket_no = testData.get("Ticket Number");
		String email = testData.get("Email Used For Booking");
		
		CommonUtils.toCheckExecutionRequired(executionRequired);

		ticket.click_managebooking();
		log.info("Successfully clicked on Manage Booking Button.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Manage Booking Button.");
		
		ticket.click_showMyTicket();
		log.info("Successfully clicked on Show My Ticket Option.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Show My Ticket Option.");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = ticket.getText_printticketPage();
		AssertJUnit.assertEquals("PRINT TICKET", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "PRINT TICKET"+ ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO,"Assertion Passes, " + " Actual: " + "PRINT TICKET"+ ",Expected: " + expectedTitle2);
		
		ticket.enter_ticketNumber(ticket_no);
		log.info("Ticket Number entered is- " + ticket_no);
		extentTest.log(LogStatus.INFO,"Ticket Number entered is- " + ticket_no);
		
		ticket.enter_eMail(email);
		log.info("Email used for booking is- " + email);
		extentTest.log(LogStatus.INFO,"Email used for booking is- " + email);
		
		ticket.click_searchTicket();
		log.info("Successfully clicked on Search Ticket Button.");
		extentTest.log(LogStatus.INFO,"Successfully clicked on Search Ticket Button.");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = ticket.getText_error_msg();
		AssertJUnit.assertEquals("Something went wrong, please try again later!", expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + "Something went wrong, please try again later!"+ ",Expected: " + expectedTitle);
		extentTest.log(LogStatus.INFO,"Assertion Passes, " + " Actual: " + "Something went wrong, please try again later!"+ ",Expected: " + expectedTitle);
		
		
		extentTest.log(LogStatus.INFO, "Test Case Passes -  To get the E-ticket by entering invalid Ticket number and invalid email");
	}
}
