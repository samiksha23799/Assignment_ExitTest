package com.redbus.tests;


import org.testng.annotations.Test;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import com.redbus.pages.BusHirePage;
import com.redbus.testUtils.CommonAssertions;
import com.redbus.utils.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;

public class BusHireTest extends ExtentReport {
	public static final Logger log = Logger.getLogger(BusHireTest.class);

	@Test()
	public void offers() throws InterruptedException {
		log.info("Valid Test: When User check various offers from BusHire Page");
		extentTest = extent.startTest("Valid scenario:  When User check various offers from BusHire Page");
		BusHirePage bushire = new BusHirePage(driver);
		String oldTab = driver.getWindowHandle();
		bushire.click_BusHireLink();
		log.info("Bus hire button clicked successfully!!");
		extentTest.log(LogStatus.INFO, "Bus hire button clicked successfully!!");
		CommonAssertions.bushirepage_Assertion();

		bushire.click_loginbtn();
		bushire.click_offers();

		getImplicitlyWait();

		// switching the driver to new tab
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		log.info("Driver is in new offers tab now");
		extentTest.log(LogStatus.INFO, "Driver is in new Offers tab now");
		
		CommonAssertions.offersPage_Assertion();
		bushire.select_offer();
		log.info("Successfully selects the offer");
		extentTest.log(LogStatus.INFO, "Successfully selects the offer");
		Thread.sleep(5000);
		
	
		// close the new tab
		driver.close();

		// switch back to the parent tab
		driver.switchTo().window(oldTab);
		log.info("Back to Parent Driver");
		extentTest.log(LogStatus.INFO, "Back to Parent Driver");
		
		//Assertions
		CommonAssertions.bushirepage_Assertion();

		extentTest.log(LogStatus.INFO, "Test Case Passes  When User check various offers from BusHire Page!!");
	}
	


}
