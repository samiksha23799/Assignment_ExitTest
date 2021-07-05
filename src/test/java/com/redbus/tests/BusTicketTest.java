package com.redbus.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


import com.redbus.pages.BusTicketPage;
import com.redbus.utils.CommonUtils;
import com.redbus.utils.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class BusTicketTest extends ExtentReport {
	
	public static final Logger log = Logger.getLogger(BusTicketTest.class);
	

	@Test()
	public void cancelTicket() {
		log.info("Valid Test: When User click on Cancel Ticket ");
		extentTest = extent.startTest("Valid scenario:  When User click on Cancel Ticket");
		BusTicketPage busticket = new BusTicketPage(driver);

		busticket.click_busticket();
		log.info("Bus Ticket Button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Bus Ticket Button clicked successfully!!");

//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = prop.getProperty("BUS_TICKET_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		
		busticket.click_cancelButton();
		log.info("Cancel Ticket Button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Cancel Ticket Button clicked successfully!!");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = prop.getProperty("CANCEL_TICKET_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle2);
		extentTest.log(LogStatus.INFO, "Test Case Passes  When User click on Cancel Ticket!!");
	}
	
	@Test()
	public void printSmsTicket() {
		log.info("Valid Test: When User click on Print/SMS Ticket ");
		extentTest = extent.startTest("Valid scenario:  When User click on Print/SMS Ticket");
		BusTicketPage busticket = new BusTicketPage(driver);

		busticket.click_busticket();
		log.info("Bus Ticket Button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Bus Ticket Button clicked successfully!!");

//		waits and assertions
		getImplicitlyWait();
		String expectedTitle = prop.getProperty("BUS_TICKET_PAGE_TITLE");
		AssertJUnit.assertEquals("Condition true", CommonUtils.actualTitle(), expectedTitle);
		log.info("Assertion Passes, " + " Actual: " + CommonUtils.actualTitle() + ",Expected: " + expectedTitle);
		
		busticket.click_printButton();
		log.info("Print/SMS Ticket Button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Print/SMS Ticket Button clicked successfully!!");
		
//		waits and assertions
		getImplicitlyWait();
		String expectedTitle2 = busticket.get_headerText();
		AssertJUnit.assertEquals("PRINT TICKET", expectedTitle2);
		log.info("Assertion Passes, " + " Actual: " + "PRINT TICKET"+ ",Expected: " + expectedTitle2);

		extentTest.log(LogStatus.INFO, "Test Case Passes  When User click on Print/SMS Ticket!!");
	}
	
	
	
	
	


}
