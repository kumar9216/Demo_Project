package com.vigilance.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class AllotPendingCasePage  {
  WebDriver driver;
    // Constructor
    public AllotPendingCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Locating + Storing the WebElement
    @FindBy(xpath = "//h1[@class='italic font-semibold']")
    private WebElement checkCountOfAllotPendingCases;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement checkSearchOption;

    @FindBy(xpath = "//a[@id='download-excel']")
    private WebElement downloadAllotPendingCasesInExcelFormat;

    @FindBy(xpath = "//input[@placeholder='Sr No']")
    private WebElement searchThroughSrNo;

    @FindBy(xpath = "//input[@placeholder='View']")
    private WebElement searchThroughView;

    @FindBy(xpath = "//input[@placeholder='Case_No']")
    private WebElement searchThroughCaseNo;

    @FindBy(xpath = "//input[@placeholder='AC_ID']")
    private WebElement searchThroughAC_ID;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement searchThroughName;

    @FindBy(xpath = "//input[@placeholder='Address']")
    private WebElement searchThroughAddress;

    @FindBy(xpath = "//input[@placeholder='Priority']")
    private WebElement searchThroughPriority;

    @FindBy(xpath = "//input[@placeholder='Contract Demand']")
    private WebElement searchThroughContractDemand;

    @FindBy(xpath = "//button[.='View']")
    private WebElement clickOnViewLink;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    private WebElement movetoFieldIrregularitiesPage;

    // Method to get the count of allot pending cases(Action method)
    public String countOfAllotPendingCases() {
        return checkCountOfAllotPendingCases.getText();
    }

    // Method to search using search option input
    public void searchOption(String searchText) {
        checkSearchOption.sendKeys(searchText);
    }

    // Methods to search through different fields
    public void searchThroughSrNo(String searchThroughSrNoText) {
        searchThroughSrNo.sendKeys(searchThroughSrNoText);
    }

    public void searchThroughView(String searchThroughViewText) {
        searchThroughView.sendKeys(searchThroughViewText);
    }

    public void searchThroughCaseNo(String searchThroughCaseNoText) {
        searchThroughCaseNo.sendKeys(searchThroughCaseNoText);
    }

    public void searchThroughAC_ID(String searchThroughAC_IDText) {
        searchThroughAC_ID.sendKeys(searchThroughAC_IDText);
    }

    public void searchThroughName(String searchThroughNameText) {
        searchThroughName.sendKeys(searchThroughNameText);
    }

    public void searchThroughAddress(String searchThroughAddressText) {
        searchThroughAddress.sendKeys(searchThroughAddressText);
    }

    public void searchThroughPriority(String searchThroughPriorityText) {
        searchThroughPriority.sendKeys(searchThroughPriorityText);
    }

    public void searchThroughContractDemand(String searchThroughContractDemandText) {
        searchThroughContractDemand.sendKeys(searchThroughContractDemandText);
    }

    // Method to download report in Excel format
    public void downloadReportInExcelFormat() {
        downloadAllotPendingCasesInExcelFormat.click();
    }

    // Method to click on View link
    public void clickOnViewLink() {
        clickOnViewLink.click();
    }

    // Method to navigate to Field Irregularities page
    public void clickOnMoveToFieldIrregularitiesPage() {
        movetoFieldIrregularitiesPage.click();
    }
}
