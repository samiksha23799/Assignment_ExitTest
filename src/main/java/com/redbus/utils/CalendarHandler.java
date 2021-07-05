package com.redbus.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CalendarHandler {
	public static List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		public static void selectDateAndTimeAtBusHirePage(WebDriver driver, String dateAndTime) throws Exception {

			
			if(dateAndTime.equals("")) {
				
				throw new Exception("Empty date and time");
			}
			// Date And Time Format DD-MM-YEAR-HH:MM AM/PM
			String[] dateAndTimeValue = dateAndTime.split("-");

			String date = dateAndTimeValue[0];
			int monthNumber = Integer.parseInt(dateAndTimeValue[1]); 
			String monthName = months.get(monthNumber-1);
			String YYYY = dateAndTimeValue[2];

			String time = dateAndTimeValue[3];

			// splitting the time
			String[] timeValue = time.split(":");
			String HH = timeValue[0];

			// splitting AM or PM
			String[] amOrpmList = timeValue[1].split(" ");
			String MM = amOrpmList[0];
			String AMorPM = amOrpmList[1];


			// selecting through table - if equal to month and year then select date
			String monthYear = monthName.concat(" "+YYYY);
			String monthYearTitle;

			WebElement nextButton;
			//WebElement prevButton;
			WebElement okButton;

			WebElement calDay;
			WebElement calHH;
			WebElement calMM;
			WebElement calAMorPM;

			boolean requiredDate = false;
			try {

				Thread.sleep(500);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}


			while(!requiredDate) {

				monthYearTitle = driver.findElement(By.xpath("//div[@class='MuiPickersCalendarHeader-switchHeader']//p")).getText();
				if(monthYear.equals(monthYearTitle)) {
									
					
					// selecting day
					calDay = driver.findElement(By.xpath("//*[text() = '"+date+"' and @class = 'MuiTypography-root MuiTypography-body2 MuiTypography-colorInherit']"));
					calDay.click();
					
					// selecting time HH
					calHH = driver.findElement(By.xpath("//*[text() = '"+HH+"' and @class = 'MuiTypography-root MuiPickersClockNumber-clockNumber MuiTypography-body1']"));
					Actions actionHH =  new Actions(driver);
					actionHH.moveToElement(calHH).click().perform();
					
					
					try {

						Thread.sleep(500);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}

					// selecting time MM
					calMM = driver.findElement(By.xpath("//*[text() = '"+MM+"' and @class = 'MuiTypography-root MuiPickersClockNumber-clockNumber MuiTypography-body1']"));
					Actions actionMM =  new Actions(driver);
					actionMM.moveToElement(calMM).click().perform();
					

					// selecting time AMorPM
					calAMorPM = driver.findElement(By.xpath("//*[text() = '"+AMorPM+"']"));
					Actions actionAM =  new Actions(driver);
					actionAM.moveToElement(calAMorPM).click().perform();
		
					// click on ok button
					okButton = driver.findElement(By.xpath("//div[@class= 'MuiDialogActions-root MuiDialogActions-spacing']//button[2]"));
					okButton.click();
					
					requiredDate = true;
				}
				else {

					nextButton = driver.findElement(By.xpath("//div[@class='MuiPickersCalendarHeader-switchHeader']//button[2]")); 
					nextButton.click();
				}
			}


		}

	
	public static int getMonthJavaInt(String monthName) throws ParseException 
	{

		Date date = new SimpleDateFormat("MMMM").parse(monthName);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}
}
