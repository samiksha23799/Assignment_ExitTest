package com.redbus.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.redbus.utils.CommonUtils;

public class BrowserSetUp {
	public static final Logger log = Logger.getLogger(BrowserSetUp.class);

	// To initialize the Driver
	public static WebDriver driver;

	public static RemoteWebDriver remoteDriver;
	public static WebDriver webDriver;
	public static DesiredCapabilities caps;

	public static URL url = null;

	

	// To open the Browser in NON- Headless Mode
	public static WebDriver nonHeadlessMode() {
		String type = CommonUtils.prop.getProperty("BrowserType");
		type = type.toLowerCase();
		log.info("Browser open in Non- headless mode @ - " + type);
		switch (type) {
		case "chrome":
			System.setProperty(CommonUtils.prop.getProperty("CHROME_KEY"), CommonUtils.prop.getProperty("CHROME_PATH"));
			// driver to open Chrome
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty(CommonUtils.prop.getProperty("FOX_KEY"), CommonUtils.prop.getProperty("FOX_PATH"));
			driver = new FirefoxDriver(); // driver to open firefox
			break;
		case "ie":
			System.setProperty(CommonUtils.prop.getProperty("IE_KEY"), CommonUtils.prop.getProperty("IE_PATH"));
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();

			//Deleting all the cookies
			driver.manage().deleteAllCookies();
			break;
		}
		return driver;
	}

	// To open the Browser in Headless Mode
	public static WebDriver headlessMode() {
		String type = CommonUtils.prop.getProperty("BrowserType");
		type = type.toLowerCase();
		log.info("Browser open in headless mode @ - " + type);

		switch (type) {
		case "chrome":
			String options = CommonUtils.prop.getProperty("Headlessoption");
			Boolean opt = Boolean.parseBoolean(options.toLowerCase());
			System.setProperty(CommonUtils.prop.getProperty("CHROME_KEY"), CommonUtils.prop.getProperty("CHROME_PATH"));
			ChromeOptions chromeoption = new ChromeOptions();
			chromeoption.setHeadless(opt);

			chromeoption.addArguments("--disable-gpu");
			chromeoption.addArguments("--disable-dev-shm-usage");
			chromeoption.addArguments("--no-sandbox");
			chromeoption.addArguments("--allow-insecure-localhost");
			chromeoption.addArguments("user-agent=Chrome/91.0.4472.124");
			chromeoption.addArguments("window-size=1920,1080");

			driver = new ChromeDriver(chromeoption); // driver to open Chrome
			break;

		case "firefox":
			String options_headless = CommonUtils.prop.getProperty("Headlessoption");
			Boolean opt_headless = Boolean.parseBoolean(options_headless.toLowerCase());
			System.setProperty(CommonUtils.prop.getProperty("FOX_KEY"), CommonUtils.prop.getProperty("FOX_PATH"));
			FirefoxOptions foxoption = new FirefoxOptions();
			foxoption.setHeadless(opt_headless);
			driver = new FirefoxDriver(foxoption); // driver to open firefox
			break;	
		case "ie":
			System.setProperty(CommonUtils.prop.getProperty("IE_KEY"), CommonUtils.prop.getProperty("IE_PATH"));
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();

			//Deleting all the cookies
			driver.manage().deleteAllCookies();
			break;
		}
		return driver;
	}

	

	// To run browser in Docker Non Headless
	public static RemoteWebDriver dockerNonHeadless() throws MalformedURLException {
		
		String type = CommonUtils.prop.getProperty("BrowserType");
		type = type.toLowerCase();
		log.info("Browser open in Docker Non- headless mode @ - " + type);
		url = new URL(CommonUtils.prop.getProperty("DOCKER_URL"));
		switch (type) {
		case "chrome":
			caps = DesiredCapabilities.chrome();
			remoteDriver = new RemoteWebDriver(url, caps);
			log.info("Browser runs at:-" + url);
			break;
		case "firefox":
			caps = DesiredCapabilities.firefox();
			remoteDriver = new RemoteWebDriver(url, caps);
			log.info("Browser runs at:-" + url);
			break;
		case "ie":
			caps = DesiredCapabilities.internetExplorer();
			remoteDriver = new RemoteWebDriver(url, caps);
			break;
		}
		
		return remoteDriver;
	}

	// To run browser in Docker Headless
	public static RemoteWebDriver dockerHeadless() throws MalformedURLException {
		String type = CommonUtils.prop.getProperty("BrowserType");
		type = type.toLowerCase();
		log.info("Browser open Docker in headless mode @- " + type);
		url = new URL(CommonUtils.prop.getProperty("DOCKER_URL"));
		
		switch (type) {
		case "chrome":
			String options = CommonUtils.prop.getProperty("Headlessoption");
			Boolean opt = Boolean.parseBoolean(options.toLowerCase());
			caps = DesiredCapabilities.chrome();
			ChromeOptions chromeoption = new ChromeOptions();
			chromeoption.setHeadless(opt);

			chromeoption.addArguments("--disable-gpu");
			chromeoption.addArguments("--disable-dev-shm-usage");
			chromeoption.addArguments("--no-sandbox");
			chromeoption.addArguments("--allow-insecure-localhost");
			chromeoption.addArguments("user-agent=Chrome/91.0.4472.124");
			chromeoption.addArguments("window-size=1920,1080");

			remoteDriver = new RemoteWebDriver(url, chromeoption);
			break;

		case "firefox":
			String options_headless = CommonUtils.prop.getProperty("Headlessoption");
			Boolean opt_headless = Boolean.parseBoolean(options_headless.toLowerCase());
			caps = DesiredCapabilities.firefox();
			FirefoxOptions foxoption = new FirefoxOptions();
			foxoption.setHeadless(opt_headless);
			remoteDriver = new RemoteWebDriver(url, foxoption);
			log.info("Browser runs at:-" + url);
			break;
		case "ie":
			caps = DesiredCapabilities.internetExplorer();
			ChromeOptions chromeoption1 = new ChromeOptions();

			remoteDriver = new RemoteWebDriver(url, chromeoption1);
			break;
		}
		return remoteDriver;
	}

}
