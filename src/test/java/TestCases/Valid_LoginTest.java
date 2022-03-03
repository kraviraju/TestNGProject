package TestCases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseSetUp;




public class Valid_LoginTest extends BaseSetUp {

    //Test Data
    String Username = "hotcoolden@gmail.com";
    String Password = "tanuja";

    @Test (priority = 0, description="Valid Login Test")
    public void validLoginTest() throws InterruptedException {
        homePage
            .gotoApplication()
            .goToLoginPage();
        loginPage    
            .login(Username, Password);
        myaccountpage
        	.verifyMyAccountpageTitle("My account - My Store");
        
        loginPage
        	.logout();
    }


}