package com.redbus.tests;

import org.testng.annotations.Test;

import org.apache.log4j.Logger;

import com.redbus.utils.*;
import com.relevantcodes.extentreports.LogStatus;
import com.redbus.pages.NavBar;
import com.redbus.testUtils.CommonAssertions;

public class NavBarTest extends ExtentReport{
	
	public static final Logger log = Logger.getLogger(NavBarTest.class);
	

	@Test()
	public void rPool() {
		log.info("Valid Test: When User click on RPool on Nav Bar");
		extentTest = extent.startTest("Valid scenario: To click on rPool");
		NavBar nb = new NavBar(driver);

		nb.click_RPoolLink();;
		log.info("RPool was clicked");
		extentTest.log(LogStatus.INFO, "RPool was clicked");
		//Assertion
		CommonAssertions.rpoolpage_Assertion();
		extentTest.log(LogStatus.INFO, "Test Case Passes when user click on rpool on nav bar!!");
	}
	
	@Test()
	public void busHire() {
		log.info("Valid Test: When User click on BusHire on Nav Bar");
		extentTest = extent.startTest("Valid scenario: To click on Bus Hire");
		NavBar nb = new NavBar(driver);

		nb.click_BusHireLink();;
		log.info("Bus Hire was clicked");
		extentTest.log(LogStatus.INFO, "BusHire was clicked");

		// Assertion for BusHire Page
		CommonAssertions.bushirepage_Assertion();
		extentTest.log(LogStatus.INFO, "Test Case Passes when user click on busHire on nav bar!!");
	}
	
	@Test()
	public void busTicket() {
		log.info("Valid Test: When User click on Bus Tickets on Nav Bar");
		extentTest = extent.startTest("Valid scenario: To click on BusTicket");
		NavBar nb = new NavBar(driver);

		nb.click_BusTicketsLink();;
		log.info("Bus Ticket was clicked");
		extentTest.log(LogStatus.INFO, "Bus Ticket was clicked");

		// Assertion for bus ticket page
		CommonAssertions.busTicketpage_Assertion();
		extentTest.log(LogStatus.INFO, "Test Case Passes when user click on Bus Ticket  on nav bar!!");
	}
	
	@Test()
	public void redBusLogo() {
		log.info("Valid Test: When User click on redBusLogo on Nav Bar");
		extentTest = extent.startTest("Valid scenario: To click on RedBusLogo");
		NavBar nb = new NavBar(driver);

		nb.click_RedBusLogo();;
		log.info("RedBusLogo was clicked");
		extentTest.log(LogStatus.INFO, "HOME_PAGE_TITLE was clicked");

		//Assertion for HomePage
		CommonAssertions.homepageAssertion();
		extentTest.log(LogStatus.INFO, "Test Case Passes when user click on redbuslogo on nav bar!!");
	}
}
