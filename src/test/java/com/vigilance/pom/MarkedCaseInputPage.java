package com.vigilance.pom;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarkedCaseInputPage {
	WebDriver driver;
	
	public MarkedCaseInputPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'marked-cases')]")
	private WebElement clickOnMarkedCaseInputsMenu;
	
	@FindBy(xpath = "//h1[contains(text(),'Marked Cases')]")
	private WebElement tocheckMarkedCaseInputMenuIsClickOn;

	@FindBy(xpath = "//label[.='Select Zone']")
	private WebElement clickOnZoneDropdownList;

	@FindBy(xpath = "//p[.='Select Circle(s)']")
	private WebElement clickOnCircleDropdownList;

	@FindBy(xpath = "//p[.='Select Division(s)']")
	private WebElement clickOnDivisionDropdownList;

	@FindBy(xpath = "//input[@id='react-select-2-input']")
	private WebElement selectZone;

	@FindBy(xpath = "//input[@id='react-select-3-input']")
	private WebElement selectCircle;

	@FindBy(xpath = "//input[@id='react-select-4-input']")
	private WebElement selectDivision;

	@FindBy(xpath = "//input[@id='fromdate']")
	private WebElement enterFromDate;

	@FindBy(xpath = "//input[@id='uptodate']")
	private WebElement enterUptoDate;

	@FindBy(xpath = "//input[@id='lowerlimit']")
	private WebElement enterLowerLimitInContractDemand;

	@FindBy(xpath = "//input[@id='upperlimit']")
	private WebElement enterUpperLimitInContractDemand;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickOnSubmitButton;

	@FindBy(xpath = "//div[text()='Required Zone']")
	private WebElement selectZoneAlertMessage;

	@FindBy(xpath = "//div[text()='Required Circle']")
	private WebElement selectCircleAlertMessage;

	@FindBy(xpath = "//div[text()='Required Division']")
	private WebElement selectDivisionAlertMessage;

	@FindBy(xpath = "//div[.='Upto Date cannot be in future']")
	private WebElement selectFutureDateAlertMessageInUptodateFormat;

	@FindBy(xpath = "//div[text()='From Date cannot be in future']")
	private WebElement selectFutureDateAlertMessageInFromDateFormat;

	@FindBy(xpath = "//h1[@class='italic font-semibold']")
	private WebElement checkCountOfTotalMarkedAbstractCases;

	@FindBy(xpath = "(//table[@class='MuiTable-root css-1dh5pc2']/tbody/tr)[1]/td")
	private List<WebElement> markedAbstractCasesAllDetails;

	@FindBy(xpath = "(//table[@class='MuiTable-root css-1dh5pc2']/tbody/tr)[1]/td[5]/button")
	private WebElement clickOnTotalMarkedCasesHyperLink;

	
	@FindBy(xpath = "(//div[@class='p-4'])[1]/div[1]/div")
	private WebElement selectfromDateAlertMessage;
	
	@FindBy(xpath = "(//div[@class='p-4'])[1]/div[2]/div")
	private WebElement selectToDateAlertMessage;

	@FindBy(xpath = "(//table[@class='MuiTable-root css-1dh5pc2'])[2]/tbody/tr[1]/td")
	private List<WebElement> markedCasesListDetails;

	@FindBy(xpath = "(//button[contains(text(),'DVVNL')])[1]")
	private WebElement clickOnCaseNoHyperLink;

	public void clickOnMarkedCaseInputsMenu() {
		clickOnMarkedCaseInputsMenu.click();
	}

	/*
	 * public void clickOnZoneDropdownList() { clickOnZoneDropdownList.click(); }
	 * 
	 * public void clickOnCircleDropdownList() { clickOnCircleDropdownList.click();
	 * }
	 * 
	 * public void clickOnDivisionDropdownList() {
	 * clickOnDivisionDropdownList.click(); }
	 * 
	 * public void selectZone(String zone) { selectZone.sendKeys(zone); }
	 * 
	 * public void selectCircle(String circle) { selectCircle.sendKeys(circle); }
	 * 
	 * public void selectDivision(String division) {
	 * selectDivision.sendKeys(division); }
	 */
	
	public void selectZone(String zone) {
	    clickOnZoneDropdownList.click();  // Click on the dropdown to reveal the options
	    selectZone.sendKeys(zone);  // Type the zone name
	    // Wait and select the option if it appears in the list
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement zoneOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + zone + "')]")));
	    zoneOption.click();  // Click to select the filtered option
	}

	public void selectCircle(String circle) {
	    clickOnCircleDropdownList.click();  // Click on the dropdown to reveal options
	    selectCircle.sendKeys(circle);  // Type the circle name
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement circleOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + circle + "')]")));
	    circleOption.click();
	}

	public void selectDivision(String division) {
	    clickOnDivisionDropdownList.click();  // Click on the dropdown to reveal options
	    selectDivision.sendKeys(division);  // Type the division name
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement divisionOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + division + "')]")));
	    divisionOption.click();
	}

	public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-----yyyy");
        return formatter.format(date);
    }

	
	    public void enterFromDate(Date fromDate) { 
		  String formattedDate = formatDate(fromDate);
	    enterFromDate.clear();
	     enterFromDate.sendKeys(formattedDate); }
	  
	   public void enterUptoDate(Date uptoDate) { 
		  String formattedDate = formatDate(uptoDate); 
		  enterUptoDate.clear();
	      enterUptoDate.sendKeys(formattedDate); }
	 
	
	
		/*
		 * public void enterFromDate() { enterFromDate.click(); }
		 * 
		 * public void enterUptoDate() { enterUptoDate.click(); }
		 */
	 

	public void enterLowerLimitInContractDemand(String lowerLimit) {
		enterLowerLimitInContractDemand.sendKeys(lowerLimit);
	}

	public void enterUpperLimitInContractDemand(String upperLimit) {
		enterUpperLimitInContractDemand.sendKeys(upperLimit);
	}

	public void clickOnSubmitButton() {
		clickOnSubmitButton.click();
	}

	public String getZoneAlertMessage() {
		return selectZoneAlertMessage.getText();
	}

	public String getCircleAlertMessage() {
		return selectCircleAlertMessage.getText();
	}
	
	
	public String getfromDateAlertMessage() {
		return selectfromDateAlertMessage.getText();
	}
	
	public String getUptoDateAlertMessage() {
		return selectToDateAlertMessage.getText();
	}

	public String getDivisionAlertMessage() {
		return selectDivisionAlertMessage.getText();
	}

	public String getFutureDateAlertMessageInUptoDateFormat() {
		return selectFutureDateAlertMessageInUptodateFormat.getText();
	}

	public String getFutureDateAlertMessageInFromDateFormat() {
		return selectFutureDateAlertMessageInFromDateFormat.getText();
	}

	public String checkCountOfTotalMarkedAbstractCases() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement countOfTotalMarkedAbstractCases = wait.until(ExpectedConditions.visibilityOf(checkCountOfTotalMarkedAbstractCases));

		String text = countOfTotalMarkedAbstractCases.getText().trim();
		// Remove all non-numeric characters to extract the count
		String countOfTotalMarkedCases = text.replaceAll("\\D+", "");

		return countOfTotalMarkedCases;
	}
	public List<String> markedAbstractCasesAllDetails(){
		ArrayList<String> markedCasesAllDetails=new ArrayList<String>();
		for(int i=1; i<markedAbstractCasesAllDetails.size();i++) {
			markedCasesAllDetails.add(markedAbstractCasesAllDetails.get(i).getText().trim());
		}
		return markedCasesAllDetails;
	}
	public void clickOnTotalMarkedCasesHyperLink() {
		clickOnTotalMarkedCasesHyperLink.click();
	}

	public List<String> markedCasesListDetails(){
		ArrayList<String> markedCasesListDetail=new ArrayList<String>();
		for(int i=1; i<markedCasesListDetails.size();i++) {
			markedCasesListDetail.add(markedCasesListDetails.get(i).getText().trim());
		}
		return markedCasesListDetail;
	}
	public void clickOnCaseNoHyperLink() {
		clickOnCaseNoHyperLink.click();
	}
   public boolean  tocheckMarkedCaseInputMenuIsClickOn() {
	  boolean markedCaseInputMenuIsClickOn = tocheckMarkedCaseInputMenuIsClickOn.isDisplayed();
	//  assertEquals(markedCaseInputMenuIsClickOn, true);
	return markedCaseInputMenuIsClickOn;
	  
   }
}
