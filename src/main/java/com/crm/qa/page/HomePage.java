package com.crm.qa.page;

import com.crm.qa.TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
        //Page object
        @FindBy(xpath = "//span[contains(text(),'nitha sa')]")
        WebElement usernameLabel;
        @FindBy(xpath= "//span[contains(text(),'Contacts')]")
        WebElement contactsLink;
        @FindBy(xpath= "//i[@class='users icon']")
        WebElement contactsIcon;
        @FindBy(xpath= "//body/div[@id='ui']/div[1]/div[1]/div[3]/button[1]/i[1]")
        WebElement addContact;
        @FindBy(xpath= "//span[contains(text(),'Deals')]")
        WebElement dealsLink;
        @FindBy(xpath= "//span[contains(text(),'Tasks')]")
        WebElement tasksLink;

        //Initializing the PageObject
        public HomePage(){
            PageFactory.initElements(driver,this);
        }
        //Actions
        public boolean verifyUsernameLabel(){
            return usernameLabel.isDisplayed();
        }

        public String verifyHomePageTitle(){
            return driver.getTitle();
        }

        public ContactsPage clickOnContactsLink(){
            contactsLink.click();
            return new ContactsPage();  }
        public ContactsPage clickOnAddContacts() throws InterruptedException {
            Thread.sleep(5000);
            contactsIcon.click();
            Thread.sleep(5000);
            Actions action = new Actions(driver);
            action.moveToElement(addContact).build().perform();
            Thread.sleep(5000);
            addContact.click();
            return new ContactsPage();
        }

        public DealsPage clickOnDealsLink(){
            contactsLink.click();
            return new DealsPage();
        }

        public TasksPage clickOnTasksLink(){
            tasksLink.click();
            return new TasksPage();
        }


    }

