package com.tanushka.testweb.locators.createnewaccount;

import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.web.WebDevice;
import com.tanushka.framework.platform.web.WebViewElement;
import org.openqa.selenium.By;

/**
 * Created by Home on 11.09.2016.
 */
public class CreateNewUser {
    public static WebViewElement getFirstName(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("signup:fname"));
    }
    public static WebViewElement getLastName(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("signup:lname"));
    }
    public static WebViewElement getBirthdayTrigger(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("ext-gen4"));
    }
    public static WebViewElement getBirthdayTodayButton(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("ext-gen18"));
    }
    public static WebViewElement getEmail(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("signup:email"));
    }
    public static WebViewElement getAddressStreet(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("signup:street"));
    }
    public static WebViewElement getAddressCity(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("signup:city"));
    }
    public static WebViewElement getStateMenu(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("signup:state"));
    }
    public static WebViewElement getState(WebDevice device, String state) throws TestException {
        return (WebViewElement) device.findElement(By.xpath(".//*[@id='signup:state']/option[contains(text(), '"
                + state + "')]"));
    }
    public static WebViewElement getPostalCode(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("signup:zip"));
    }
    public static WebViewElement getPassword(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("signup:password"));
    }
    public static WebViewElement getSignUpButton(WebDevice device) throws TestException {
        return (WebViewElement) device.findElement(By.id("signup:signup"));
    }
}
