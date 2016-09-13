package com.tanushka.framework.platform.ios;

import com.tanushka.framework.platform.Device;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import org.openqa.selenium.By;

import java.io.File;

public class IOSDevice implements Device {
    public void closeApp() {

    }

    public void getScreenshot(String fileName) {

    }

    public ViewElement waitForElement(By by, long timeSeconds) throws TestException {
        return null;
    }

    public ViewElement findElement(By by) throws TestException {
        return null;
    }

    public ViewElement scrollForElementByName(String name) throws TestException {
        return null;
    }

    public ViewElement scrollForSpinnerByName(String name) throws TestException {
        return null;
    }

    public void swipeByCoordinates(int startX, int startY, int endX, int endY) throws TestException {

    }

    public void back() {

    }

    public Boolean isElementDisplayed(By by) throws TestException {
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
