package com.tanushka.phonetest;

public interface ViewElement {
    ViewElement findElementByName(String name) throws TestException;
    ViewElement findElementById(String id) throws TestException;
    ViewElement findElementByXPath (String xPath) throws TestException;

    //ViewElement findLastElement (String xPath) throws TestException;
    void longPress () throws TestException;
    void click () throws TestException;
    void sendKeys(String keys) throws TestException;
    void scrollTo(String lookUpText) throws TestException;



    void verifyTextAttribute(String text) throws TestException;
}
