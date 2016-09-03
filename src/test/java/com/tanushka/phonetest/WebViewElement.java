package com.tanushka.phonetest;

import org.openqa.selenium.WebElement;

/**
 * Created by Home on 31.07.2016.
 */
public class WebViewElement implements ViewElement {

    private final WebElement mWebElement;
    //private final WebDriver mWebDriver;

    public WebViewElement(WebElement webElement) {
        mWebElement = webElement;

        //WebDriver webDriver = mWebElement.getWrappedDriver();
        //mWebDriver = (WebDriver) webDriver;
    }

    public ViewElement findElementByName(String name) throws TestException {
        return null;
    }

    public ViewElement findElementById(String id) throws TestException {
        return null;
    }

    public ViewElement findElementByXPath(String xPath) throws TestException {
        return null;
    }

    public void longPress() throws TestException {

    }

    public void click() throws TestException {
        try {
            mWebElement.submit();
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
