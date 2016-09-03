package com.tanushka.phonetest;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Created by Home on 31.07.2016.
 */
public class WebDevice implements Device {
    public final WebDriver mWebDriver;

    public WebDevice() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        mWebDriver = new FirefoxDriver(capabilities);

    }

    public void closeApp() {
        mWebDriver.close();
        mWebDriver.quit();
    }

    public void getScreenshot(String fileName) {

    }

    public ViewElement waitForElement(String id, long timeSeconds) throws TestException {
        return null;
    }

    public ViewElement findElementById(String id) throws TestException {
        try {
            WebElement element = mWebDriver.findElement(By.id(id));
            return new WebViewElement(element);
        } catch (NoSuchElementException e) {
            throw new TestException("An element " + id + " could not be located on the page using the given search parameters");
        }
        catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
    }

    public ViewElement findElementByXPath(String id) throws TestException {
        return null;
    }

    public ViewElement findElementByClassName(String className) throws TestException {
        return null;
    }

    public ViewElement findElementByName(String name) throws TestException {
        try {
            WebElement element = mWebDriver.findElement(By.name(name));
            return new WebViewElement(element);
        } catch (NoSuchElementException e) {
            throw new TestException("An element " + name + " could not be located on the page using the given search parameters");
        }
        catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
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

    public File takeScreenshot(String outputDir, String fileName) {
        try {
            TakesScreenshot augment = (TakesScreenshot) new Augmenter().augment(mWebDriver);
            File scrFile = augment.getScreenshotAs(OutputType.FILE);
            outputDir = outputDir.substring(0, outputDir.lastIndexOf('\\')) + "\\html";

            final File saved = new File(outputDir, fileName + ".png");
            FileUtils.copyFile(scrFile, saved);
            return saved;
        } catch (IOException e) {
            return null;
        }
    }


}
