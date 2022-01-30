package com.crm.qa.test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.page.ContactsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage1;
import com.crm.qa.page.LoginPage2;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {
   LoginPage1 loginpage1;
    LoginPage2 loginpage2;
    HomePage homepage;
    ContactsPage contactsLink;

    public HomePageTest(){
        super();
    }
    //testcases should be separated - independent
    //before every testcase -launch the browser and login
    //@Test - execute testcase
    //after every testcase -close the browser
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        loginpage1=new LoginPage1();
        loginpage2 =new LoginPage2();
        loginpage2= loginpage1.validateLogin2();

        contactsLink = new ContactsPage();
        homepage= loginpage2.validateLogin1(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority=1)
    public void homepageTitleTest() {
        String title = homepage.verifyHomePageTitle();
        Assert.assertEquals(title, "Cogmento CRM","HomePage title not matched");
    }
    @Test(priority = 2)
    public void verifyUsernameLabelTest(){
        Assert.assertTrue(homepage.verifyUsernameLabel());
    }
    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        contactsLink = homepage.clickOnContactsLink();
    }

    @Test(priority = 4)
    public void clickOnAddContactsTest() throws InterruptedException {
        contactsLink= homepage.clickOnAddContacts();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}
