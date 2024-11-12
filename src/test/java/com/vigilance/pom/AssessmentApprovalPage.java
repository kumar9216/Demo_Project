package com.vigilance.pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessmentApprovalPage {
    WebDriver driver;

    public AssessmentApprovalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Assessment Approval')]")
    private WebElement toCheckaasessmentApproval;

    @FindBy(xpath = "//p[contains(text(),'Select Zone')]")
    private WebElement clickOnZoneDropdownList;

    @FindBy(xpath = "//p[contains(text(),'Select Division(s)')]")
    private WebElement clickOnDivisionDropdownList;

    @FindBy(xpath = "//input[@name='zone']")
    private WebElement selectZoneFromDropDownlist;

    @FindBy(xpath = "//input[@name='division']")
    private WebElement selectDivisonFromDropDownlist;

    @FindBy(xpath = "//p[.='Assessment Approvals: Pendency']")
    private WebElement clickOnAssessmentApprovalsPendencydownList;

    @FindBy(xpath = "//h1[@class='italic font-semibold']")
    private WebElement countOfTotalApprovedCase;

    @FindBy(xpath = "//input[@placeholder='Search...']")
    private WebElement searchingElement;

    @FindBy(xpath = "//button[@data-tooltip-id='Excel']")
    private WebElement downloadReportInExcelFormat;

    @FindBy(xpath = "//button[@data-tooltip-id='Copy']")
    private WebElement copytheReportInTextFormat;

    @FindBy(xpath = "(//table[@class='MuiTable-root css-1dh5pc2']/tbody/tr)[1]/td")
    private List<WebElement> allDetail;

    public boolean toCheckaasessmentApprovalPageisDisplayed() {
        return toCheckaasessmentApproval.isDisplayed();
    }

    public void clickOnZoneDropdownList() {
        clickOnZoneDropdownList.click();
    }

    public void clickOnDivisionDropdownList() {
        clickOnDivisionDropdownList.click();
    }

    public void selectDivisonFromDropDownlist(String divName) {
        selectDivisonFromDropDownlist.sendKeys(divName);
    }

    public void selectZoneFromDropDownlist(String zone) {
        selectZoneFromDropDownlist.sendKeys(zone);
    }

    public void clickOnAssessmentApprovalsPendencydownList() {
        clickOnAssessmentApprovalsPendencydownList.click();
    }

    public String countOfTotalApprovedCase() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pendingCasesElement = wait.until(ExpectedConditions.visibilityOf(countOfTotalApprovedCase));
        
        String text = pendingCasesElement.getText().trim();
        // Remove all non-numeric characters to extract the count
        String countOfApprovedCase = text.replaceAll("\\D+", "");
        
        return countOfApprovedCase; // You can change this to return Integer.parseInt(countOfApprovedCase) if needed.
    }
    
    public void searchingElement(String enterElement) {
    	searchingElement.sendKeys(enterElement);
    }
    
    public void downloadReportInExcelFormat() {
    	downloadReportInExcelFormat.click();
    }
    
    public void copytheReportInTextFormat() {
    	copytheReportInTextFormat.click();
    }
    
    public List<String> allDetails(){
    	ArrayList<String>allDetails=new ArrayList<String>();
    	for(int i=0; i<allDetail.size(); i++) {
    		allDetails.add(allDetail.get(i).getText());
    	}
		return allDetails;
    	
    }
}
