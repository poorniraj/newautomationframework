package com.crm.qa.test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage1;
import com.crm.qa.page.LoginPage2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginPage2Test extends TestBase{
    private static Logger Log = LogManager.getLogger(LoginPage2Test.class);

    LoginPage1 loginpage1;
    LoginPage2 loginpage2;
    HomePage homepage;

    LoginPage2Test() {
        super();
    }
    @BeforeMethod

    public void setUp(){
            initialization();
        Log.info("Driver invoked and launched the browser successfully");
        loginpage1=new LoginPage1();
        loginpage2= loginpage1.validateLogin2();
    }

    @Test(priority=1)
    public void loginPage2TitleTest(){
        String title = loginpage2.validateLoginPage2Title();
        //Log.info("Successfully validated the title");
        //Assert.assertEquals(title, "Cogmento CRM", "LoginPage2 title not matched");
    }
    @Test(priority = 2)
    public void Login1Test() throws InterruptedException
    {
        homepage=loginpage2.validateLogin1(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}


