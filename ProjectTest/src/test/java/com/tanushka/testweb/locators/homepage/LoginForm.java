package com.tanushka.testweb.locators.homepage;

import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.web.WebDevice;
import com.tanushka.framework.platform.web.WebViewElement;

public class LoginForm {
    public static WebViewElement getUserName(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementById("newUser-form:email");
    }

    public static WebViewElement getPassword(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementById("newUser-form:password");
    }

    public static WebViewElement getLoginButton(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementById("newUser-form:newUser");
    }

    public static WebViewElement getLogoutName(WebDevice device, String name) throws TestException {
        return (WebViewElement) device.findElementByXPath(".//*[@id='logout-form']/div[2]/label[contains(text(), '"
                + name + "')]");
    }
    public static WebViewElement getServiceJumpMenu(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementById("quick-link:jump-menu");
    }
    public static WebViewElement getAutoQuoteMenu(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementByXPath(".//*[@id='quick-link:jump-menu']/option[2][contains(text(), 'Auto Quote')]");
    }

    public static WebViewElement getAgentLookUpMenu(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementByXPath(".//*[@id='quick-link:jump-menu']/option[2][contains(text(), 'Agent Lookup')]");
    }
    public static WebViewElement getSignUpButton(WebDevice device) throws TestException {
        return (WebViewElement) device.findElementById("newUser-form:signup");
    }

}
