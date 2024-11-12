package com.vigilance.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessmentRealisationPage {
    WebDriver driver;

    public AssessmentRealisationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'ASSESSMENT REALISATION')]")
    private WebElement clickOnAssessmentRealisationMenu;

    @FindBy(xpath = "//div[contains(text(),'Assessment Realisation: Pendency')]")
    private WebElement checkAssessmentRealisationPendency;

    @FindBy(xpath = "(//table[@class='MuiTable-root css-1dh5pc2']/tbody/tr)[1]/td")
    private List<WebElement> assessmentRealisationPendencyDetails;

    @FindBy(xpath = "//p[.='Actions/Rectifications']")
    private WebElement clickOnActionsDropdownList;

    @FindBy(xpath = "(//div[@class='grid grid-cols-2'])[2]//li")
    private List<WebElement> fetchedAction;

    @FindBy(xpath = "//p[.='Case Review Details']")
    private WebElement clickOnCaseReviewDetailsDropdown;

    @FindBy(xpath = "//h2[.='Evidence(s)']/../..//a")
    private WebElement actionEvidence;

    @FindBy(xpath = "//label[.='Assessment Proposed: ']/../p")
    private WebElement assessmentProposed;

    @FindBy(xpath = "//label[.='Remarks:']/../p")
    private WebElement caseRemark;

    @FindBy(xpath = "//p[.='Assessment Details']")
    private WebElement clickOnAssessmentDetailsDropdownList;

    @FindBy(xpath = "(//div[@class='grid  ']//label)[1]/p")
    private WebElement assessmentUnit;

    @FindBy(xpath = "(//div[@class='grid  ']//label)[2]/p")
    private WebElement assessmentAmount;

    @FindBy(xpath = "(//div[@class='grid  ']//label)[3]/p")
    private WebElement assessmentDate;

    @FindBy(xpath = "(//div[@class='grid  ']//label)[4]/p")
    private WebElement assessmentRemark;

    @FindBy(xpath = "//h2[.='Assessment Evidence(s)']/../..//a")
    private WebElement assessmentEvidence;

    @FindBy(xpath = "//p[.='Previous Payment/Realisation Details (if any)']")
    private WebElement clickOnPreviousPaymentRealisationDetailsDropdownList;

    @FindBy(xpath = "(//table[@class='MuiTable-root css-124f4w4'])[2]/tbody/tr[1]/td")
    private List<WebElement> checkPreviousPaymentRealisationDetails;

    @FindBy(xpath = "//p[.='Realisation Details (to be provided)']")
    private WebElement clickOnRealisationDetailsToBeProvidedDropdownList;

    @FindBy(xpath = "//input[@name='pay_amount']")
    private WebElement enterPayAmountInRealisationDetails;

    @FindBy(xpath = "//input[@name='receipt_no']")
    private WebElement enterReceiptNoInRealisationDetails;

    @FindBy(xpath = "//input[@name='remarks']")
    private WebElement enterRemarkInRealisationDetails;

    @FindBy(xpath = "//input[@name='pay_date']")
    private WebElement enterDateInRealisationDetails;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    private WebElement clickOnSubmitButton;

    public void clickOnAssessmentRealisationMenu() {
        clickOnAssessmentRealisationMenu.click();
    }

    public boolean checkAssessmentRealisationPendency() {
        return checkAssessmentRealisationPendency.isDisplayed();
    }

    public List<String> assessmentRealisationPendencyDetails() {
        ArrayList<String> assessmentRealisationPendingDetails = new ArrayList<>();
        for (WebElement detail : assessmentRealisationPendencyDetails) {
            assessmentRealisationPendingDetails.add(detail.getText().trim());
        }
        return assessmentRealisationPendingDetails;
    }

    public void clickOnActionsDropdownList() {
        clickOnActionsDropdownList.click();
    }

    public List<String> fetchedAction() {
        ArrayList<String> action = new ArrayList<>();
        for (WebElement element : fetchedAction) {
            action.add(element.getText());
        }
        return action;
    }

    public void clickOnCaseReviewDetailsDropdown() {
        clickOnCaseReviewDetailsDropdown.click();
    }

    public void clickOnActionEvidence() {
        actionEvidence.click();
    }

    public String fetchedActionEvidence() {
        return actionEvidence.getAttribute("href");
    }

    public String assessmentProposed() {
        return assessmentProposed.getText();
    }

    public String caseRemark() {
        return caseRemark.getText();
    }

    public String assessmentUnit() {
        return assessmentUnit.getText();
    }

    public String assessmentAmount() {
        return assessmentAmount.getText().trim();
    }

    public String assessmentDate() {
        return assessmentDate.getText().trim();
    }

    public String assessmentRemark() {
        return assessmentRemark.getText().trim();
    }

    public void clickOnAssessmentEvidence() {
        assessmentEvidence.click();
    }

    public String fetchedAssessmentEvidence() {
        return assessmentEvidence.getAttribute("href");
    }

    public void clickOnPreviousPaymentRealisationDetailsDropdownList() {
        clickOnPreviousPaymentRealisationDetailsDropdownList.click();
    }

    public List<String> checkPreviousPaymentRealisationDetails() {
        ArrayList<String> previousPaymentRealisation = new ArrayList<>();
        for (WebElement detail : checkPreviousPaymentRealisationDetails) {
            previousPaymentRealisation.add(detail.getText().trim());
        }
        return previousPaymentRealisation;
    }

    public void clickOnRealisationDetailsToBeProvidedDropdownList() {
        clickOnRealisationDetailsToBeProvidedDropdownList.click();
    }

    public void enterPayAmountInRealisationDetails(String payAmount) {
        enterPayAmountInRealisationDetails.sendKeys(payAmount);
    }

    public void enterReceiptNoInRealisationDetails(String receiptNo) {
        enterReceiptNoInRealisationDetails.sendKeys(receiptNo);
    }

    public void enterRemarkInRealisationDetails(String remark) {
        enterRemarkInRealisationDetails.sendKeys(remark);
    }

    public void enterDateInRealisationDetails(String date) {
        enterDateInRealisationDetails.sendKeys(date);
    }
    
    
    public void clickOnSubmitButton() {
    	clickOnSubmitButton.click();
    }
}
