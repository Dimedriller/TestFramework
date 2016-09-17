package com.tanushka.framework.platform.android;

import com.tanushka.framework.platform.Device;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDevice implements Device {
    protected final AndroidDriver mDriver;

    public AndroidDevice(String appPath, String deviceID) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        //not reinstall the app
        capabilities.setCapability("fullReset",false);
        capabilities.setCapability("noReset",true);
        //mandatory capabilities
        capabilities.setCapability("deviceName", deviceID);
        capabilities.setCapability("platformName","Android");
        //other caps
        capabilities.setCapability("app", appPath);

        mDriver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public void closeApp(){
        mDriver.quit();
    }

    public void getScreenshot(String fileName) {
        WebDriver driver1 = new Augmenter().augment(mDriver);
        File file = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ViewElement waitForElement(By by, long timeSeconds) throws TestException {
        try {
            WebDriverWait wait = new WebDriverWait(mDriver, timeSeconds);
            AndroidElement element = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return new AndroidViewElement(element);
        } catch (TimeoutException e) {
            throw new TestException("Timed out after " + timeSeconds
                    + " seconds waiting for presence of element located by: " + by);
        }
        catch (Exception e) {
            throw new TestException(e.getMessage(), e);
        }
    }

    public ViewElement findElement(By by) throws TestException {
        try {
            WebElement webElement = mDriver.findElement(by);
            AndroidElement element = (AndroidElement) webElement;
            return new AndroidViewElement(element);
        } catch (NoSuchElementException e) {
            throw new TestException("An element " + by
                    + " could not be located on the page using the given search parameters");
        }
        catch (Exception e){
            throw new TestException(e.getMessage(), e);
        }
    }

    public ViewElement scrollForElementByName(String name) throws TestException {
        try {
            AndroidElement element = (AndroidElement) mDriver.scrollTo(name);
            return new AndroidViewElement(element);
        } catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
    }

    public ViewElement scrollForSpinnerByName(String name) throws TestException {
        try {
            AndroidElement element = (AndroidElement) mDriver.scrollTo(name);
            element.click();
            return new AndroidViewElement(element);
        } catch (NoSuchElementException e) {
            throw new TestException("An element " + name + " could not be located on the page using the given search parameters");
        }
        catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
    }

    public void swipeByCoordinates(int startX, int startY, int endX, int endY) throws TestException {
        try {
            mDriver.swipe(startX, startY, endX, endY, 150);
        } catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
    }

    public void back() {
        mDriver.sendKeyEvent(AndroidKeyCode.BACK);
    }

    public Boolean isElementDisplayed(By by) throws TestException {
        try {
            WebElement webElement = mDriver.findElement(by);
            AndroidElement element = (AndroidElement) webElement;
            return element.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public void pinchAndZoom() throws TestException {
        try {
            int	scrHeight	=	mDriver.manage().window().getSize().getHeight(); //To get the mobile screen height
            int	scrWidth	=	mDriver.manage().window().getSize().getWidth();//To	get	the	mobile screen width
            MultiTouchAction multiTouch	=	new	MultiTouchAction(mDriver);
            TouchAction tAction0	=	new	TouchAction(mDriver);
            TouchAction	tAction1	=	new	TouchAction(mDriver);
            tAction0.press(scrWidth/2,scrHeight/2).waitAction(1000).moveTo(0,60).release(); //press	finger center of the screen	and	then move	y	axis
            tAction1.press(scrWidth/2,scrHeight/2+40).waitAction(1000).moveTo(0,80).release(); // press	thumb slightly down	on the center of the screen and	then move y axis
            multiTouch.add(tAction0).add(tAction1);
            multiTouch.perform();//	now	perform	both the actions simultaneously	(tAction0 and tAction1)

        } catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
    }

    public void pinchAndZoomOut() throws TestException {
        try {
            int	scrHeight	=	mDriver.manage().window().getSize().getHeight(); //To get the mobile screen height
            int	scrWidth	=	mDriver.manage().window().getSize().getWidth();//To	get	the	mobile screen width
            MultiTouchAction multiTouch	=	new	MultiTouchAction(mDriver);
            TouchAction tAction0	=	new	TouchAction(mDriver);
            TouchAction	tAction1	=	new	TouchAction(mDriver);
            tAction0.press(0,60).waitAction(1000).moveTo(scrWidth/2,scrHeight/2).release(); //press	finger center of the screen	and	then move y	axis
            tAction1.press(0,80).waitAction(1000).moveTo(scrWidth/2,scrHeight/2+40).release(); // press	thumb slightly down	on the center of the screen and	then move y axis
            multiTouch.add(tAction0).add(tAction1);
            multiTouch.perform();//	now	perform	both the actions simultaneously	(tAction0 and tAction1)

        } catch (Exception e){
            throw new TestException(e.getMessage(), e);
        }
    }

    public File takeScreenshot(String outputDir, String fileName) {
        try {
            TakesScreenshot augment = (TakesScreenshot) new Augmenter().augment(mDriver);
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
