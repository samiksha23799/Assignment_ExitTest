package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TicketDetailsPage {

	// ---------------Page Factory--------------------
	// To click on manage booking
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Manage Booking')]")
	public WebElement managebooking;

	// To click on show my ticket
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show My Ticket')]")
	public WebElement showMyTicket;

	// To verify the print ticket Page
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'PRINT TICKET')]")
	public WebElement printTicket;

	// To enter the ticket number
	@FindBy(how = How.ID, using = "searchTicketTIN")
	public WebElement enterTicketNumber;

	// To enter the email used for booking
	@FindBy(how = How.ID, using = "searchTicketEmail")
	public WebElement enterEmail;

	// To search the ticket
	@FindBy(how = How.ID, using = "ticketSearch")
	public WebElement ticketSearch;

	// To verify the e-ticket Page
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'eTICKET')]")
	public WebElement eticket;
	
	// To get the error msg
	@FindBy(how = How.ID, using= "nf_error")
	public WebElement error_msg;

	// initializing constructor
	WebDriver driver;

	public TicketDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

//				---------------------PAGE ACTIONS-------------------------

	public void click_managebooking() {
		managebooking.click();
	}

	public void click_showMyTicket() {
		showMyTicket.click();
	}

	public String getText_printticketPage() {
		return printTicket.getText();
	}

	public void enter_ticketNumber(String ticketno) {
		enterTicketNumber.sendKeys(ticketno);
	}

	public void enter_eMail(String email) {
		enterEmail.sendKeys(email);
	}

	public void click_searchTicket() {
		ticketSearch.click();
	}
	
	public String getText_eTicketPage() {
		return eticket.getText();
	}
	
	public String getText_error_msg() {
		return error_msg.getText();
	}
}
