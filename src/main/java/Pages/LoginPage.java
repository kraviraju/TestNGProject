package Pages;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.BasePage;
import Utilities.Log;

public class LoginPage extends BasePage {

    /**Constructor*/
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**Web Elements*/
    By userNameId = By.id("email");
    By passwordId = By.id("passwd");
    By loginButtonId = By.xpath("//*[@id=\"SubmitLogin\"]/span");
    By errorMessage = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    By myaccounttext = By.xpath("//*[@id=\"center_column\"]/h1");

    By signout = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");

    /******************************** Page Methods *******************************************************/
    public LoginPage login(String username, String password) {
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        boolean exists = driver.findElements(errorMessage).size() != 0;
        if (exists==false) {
        	Log.reportLog("Login success with username ["+username+"] & password ["+password+"] ");
        }else {
        	String strerr = driver.findElement(errorMessage).getText();
        	Log.reportLog("Login failed ["+strerr+"] with username ["+username+"] & password ["+password+"] ");
        }
        return this;
    }

    public LoginPage logout() {
    	driver.findElement(signout).click();
    	 Assert.assertEquals(driver.getTitle(), "Login - My Store");
         Log.reportLog("Verify logout page Title [Login - My Store] - Success");
    	return this;
    }

}