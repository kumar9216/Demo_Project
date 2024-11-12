package com.vigilance.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CaseDetailsPage  {
	WebDriver driver;
	public CaseDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Consumer Information')]")
	private WebElement clickONConsumerInformationDropdown;

	@FindBy(xpath = "//div[@class='grid sm:grid-cols-5 mb-2 p-4']//p")
	private List<WebElement> ConsumerInformation;

	@FindBy(xpath = "//p[contains(text(),'Marking Detail')]")
	private WebElement clickONMarkingDetailsDropdown;

	@FindBy(xpath = "(//tbody[@class='MuiTableBody-root css-1xnox0e'])[2]/tr/td")
	private List<WebElement> markingDetails;

	@FindBy(xpath = "(//div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19'])[2]")
	private WebElement clickOnNextButton;

	public void clickOnConsumerInformationDropdownlist() {
		clickONConsumerInformationDropdown.click();
	}
	public List<String> fetchedConsumerInformation() {
		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < ConsumerInformation.size(); i++) {
			al.add(ConsumerInformation.get(i).getText());
		}
		return al;
	}
	public void clickOnMarkingDetailsDropdownlist() {
		clickONMarkingDetailsDropdown.click();
	}
	public List<String> fetchedMarkingDetails() {
		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < markingDetails.size(); i++) {
			al.add(markingDetails.get(i).getText());
		}
		return al;
	}
	public void clickOnNextButton() {
		clickOnNextButton.click();
	}
}
