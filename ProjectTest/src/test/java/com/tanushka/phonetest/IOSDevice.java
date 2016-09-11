package com.tanushka.phonetest;

import java.io.File;

public class IOSDevice implements Device {
    public void closeApp() {

    }

    public void getScreenshot(String fileName) {

    }

    public ViewElement waitForElement(String id, long timeSeconds) throws TestException {
        return null;
    }

    public ViewElement findElementById(String id) throws TestException {
        return null;
    }

    public ViewElement findElementByXPath(String id) throws TestException {
        return null;
    }

    public ViewElement findElementByClassName(String className) throws TestException {
        return null;
    }

    public ViewElement findElementByName(String name) throws TestException {
        return null;
    }

    public ViewElement scrollForSpinnerByName(String name) throws TestException {
        return null;
    }

    public ViewElement scrollForElementById(String id) throws TestException {
        return null;
    }

    public ViewElement scrollForElementByName(String name) throws TestException {
        return null;
    }

    public void swipeByCoordinates(int startX, int startY, int endX, int endY) throws TestException {

    }

    public void back() {

    }

    public Boolean isElementDisplayed(String id) throws TestException {
        return null;
    }

    public void pinchAndZoom() throws TestException {

    }

    public void pinchAndZoomOut() throws TestException {

    }

    public File takeScreenshot(String outputDir, String fileName) {
        return null;
    }
}
