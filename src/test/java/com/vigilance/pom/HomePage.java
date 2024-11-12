package com.vigilance.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseClass.BaseClass;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
         this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(xpath = "//*[contains(text(),'Vigil-Eye')]")
    private WebElement clickOnVigilEyeDropdownlist;

    @FindBy(xpath = "//a[contains(@href, 'allot-pending-case')]")
    private WebElement clickOnAllortPendingMenu;

    @FindBy(xpath = "//a[contains(@href, 'allot-attend-case')]")
    private WebElement clickOnAllortAttendMenu;

    @FindBy(xpath = "//a[contains(@href, 'assesssment-approval-case')]")
    private WebElement clickOnAssessmentApprovalCaseMenu;

    @FindBy(xpath = "//a[contains(@href, 'assesssment-feeding')]")
    private WebElement clickOnAssessmentFeedingCaseMenu;

    @FindBy(xpath = "//a[contains(@href, 'assesssment-realisation')]")
    private WebElement clickOnAssessmentRealisationlCaseMenu;

    @FindBy(xpath = "//a[contains(@href, 'marked-cases-i')]")
    private WebElement clickOnMarkedCaseInputMenu;

    @FindBy(xpath = "//a[contains(@href, 'assessment-i')]")
    private WebElement clickOnAssessmentInputMenu;

    @FindBy(xpath = "//a[contains(@href, 'realisation-i')]")
    private WebElement clickOnRealisationInputCaseMenu;

    // Method to click any menu and switch to the new window
    private void clickAndSwitchToNewWindow(WebElement menuElement) throws InterruptedException {
    	Thread.sleep(2000);
        menuElement.click();
        Thread.sleep(2000);
        String parentWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Explicit wait until a new window is opened
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    // Click methods for each menu
    public void clickOnVigilEyeDropdownlist() {
    	driver.switchTo().parentFrame();
		driver.switchTo().frame(0);
        wait.until(ExpectedConditions.elementToBeClickable(clickOnVigilEyeDropdownlist)).click();
    }

    public void clickOnAllotPendingMenu() throws InterruptedException {
        clickAndSwitchToNewWindow(clickOnAllortPendingMenu);
    }

    public void clickOnAllotAttendMenu() throws InterruptedException {
        clickAndSwitchToNewWindow(clickOnAllortAttendMenu);
    }

    public void clickOnAssessmentApprovalCaseMenu() throws InterruptedException {
        clickAndSwitchToNewWindow(clickOnAssessmentApprovalCaseMenu);
    }

    public void clickOnAssessmentFeedingCaseMenu() throws InterruptedException {
        clickAndSwitchToNewWindow(clickOnAssessmentFeedingCaseMenu);
    }

    public void clickOnAssessmentRealisationlCaseMenu() throws InterruptedException {
        clickAndSwitchToNewWindow(clickOnAssessmentRealisationlCaseMenu);
    }

    public void clickOnMarkedCaseInputMenu() throws InterruptedException {
        clickAndSwitchToNewWindow(clickOnMarkedCaseInputMenu);
    }

    public void clickOnAssessmentInputMenu() throws InterruptedException {
        clickAndSwitchToNewWindow(clickOnAssessmentInputMenu);
    }

    public void clickOnRealisationInputCaseMenu() throws InterruptedException {
        clickAndSwitchToNewWindow(clickOnRealisationInputCaseMenu);
    }
}
