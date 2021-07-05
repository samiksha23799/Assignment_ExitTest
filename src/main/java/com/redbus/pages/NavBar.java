package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class NavBar {

	// ---------------Page Factory--------------------


	@FindBy(how = How.XPATH, using = "//*[@class = \"redbus-logo home-redirect\"]")
	private WebElement redBusLogo;

	@FindBy(how = How.ID, using = "redBus")
	private WebElement busTickets;

	@FindBy(how = How.ID, using = "cars")
	private WebElement rPool;

	@FindBy(how = How.ID, using = "redBus Bus Hire")
	private WebElement busHire;
	
	
	public WebDriver driver;
	public NavBar(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
// ----------------------------PAGE ACTIONS----------------------
//	to click on reb dus logo
	public void click_RedBusLogo() {
		redBusLogo.click();
	}

//	To click on bus ticket logo
	public void click_BusTicketsLink() {
		busTickets.click();
	}

//	To click on bus hire
	public void click_BusHireLink() {
		busHire.click();
	}

//	To click on rpool
	public void click_RPoolLink() {
		rPool.click();
	}



}
