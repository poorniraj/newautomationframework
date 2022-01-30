package com.crm.qa.util;


import com.crm.qa.TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import java.io.IOException;

    public class WebEventListener extends TestBase implements WebDriverEventListener {
        public WebEventListener(){
            super();
        }

        @Override
        public void beforeAlertAccept(WebDriver driver) {

        }

        @Override
        public void afterAlertAccept(WebDriver driver) {

        }

        @Override
        public void afterAlertDismiss(WebDriver driver) {

        }

        @Override
        public void beforeAlertDismiss(WebDriver driver) {

        }

        @Override
        public void beforeNavigateTo(String url, WebDriver driver) {
            System.out.println("Before Navigating to " + url);
        }

        @Override
        public void afterNavigateTo(String url, WebDriver driver) {
            System.out.println("Navigated to " + url);
        }

        @Override
        public void beforeNavigateBack(WebDriver driver) {

        }

        @Override
        public void afterNavigateBack(WebDriver driver) {

        }

        @Override
        public void beforeNavigateForward(WebDriver driver) {

        }

        @Override
        public void afterNavigateForward(WebDriver driver) {

        }

        @Override
        public void beforeNavigateRefresh(WebDriver driver) {

        }

        @Override
        public void afterNavigateRefresh(WebDriver driver) {

        }


        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {

        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println("WebElement found by: "+ by);//in the page factory by is driver.findElement
        }

        @Override
        public void beforeClickOn(WebElement element, WebDriver driver) {
            System.out.println("Before clicking on element "+ element );
        }

        @Override
        public void afterClickOn(WebElement element, WebDriver driver) {
            System.out.println("After clicking on element "+ element );//what element is being clicked
        }

        @Override
        public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
            System.out.println("Value of the element  "+ element.toString() +"before any changes made");
        }

        @Override
        public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
            System.out.println("Element value changed to"+ element.toString());
        }

        @Override
        public void beforeScript(String script, WebDriver driver) {

        }

        @Override
        public void afterScript(String script, WebDriver driver) {

        }

        @Override
        public void beforeSwitchToWindow(String windowName, WebDriver driver) {

        }

        @Override
        public void afterSwitchToWindow(String windowName, WebDriver driver) {

        }

        @Override
        public void onException(Throwable error, WebDriver driver) {

            System.out.println("Exception occurred: " + error);
            try
            {
                TestUtil.takeScreenshotAtEndOfTest();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public <X> void beforeGetScreenshotAs(OutputType<X> target) {

        }

        @Override
        public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
            System.out.println("Screenshot taken");
        }

        @Override
        public void beforeGetText(WebElement element, WebDriver driver) {

        }

        @Override
        public void afterGetText(WebElement element, WebDriver driver, String text) {

        }
    }


