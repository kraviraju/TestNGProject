package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.BasePage;
import Utilities.Log;
public class HomePage extends BasePage {

    /**Constructor*/
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**Variables*/
    String baseURL = "http://automationpractice.com/index.php";

    /**Web Elements*/
    By signInLink = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");

    /**Page Methods
     * @throws InterruptedException */
    //Go to Homepage
    public HomePage gotoApplication() throws InterruptedException {
    	Log.reportLog("Open My Store Application - Base URL : "+ baseURL);
        driver.get(baseURL);
        Thread.sleep(1000);
        return this;
    }

    //Go to LoginPage
    public LoginPage goToLoginPage() throws InterruptedException {
        click(signInLink);
        Thread.sleep(1000);
        Log.reportLog("Go to Login Page");
        return new LoginPage(driver);
    }
    
    public HomePage verifyHomePageTitle(String str) {
    	
    	if (driver.getTitle().equals(str)) {
    		Log.reportLog("Verify Home page Title ["+str+"] - Success");
    	}else {
    		Log.reportLog("Verify Home page Title ["+str+"] - Fail");
    		Assert.assertEquals(driver.getTitle(), str);
    	}
    	
    	return this;
    }
    
}