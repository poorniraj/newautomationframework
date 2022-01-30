package com.crm.qa.test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.page.LoginPage1;
import com.crm.qa.page.LoginPage2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPage1Test extends TestBase {

    private static Logger Log = LogManager.getLogger(LoginPage1Test.class);
    LoginPage1 loginpage1;
    LoginPage2 loginpage2;
    LoginPage1Test(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginpage1=new LoginPage1();

    }

    @Test(priority = 1)
    public void loginPage1TitleTest(){
        String title = loginpage1.validateLoginPage1Title();
        Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud",
                "LoginPage1 title not matched");
    }
    @Test(priority = 2)
    public void FreeCrmLogoTest(){
        boolean logo= loginpage1.validateFreeCrmLogo();
       Log.info("Successfully validated the logo FreeCRM");
        Assert.assertTrue(logo);
    }
    @Test(priority = 3)
    public void validateLogin1Test(){
        loginpage2= loginpage1.validateLogin2();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
