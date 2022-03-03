package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.BasePage;
import Utilities.Log;


public class MyAccountPage extends BasePage {
	/**Constructor*/
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    
    /**Web Elements*/
    By signOutLink = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
    
    
   
    
    /**Page Methods*/
    //Verify My Account pageTitle
    public void verifyMyAccountpageTitle(String expectedText) {
        waitVisibility(signOutLink);
        Assert.assertEquals(driver.getTitle(), expectedText);
        Log.reportLog("Verify My Account page Title ["+expectedText+"]");
    }
    
}