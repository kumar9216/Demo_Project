package com.vigilance.test;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseClass.BaseClass2;
import com.baseClass.LoginPage;
import com.vigilance.pom.MarkedCaseInputPage;

public class MarkedCaseInput extends BaseClass2 {

	// Remove the instantiation of mcp here
	MarkedCaseInputPage mcp;

	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginButton();
		Thread.sleep(2000);

		// Initialize MarkedCaseInputPage after driver setup
		mcp = new MarkedCaseInputPage(driver);

		driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[contains(text(),'Vigil-Eye')]")).click();
		Thread.sleep(2000);
		mcp.clickOnMarkedCaseInputsMenu();

		String parentWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		Thread.sleep(3000);
	}

	@AfterMethod
	public void close() {
		driver.quit();
		logger.info("Test completed");
	}

	@Test
	public void toVerifyMarkedCaseInputMenuIsClicking() {
		assertEquals(mcp.tocheckMarkedCaseInputMenuIsClickOn(), true);
		logger.info("Mark Case Input menu is Clicking successfully");
	}

	@Test(priority = 1)
	public void toverifyWithoutSelectZoneThenAlertMessageIsDisplayed() {
		mcp.clickOnSubmitButton();
		assertEquals(mcp.getZoneAlertMessage(),"Required Zone"); 
		assertEquals(mcp.getCircleAlertMessage(),"Required Circle");
	    assertEquals(mcp.getDivisionAlertMessage(),"Required Division");
        assertEquals(mcp.getfromDateAlertMessage(),"Required");
	    assertEquals(mcp.getUptoDateAlertMessage(),"Required");
	    logger.info("Without select Zone,Circle and Division then Alert Message  is displayed" );								
	}

	@Test(priority = 2)
	public void tocheckCountOfMarkedCaseInput() throws InterruptedException, ParseException {
		mcp.selectZone(zoneName);
		logger.info("Select Zone from dropdown list");
		mcp.selectCircle(circleName);
		logger.info("Select Circle from dropdown list");
		mcp.selectDivision(divisionName);
		logger.info("Select Division from dropdown list");
		Thread.sleep(3000);
		Date fromDate = new SimpleDateFormat("dd-MMM-yyyy").parse("04-Aug-2024"); // Adjusted date format
	   Date uptoDate = new SimpleDateFormat("dd-MMM-yyyy").parse("04-Nov-2024"); // Adjusted date format
	
		
		mcp.enterFromDate(fromDate);  // Enter from date in specified format
		logger.info("Enter from date in date format");
		    
		mcp.enterUptoDate(uptoDate);  // Enter upto date in specified format
		logger.info("Enter UptoDate in date format");
		    
		mcp.clickOnSubmitButton();
		logger.info("Click on submit button");
	}

}
