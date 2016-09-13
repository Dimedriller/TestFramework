package com.tanushka.framework.platform;

import org.openqa.selenium.By;

public interface ViewElement {
    ViewElement findElement(By by) throws TestException;

    //ViewElement findLastElement (String xPath) throws TestException;
    void longPress () throws TestException;
    void click () throws TestException;
    void sendKeys(String keys) throws TestException;
    void scrollTo(String lookUpText) throws TestException;

    void verifyTextAttribute(String text) throws TestException;
}
