package com.baseClass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.time.Duration;

public class BaseClass2 {

    public String baseUrl="http://45.114.143.206:9080/testing/shalu/latest/mri_analysis/";
    public String userName="Test@sai";            
    public String password="Test@123"; 
    public String userNameAt="AT@DIV211211";            
    public String passwordAt="SAI@0143";
    public static WebDriver driver;
    public static Logger logger;
    public String zoneName="ALIGARH_ZONE";
    public String circleName="EUDC-ALIGARH";
    public String divisionName="EUDD-I ALIGARH";
    public String fromDate="09-08-2024";
    public String uptoDate="04-12-2024";
    
      static {
      System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
      }
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        logger = Logger.getLogger("Vigilance");
        PropertyConfigurator.configure("Log4j.properties");
     
    }

    @AfterMethod
    
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed and WebDriver terminated");
        }
    }
}