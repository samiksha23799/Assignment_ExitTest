package com.redbus.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusHirePage {

	// ---------------Page Factory--------------------
	// To open the bus hire page

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	private WebElement busHire;

	// To click on login Icon
	@FindBy(how = How.XPATH, using = "//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[2]/div")
	public WebElement login_btn;

	// To click on offers
	@FindBy(how = How.XPATH, using = "//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]")
	public WebElement offers;

	// Selects the offer
	@FindBy(how = How.XPATH, using = "//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]")
	public WebElement select_offer;

	

	// initializing constructor
	WebDriver driver;

	public BusHirePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

//		---------------------PAGE ACTIONS---------------------------
//		To click on bus hire
	public void click_BusHireLink() {
		busHire.click();
	}

//		to click on login icon
	public void click_loginbtn() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(login_btn)).click();
		//login_btn.click();
	}

	// To click on offers
	public void click_offers() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(offers)).click();
		//offers.click();
	}

	// Selects the offer
	public void select_offer() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(select_offer)).click();
		//select_offer.click();
	}


}
