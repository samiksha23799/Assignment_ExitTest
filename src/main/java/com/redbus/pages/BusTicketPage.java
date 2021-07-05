package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BusTicketPage {

//---------------Page Factory--------------------
//To open the bus ticket page
	@FindBy(how = How.ID, using = "redBus")
	private WebElement busTickets;

//	To click on cancel button
	@FindBy(how = How.LINK_TEXT, using = "Cancel Ticket")
	public WebElement cancelbutton;

//	To click on cancel button
	@FindBy(how = How.LINK_TEXT, using = "Print/SMS Ticket")
	public WebElement printbutton;

// header of print/sms page
	@FindBy(how = How.CLASS_NAME, using = "header")
	public WebElement pageheader;



	// initializing constructor
	WebDriver driver;

	public BusTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

//		---------------------PAGE ACTIONS-------------------------

	// To open the bus ticket page
	public void click_busticket() {
		busTickets.click();
	}

//	To click on cancel button
	public void click_cancelButton() {
		cancelbutton.click();
	}

//	To click on Print/SMS button
	public void click_printButton() {
		printbutton.click();
	}

// To get the text of the header
	public String get_headerText() {
		return pageheader.getText();
	}



}
