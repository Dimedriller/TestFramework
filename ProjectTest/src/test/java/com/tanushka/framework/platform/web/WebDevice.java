package com.tanushka.framework.platform.web;

import com.google.common.base.Predicate;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

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

        if ("firefox".equals(browser)) {
            File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
            FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            mWebDriver = new FirefoxDriver(ffBinary,firefoxProfile);
            return;
        }

        mWebDriver = new ChromeDriver();
    }

    public void closeApp() {
        mWebDriver.quit();
    }

    public void getScreenshot(String fileName) {

    }

    private <T> T waitFor(ExpectedCondition<T> condition, long timeSecs) {
        return new WebDriverWait(mWebDriver, timeSecs).until(condition);
    }

    // Do not remove! For parametrized wait implementation
    // Usage:
    //    wait for specific element
    //    WebElement datepicker = waitFor(presenceOfElementLocated(By.cssSelector("div#ui-datepicker-div")));
    //
    //    datepicker.findElement(By.cssSelector("td.ui-datepicker-today a")).click();
    //
    //    wait until meeting condition for that element
    //    waitFor(datepicker, invisible());
    private void waitFor(WebElement element, Predicate<WebElement> condition, long timeSecs) {
        new WebElementWait(element, timeSecs).until(condition);
    }

    // Do not remove! For parametrized wait implementation
    private static Predicate<WebElement> invisible() {
        return new Predicate<WebElement>() {
            public boolean apply(WebElement element) {
                try {
                    return !element.isDisplayed();
                } catch (StaleElementReferenceException e) {
                    return true;
                }
            }
        };
    }

    private static Predicate<WebElement> any() {
        return new Predicate<WebElement>() {
            public boolean apply(WebElement element) {
                return true;
            }
        };
    }

    public ViewElement waitForElement(By by, long timeSecs) throws TestException {
        try {
            ExpectedCondition<WebElement> expectedCondition = ExpectedConditions.presenceOfElementLocated(by);
            WebElement webElement = waitFor(expectedCondition, timeSecs);
            return new WebViewElement(webElement);
        } catch (Exception e) {
            throw new TestException(e.getMessage(), e);
        }
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
