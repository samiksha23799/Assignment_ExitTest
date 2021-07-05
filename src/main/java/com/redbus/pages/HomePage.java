package com.redbus.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	// ---------------Page Factory--------------------
	// To navigate the rcarebus page
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'redBus Cares')]")
	public WebElement rbus_cares;

//		To select the amount for donation
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'2000')]")
	public WebElement donate;

	// Mode of donation
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[6]/ul[1]/li[2]/span[1]/ul[1]/li[1]/span[1]")
	public WebElement modeofdonation;

	// click donate button
	@FindBy(how = How.CLASS_NAME, using = "donateBtn")
	public WebElement donateButton;

	// To enter the phone number
	@FindBy(how = How.ID, using = "smsTXTBOX")
	public WebElement sms;

	// To get the error_msg
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Invalid Mobile No')]")
	public WebElement error_msg;

	// To click on send link button
	@FindBy(how = How.ID, using = "sendLinkButton")
	public WebElement sendLink;

	// To get the error_msg
	@FindBy(how = How.XPATH, using = "//*[@id=\"phoneWrapper\"]/div[1]/span")
	public WebElement error_msg2;

	// To donate the custom amount
	@FindBy(how = How.ID, using = "otherAmount")
	public WebElement customAmount;

	// To select the mode of Payment
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Net Banking')]")
	public WebElement paymentmode;

	// To verify the nextpage after donationclick
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Select a payment option')]")
	public WebElement PaymentOption;

	// To selects the Bank
	@FindBy(how = How.XPATH, using = "//*[@id=\"reactContentMount\"]/div/div[2]/div[2]/div[3]/div[3]/div[2]/div/div[1]/div[4]/div")
	public WebElement selectbank;

	// To click on PayNow button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'PAY NOW')]")
	public WebElement payNow;

	// initializing constructor
	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

//			---------------------PAGE ACTIONS-------------------------

//		 To navigate the rcarebus page
	public void click_rbus_care() {
		rbus_cares.click();
	}

//	To select the amount for donation
	public void click_donateAmount() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(donate));
		donate.click();
	}

	// Mode of donation
	public void modeofdonation_anonymously() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(modeofdonation));
		modeofdonation.click();
	}

	// click donate button
	public void click_donatebtn() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(donateButton));
		donateButton.click();
	}

	// To enter the phone number
	public void enter_ph(String phone) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(sms));
		sms.sendKeys(phone);
	}

	// To click on send button
	public void click_sendLinkbtn() {
		sendLink.click();
	}

	// To get the error_msg
	public String get_error_msg() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(error_msg));
		return error_msg.getText();
	}

	// To get the error_msg
	public String get_error_msg2() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(error_msg2));
		return error_msg2.getText();
	}

	// To donate the custom amount
	public void otherAmount(String amount) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(customAmount));
		customAmount.sendKeys(amount);
	}

	// To select the mode of Payment
	public void Select_paymentMode() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(paymentmode)).click();

	}

	// To verify the nextpage after donationclick
	public String get_PaymentOption() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(PaymentOption));
		return PaymentOption.getText();
	}

	// To selects the Bank
	public void Select_bank() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(selectbank)).click();

	}
	
	// To click on PayNow Button
		public void click_paynow() {
			new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(payNow)).click();

		}

}
