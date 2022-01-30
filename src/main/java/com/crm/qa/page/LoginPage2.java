package com.crm.qa.page;

import com.crm.qa.TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 extends TestBase{

    //Define Object Repository
    @FindBy(xpath=" //input[@type='text']")
    WebElement username;
    @FindBy(xpath="//input[@type='password']")
    WebElement password;
    @FindBy(xpath= "//*[@class= 'ui fluid large blue submit button']")
    WebElement LoginBtn;

    //initialize the page Objects:
    public LoginPage2(){
        PageFactory.initElements(driver,this);
    }

    //Action:features
    public String validateLoginPage2Title(){
        return driver.getTitle();
    }

    public HomePage validateLogin1(String un,String pwd) throws InterruptedException {
        username.sendKeys(un);
        Thread.sleep(1000);
        password.sendKeys(pwd);
        Thread.sleep(1000);
        LoginBtn.click();
        Thread.sleep(1000);
        return new HomePage();
    }
}
