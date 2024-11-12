package com.vigilance.pom;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EvidencePage {
    WebDriver driver;

    public EvidencePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//label[text()='Evidence(s)']")
    private WebElement clickONEvedenceDropdown;

    @FindBy(xpath="//input[@id='IRREGULARITY_EVIDENCE_FILE']")
    private WebElement clickONImagefile;

    @FindBy(xpath="(//button[@type='button'])[4]")
    private WebElement clickONEvidenceNextButton;

    @FindBy(xpath="(//button[@type='button'])[6]")
    private WebElement clickONActionNextButton;

    @FindBy(xpath="(//button[@type='button'])[8]")
    private WebElement clickONSubmitButton;

    @FindBy(xpath="(//div[@class='flex  w-6 h-6 bg-white rounded-full  transition translate-x-0'])[3]")
    private WebElement skipActionButton;

    @FindBy(xpath="(//div[@class='flex  w-6 h-6 bg-white rounded-full  transition translate-x-0'])[2]")
    private WebElement notskipActionButton;
    
    @FindBy(xpath="(//div[@class='flex  w-6 h-6 bg-white rounded-full  transition translate-x-0'])[2]")
    private WebElement alertMessage;
   

    public void uploadEvedence() {
    	 String userDirectory = System.getProperty("user.dir");
         String filePath = Paths.get(userDirectory, "TestData", "Picture", "Evidence.png").toString();
        clickONImagefile.sendKeys(filePath);
    }

    public void clickOnDropdownlist() {
        clickONEvedenceDropdown.click();
    }

    public void clickOnEvidencenextButton() {
        clickONEvidenceNextButton.click();
    }

    public void clickOnActionnextButton() {
        clickONActionNextButton.click();
    }

    public void clickOnskipActionButton() {
        skipActionButton.click();
    }

    public void clickOnSubmitButton() {
        clickONSubmitButton.click();
    }

    public void clickOnnotskipActionButton() {
        notskipActionButton.click();
    }
}
