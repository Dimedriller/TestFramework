package com.tanushka.framework.platform.web;

import com.tanushka.framework.platform.Device;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Created by Home on 31.07.2016.
 */
public class WebDevice implements Device {
    private final WebDriver mWebDriver;

    public WebDevice(String browser) {
        if ("ie".equals(browser)) {
            System.setProperty("webdriver.ie.framework", "C:\\Program Files (x86)\\Selenium\\IEDriverServer.exe");
            System.setProperty("webdriver.ie.framework.loglevel", "TRACE");
            System.setProperty("webdriver.ie.framework.logfile", "log\\selenium.log");
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            mWebDriver = new InternetExplorerDriver(ieCapabilities); // IE
            return;
        }

        if ("chrome".equals(browser)) {
            mWebDriver = new ChromeDriver();
            return;
        }

        File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        mWebDriver = new FirefoxDriver(ffBinary,firefoxProfile);
    }

    public void closeApp() {
        mWebDriver.quit();
    }

    public void getScreenshot(String fileName) {

    }

    public ViewElement waitForElement(By by, long timeSeconds) throws TestException {
        return null;
    }

    public ViewElement findElement(By by) throws TestException {
        try {
            WebElement element = mWebDriver.findElement(by);
            return new WebViewElement(element);
        } catch (NoSuchElementException e) {
            throw new TestException("An element " + by
                    + " could not be located on the page using the given search parameters");
        }
        catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
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
        try {
            TakesScreenshot augment = (TakesScreenshot) new Augmenter().augment(mWebDriver);
            File scrFile = augment.getScreenshotAs(OutputType.FILE);
            outputDir = outputDir.substring(0, outputDir.lastIndexOf('\\')) + "\\html";

            final File saved = new File(outputDir, fileName + ".png");
            FileUtils.copyFile(scrFile, saved);
            return saved;
        } catch (IOException e) {
            return null;
        } catch (NoSuchWindowException e) {
            return null;
        }
    }

    public void loadPage(String url) {
        mWebDriver.get(url);
    }
}
