package com.redbus.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import com.redbus.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class CommonUtils {

// --------------Creating ConfigProperties File-----------------
	public static File file = new File(".\\src\\test\\resources\\Properties\\config.properties");
	public static FileInputStream fis = null;
	public static Properties prop = new Properties();

	public static final Logger log = Logger.getLogger(CommonUtils.class);

//Excel File Test Data Reader
	public static ExcelHandler reader = null;

	static {

		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Exception Handling for Excel File
		try {

			reader = new ExcelHandler(prop.getProperty("EXCEL_PATH"));
		} catch (Exception e) {

			log.error(e.getMessage());
		}
	}

// --------------------------IMPLICITLY WAIT-------------------------

	public static long getImplicitlyWait() {
		String implicitlyWait = prop.getProperty("IMPLICIT_WAIT");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("Implicitly Wait not specified in the config.properties file!!!");
	}
	


	// function toCheckExecutionRequired
	public static void toCheckExecutionRequired(String executionRequired) {

		// if execution required field is no
		if (executionRequired.equals("no")) {

			ExtentReport.extentTest.log(LogStatus.WARNING, "Execution Required : " + executionRequired.toUpperCase());
			log.info("Execution required is no , skipping the test");
			throw new SkipException("Skipping this exception");
		}

		// if execution required field is empty
		if (executionRequired.equals("")) {

			ExtentReport.extentTest.log(LogStatus.WARNING, "Execution Required : " + executionRequired.toUpperCase());
			log.info("Execution required is empty , skipping the test");
			throw new SkipException("Skipping this exception");
		}
	}

//	--------------------GET PAGE TITLE
	public static String actualTitle() {
		String actualTitle = BaseClass.driver.getTitle();
		return actualTitle;
	}

}
