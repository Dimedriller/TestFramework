package com.tanushka.testweb.helpers;

import com.tanushka.framework.platform.*;
import com.tanushka.framework.platform.web.WebDevice;
import com.tanushka.testweb.locators.LoginForm;

public class LoginHelper extends TestHelper {
    public LoginHelper(BaseTest test) {
        super(test);
    }

    public void login(WebDevice device, String userName, String password) throws TestException {
        logStep("Step 1:Enter email john.smith@gmail.com in login-form:email<br>"+
                "Expected Result: Email john.smith@gmail.com is introduced<br>");

        ViewElement loginField = LoginForm.getUserName(device);
        loginField.sendKeys(userName);

        logStep("Step 2:Enter password john in login-form:password<br>"+
                "Expected Result: Password john is introduced<br>");

        ViewElement passwordField = LoginForm.getPassword(device);
        passwordField.sendKeys(password);

        logStep("Step 3:Click LogIn button<br>"+
                "Expected Result: Notice Logged in as John Smith is displayed <br>");

        ViewElement loginBtn = LoginForm.getLoginButton(device);
        loginBtn.click();

        LoginForm.getLogoutName(device, "John");
    }
}
