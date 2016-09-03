package com.tanushka.phonetest;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AndroidViewElement implements ViewElement {
    private final AndroidElement mAndroidElement;
    private final AndroidDriver mAndroidDriver;

    public AndroidViewElement(AndroidElement androidElement) {
        mAndroidElement = androidElement;

        WebDriver webDriver = mAndroidElement.getWrappedDriver();
        mAndroidDriver = (AndroidDriver) webDriver;
    }

    public ViewElement findElementByName(String name) throws TestException{
        try {
            AndroidElement element = (AndroidElement) mAndroidElement.findElement(By.name(name));
            return new AndroidViewElement(element);
        }   catch (NoSuchElementException e) {
                throw new TestException("An element " + name + " could not be located on the page using the given search parameters");
            }
            catch (Exception e){
                throw new TestException(e.getMessage(),e);
            }
    }

    public ViewElement findElementById(String id) throws TestException{
        try {
            AndroidElement element = (AndroidElement) mAndroidElement.findElement(By.id(id));
            return new AndroidViewElement(element);
        }   catch (NoSuchElementException e) {
            throw new TestException("An element " + id + " could not be located on the page using the given search parameters");
        }
        catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
    }

    public ViewElement findElementByXPath(String xPath) throws TestException {
        try {
            By xpath = By.xpath(xPath);
            AndroidElement element = (AndroidElement) mAndroidElement.findElement(xpath);
                return new AndroidViewElement(element);
            }   catch (NoSuchElementException e) {
                throw new TestException("An element " + xPath + " could not be located on the page using the given search parameters");
            }
            catch (Exception e){
                throw new TestException(e.getMessage(),e);
            }
    }


    /*public ViewElement findLastElement(String xPath) throws TestException {
        try {
            int index=1;
            for (int i = 0; i < index; i++) {
                By xpath = By.xpath(xPath+"[@index[index]]");
                AndroidElement element = (AndroidElement) mAndroidElement.findElement(xpath);
                return new AndroidViewElement(element);
                index++;
            }

        }   catch (NoSuchElementException e) {
            throw new TestException("An element " + xPath + " could not be located on the page using the given search parameters");
        }
        catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
    }*/

    public void longPress() throws TestException {
        try {
            TouchAction tAction = new TouchAction((MobileDriver) mAndroidElement.getWrappedDriver());
            tAction.longPress(mAndroidElement).perform();
        } catch (Exception e){
            throw new TestException(e.getMessage(),e);
        }
    }

    public void click() throws TestException {
        try {
            mAndroidElement.click();
        } catch (Exception e) {
            throw new TestException(e.getMessage(),e);
        }
    }

    public void sendKeys(String keys) throws TestException {
        try {
            mAndroidElement.sendKeys(keys);

        } catch (Exception e) {
            throw new TestException(e.getMessage(),e);
        }
    }

    public void scrollTo(String lookUpText) throws TestException {

    }



    public void verifyTextAttribute(String text) throws TestException {
        try {
            String elementText = mAndroidElement.getAttribute("text");
            if (!elementText.equals(text))
                throw new TestException("Wrong text attribute is displayed. Expected: " + text + ", Found: " + elementText);
        } catch (Exception e) {
            throw new TestException(e.getMessage(), e);
        }
    }
}