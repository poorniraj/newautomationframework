package com.crm.qa.page;

import com.crm.qa.TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {
    @FindBy(xpath= "//div[contains(text(),\"Contacts\")]")
    WebElement contactsLabel;
    @FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]" +
            "/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement firstName;
    @FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]" +
            "/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement lastName;
    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]" +
            "/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
    WebElement companyName;
    @FindBy(xpath= "//i[@class='save icon']")
    WebElement saveButton;

    public ContactsPage(){
        //initialization
        PageFactory.initElements(driver,this);
    }
    //Action
    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }


    public void addContacts(String fname, String lname, String comp) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(firstName).build().perform();

        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        companyName.sendKeys(comp);
        saveButton.click();
    }
    public void verifyContactsByName(String name) throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//..//..//..")).click();
        //* driver.findElement(By.xpath("//a[contains(text(),'tet ll')]")).click();
        //driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
        // + "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }
}
