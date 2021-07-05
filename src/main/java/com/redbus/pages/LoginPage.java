package com.redbus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	// ---------------Page Factory--------------------
	// To click on sign in button on navbar
	@FindBy(how = How.ID, using = "signin-block")
	public WebElement login_icon;

//	Click sign IN 
	@FindBy(how = How.ID, using = "signInLink")
	public WebElement signInLink;

	//To click on google sign in option
	@FindBy(how = How.ID, using = "g_id_onload")
	public WebElement googleSignIn;

	//To selects the user account
	@FindBy(how = How.XPATH, using = "//*[@id=\"credentials-picker\"]/div[1]/div[1]")
	public WebElement user_acc;

	// Enter mobile number
	@FindBy(how = How.ID, using = "mobileNoInp")
	public WebElement ph_number;

	// To switch the driver to iframe
	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement iframe_1;

	// To Check the google page fuctionality
	@FindBy(how = How.CLASS_NAME, using = "ahT6S ")
	public WebElement google_page;

	// When user gets the error msg while login
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter valid mobile number')]")
	public WebElement error_msg;

	// To enter the user email for login
	@FindBy(how = How.XPATH, using = "//*[@id=\"identifierId\"]")
	public WebElement enter_email;

	// To click on next button
	@FindBy(how = How.XPATH, using = "//*[@id=\"identifierNext\"]/div/button/span")
	public WebElement nextbtn;

	// To enter the user password for login
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	public WebElement enter_pwd;

	// To click on next button after entering password
	@FindBy(how = How.XPATH, using = "//*[@id=\"passwordNext\"]/div/button/span")
	public WebElement nextbtn1;

	// To click on confirm button
	@FindBy(how = How.ID, using = "confirm_yes")
	public WebElement confirmBtn;

	// To close the popup
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[2]/div/div/div[2]/i")
	public WebElement close_modal;

	// Verifying wrong email
	@FindBy(how = How.XPATH, using = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
	public WebElement error_wrongemail;

	// Verifying wrong password
	@FindBy(how = How.XPATH, using = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[2]/div[2]/div[2]")
	public WebElement error_wrongpwd;


	// initializing constructor
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

//		---------------------PAGE ACTIONS-------------------------

	public void click_loginIcon() {
		login_icon.click();
	}

	public void click_signIn() {
		signInLink.click();
	}

	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}

	public void click_userAcc() {
		user_acc.click();
	}

	public void enter_MobileNumber(String num) {
		ph_number.sendKeys(num);
		ph_number.sendKeys(Keys.ENTER);
	}

	public String verify_googlePage() {
		return google_page.getText();
	}

	public String Error_Msg() {
		return error_msg.getText();
	}

	public void enter_UserEmail(String email) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(enter_email));
		enter_email.sendKeys(email);
	}

	public void enter_UserPwd(String pwd) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(enter_pwd));
		enter_pwd.sendKeys(pwd);
	}

	public void click_nextbtn() {
		nextbtn1.click();
	}

	public String Error_Msg_WrongEmail() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(error_wrongemail));
		return error_wrongemail.getText();
	}

	public String Error_Msg_WrongPwd() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(error_wrongemail));
		return error_wrongpwd.getText();
	}

}