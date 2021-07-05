package com.redbus.base;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.redbus.utils.CommonUtils;

public class BaseClass extends CommonUtils {

	public static WebDriver driver;

	public static final Logger log = Logger.getLogger(BaseClass.class);

	// Remote web driver to run parallel cases on docker
	public static RemoteWebDriver remotedriver;

// INITIALIZING THE DIFFERENT BROWSERS WITH HEADLESS MODE OPTION

	@BeforeMethod
	public static void intializeWebDriver() throws MalformedURLException {

		boolean headlessOption = Boolean.parseBoolean(prop.getProperty("Headlessoption"));
		boolean runOnDocker = Boolean.parseBoolean(prop.getProperty("DOCKER_RUN"));

		if (runOnDocker) {
			if (headlessOption) {
				log.info("---- Docker headless---");
				driver = BrowserSetUp.dockerHeadless();
			} else {
				log.info("---- Docker Nonheadless---");
				driver = BrowserSetUp.dockerNonHeadless();
			}

		} else {
			if (headlessOption) {
				log.info("---- headless---");
				driver = BrowserSetUp.headlessMode();
			} else {
				log.info("---- Nonheadless---");
				driver = BrowserSetUp.nonHeadlessMode();
			}
		}

	}

	// OPENING THE BROWSER
	@BeforeMethod(dependsOnMethods = "intializeWebDriver")
	public static void openBrowser() throws InterruptedException {
		driver.get(CommonUtils.prop.getProperty("URL"));
		driver.manage().window().maximize();
		log.info("----------BROWSER OPENED-----------");
		log.info("----------NEW TEST CASE-----------");
		CommonUtils.getImplicitlyWait();
	}

	// CLOSING THE BROWSER
	@AfterMethod
	public static void closeBrowser() {
		// driver.close();
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Nothing to do with it");
		}
		log.info("----------Browser Closed-----------");
		log.info("-----------TEST RUN COMPLETED------------");
	}

}
