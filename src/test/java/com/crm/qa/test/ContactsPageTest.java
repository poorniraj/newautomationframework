package com.crm.qa.test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.page.ContactsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage1;
import com.crm.qa.page.LoginPage2;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactsPageTest extends TestBase {
    LoginPage1 loginpage1;
    LoginPage2 loginpage2;
    HomePage homepage;
    ContactsPage contactsLink;
    TestUtil testUtil;
    //String sheetName = "Sheet1";

    public ContactsPageTest(){
        super();

    }
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        testUtil =new TestUtil();
        loginpage1=new LoginPage1();
        loginpage2= loginpage1.validateLogin2();
        loginpage2 =new LoginPage2();
        contactsLink = new ContactsPage();
        homepage= loginpage2.validateLogin1(prop.getProperty("username"),prop.getProperty("password"));
        //testUtil.getTestData();


    }

    @Test(priority = 1)
    public void verifyContactsLabelTest(){
        Assert.assertTrue(contactsLink.verifyContactsLabel(),"contact label is missing on the page");
    }


    @DataProvider
    public Object[][] getFreeCRMTestData(){
        Object data[][] = TestUtil.getExcelData("FreeCRMtestData.xlsx","Sheet1" );
        return data;
    }

    @Test(priority = 2,dataProvider =  "getFreeCRMTestData")
    public void validateAddContact(String firstName, String lastName, String company) throws InterruptedException {
        homepage.clickOnAddContacts();
        //contactsLink.addContacts("Angel","sts","Facebook");
        contactsLink.addContacts(firstName,lastName,company);
    }
    @Test(priority = 3)
    public void verifyContactsByNameTest() throws InterruptedException {
        contactsLink.verifyContactsByName("Manju");
        // contactsLink.verifyContactsByName("Sam Mathew");
        //contactsLink.verifyContactsByName();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
