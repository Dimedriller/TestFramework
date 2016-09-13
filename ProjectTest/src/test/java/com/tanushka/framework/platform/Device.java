package com.tanushka.framework.platform;

import org.openqa.selenium.By;

import java.io.File;

public interface Device {
    void closeApp();
    void getScreenshot(String fileName);

    ViewElement waitForElement(By by, long timeSeconds) throws TestException;
    ViewElement findElement(By by) throws TestException;

    ViewElement scrollForElementByName(String name) throws TestException;
    ViewElement scrollForSpinnerByName(String name) throws TestException;

    void swipeByCoordinates(int startX, int startY, int endX, int endY)  throws TestException;
    void back();
    Boolean isElementDisplayed(By by) throws TestException;

    void pinchAndZoom() throws TestException;
    void pinchAndZoomOut() throws TestException;

    File takeScreenshot(String outputDir, String fileName);

}
