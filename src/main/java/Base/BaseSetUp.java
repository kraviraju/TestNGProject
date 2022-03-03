package Base;

import java.io.File;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Utilities.CommonLibrary;
import Utilities.Log;

public class BaseSetUp {
    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myaccountpage;

    public WebDriver getDriver() {
        return driver;
    }

    
    
    @BeforeClass
    public void BrowserSetup() {
    	
    // Chrome Implementation	
    	ChromeOptions chromeOptions;
    	chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		String path =System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		System.out.println("Chrome Driver Path : "+path);
		Log.info("Chrome Driver Path : "+path);
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver(chromeOptions);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
    }
    
    
    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myaccountpage = new MyAccountPage(driver);
        

    }
    
  
    @AfterClass
    public void teardown() {
        driver.quit();
    }
    
    
    
}