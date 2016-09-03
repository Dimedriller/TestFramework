package com.tanushka.phonetest;

import java.io.File;

/**
 * Created by Home on 15.02.2016.
 */
public interface Device {
    void closeApp();
    void getScreenshot(String fileName);

    ViewElement waitForElement(String id, long timeSeconds) throws TestException;
    ViewElement findElementById(String id) throws TestException;
    ViewElement findElementByXPath(String id) throws TestException;
    ViewElement findElementByClassName(String className) throws TestException;
    ViewElement findElementByName (String name) throws TestException;
    ViewElement scrollForSpinnerByName(String name) throws TestException;
    ViewElement scrollForElementById(String id) throws TestException;
    ViewElement scrollForElementByName(String name) throws TestException;
    void swipeByCoordinates(int startX,int startY,int endX,int endY)  throws TestException;
    void back();
    Boolean isElementDisplayed(String id) throws TestException;

    void pinchAndZoom() throws TestException;
    void pinchAndZoomOut() throws TestException;


    File takeScreenshot(String outputDir, String fileName);

}
