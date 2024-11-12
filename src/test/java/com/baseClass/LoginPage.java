package com.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver cdriver;

    public LoginPage(WebDriver rdriver) {
        cdriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name = "userid")
    @CacheLookup
    WebElement userid;

    @FindBy(name = "password")
    @CacheLookup
    WebElement password;

    @FindBy(id = "button")
    @CacheLookup
    WebElement loginButton;

    public void setUserName(String uname) {
        userid.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
