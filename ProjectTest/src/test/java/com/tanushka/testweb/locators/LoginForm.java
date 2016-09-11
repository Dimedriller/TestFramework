package com.tanushka.testweb.locators;

import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.web.WebDevice;
import com.tanushka.framework.platform.web.WebViewElement;

public class LoginForm {
    public static WebViewElement getUserName(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementById("login-form:email");
    }

    public static WebViewElement getPassword(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementById("login-form:password");
    }

    public static WebViewElement getLoginButton(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementById("login-form:login");
    }

    public static WebViewElement getLogoutName(WebDevice device, String name) throws TestException {
        return (WebViewElement) device.findElementByXPath(".//*[@id='logout-form']/div[2]/label[contains(text(), '"
                + name + "')]");
    }
}
