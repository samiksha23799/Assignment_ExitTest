package com.redbus.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

//---------------Page Factory--------------------
//To open the bus ticket page
	@FindBy(how = How.ID, using = "redBus")
	public WebElement busTicket;

//To provide data for source location
	@FindBy(how = How.ID, using = "txtSource")
	public WebElement source_location;

//To provide data for destination location
	@FindBy(how = How.ID, using = "txtDestination")
	public WebElement destination_location;

//To provide Date
	@FindBy(how = How.ID, using = "txtOnwardCalendar")
	public WebElement date;

//	To click on search buses
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Search Buses']")
	public WebElement click_searchBus;

	// To click on modify button
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Modify')]")
	public WebElement click_modifyBtn;

	// To click on switch bus route button
	@FindBy(how = How.XPATH, using = "//*[@id=\"switchButton\"]")
	public WebElement switchRoute;

	// To again click the search button after modification
	@FindBy(how = How.XPATH, using = "//*[@id=\"fixer\"]/section/div/div[4]/button")
	public WebElement click_searchModify;

	// To filter the departire time
	@FindBy(how = How.XPATH, using = "//*[@id=\"filter-block\"]/div/div[2]/ul[2]/li[2]")
	public WebElement filter_departure;

	// Assertion for filter check
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/ul/li")
	public WebElement get_filterText;

	// Toclick on view Seats
	@FindBy(how = How.XPATH, using = "//*[@id=\"9758475\"]/div/div[2]/div[1]")
	public WebElement click_ViewSeats;

	// To select the seat price
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'399')]")
	public WebElement select_seatPrice;

	// verify that the view seats get oppened
	// To select the seat price
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'seat legend')]")
	public WebElement verify_seatCheck;

	// initializing constructor
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

//	---------------------PAGE ACTIONS---------------------------
	public void clickBusTicket() {
		busTicket.click();
	}

	public void enter_source(String fromLocation) {
		source_location.clear();
		source_location.sendKeys(fromLocation);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		source_location.sendKeys(Keys.DOWN);
		source_location.sendKeys(Keys.UP);
		source_location.sendKeys(Keys.ENTER);
	}

	public void enter_dest(String toLocation) {
		destination_location.clear();
		destination_location.sendKeys(toLocation);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		destination_location.sendKeys(Keys.DOWN);
		destination_location.sendKeys(Keys.UP);
		destination_location.sendKeys(Keys.ENTER);
	}

	// To provide Date
	public void date(String journeydate) {
		date.sendKeys(journeydate);
	}

//	To click on search buses
	public void clickOnSearchBusesButton() {
		click_searchBus.click();

	}

	// To click on modify button
	public void click_modifyButton() {
		click_modifyBtn.click();
	}

	// To click on switch bus route button
	public void click_switchRoute() {
		// Explicitly Wait
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(switchRoute));
		switchRoute.click();
	}

//	To click on search buses
	public void searchbtn() {
		click_searchModify.click();

	}

	// To filter the departure time
	public void departure_filter() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(filter_departure)).click();
	}

	// Assertion for filter check
	public String get_filterText() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(filter_departure));
		return get_filterText.getText();
	}

	// To click on view seats
	public void click_viewSeats() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(click_ViewSeats)).click();

	}

	// To select the seat price
	public void select_seatPrice() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(select_seatPrice)).click();
	}
	
	public String verify_seatcheck() {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(verify_seatCheck));
		return verify_seatCheck.getText();
	}

}
