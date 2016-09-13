package com.tanushka.framework.platform.web;

import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebViewElement implements ViewElement {

    private final WebElement mWebElement;
    //private final WebDriver mWebDriver;

    public WebViewElement(WebElement webElement) {
        mWebElement = webElement;

        //WebDriver webDriver = mWebElement.getWrappedDriver();
        //mWebDriver = (WebDriver) webDriver;
    }

    public ViewElement findElement(By by) throws TestException {
        return null;
    }

    public void longPress() throws TestException {

    }

    public void click() throws TestException {
        try {
            mWebElement.click();
        } catch (Exception e) {
            throw new TestException(e.getMessage(),e);
        }

    }

    public void sendKeys(String keys) throws TestException {
        try {
            mWebElement.sendKeys(keys);

        } catch (Exception e) {
            throw new TestException(e.getMessage(),e);
        }

    }

    public void scrollTo(String lookUpText) throws TestException {

    }

    public void verifyTextAttribute(String text) throws TestException {

    }
}
