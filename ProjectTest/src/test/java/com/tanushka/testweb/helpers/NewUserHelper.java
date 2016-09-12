package com.tanushka.testweb.helpers;

import com.tanushka.framework.platform.BaseTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.TestHelper;
import com.tanushka.framework.platform.ViewElement;
import com.tanushka.framework.platform.web.WebDevice;
import com.tanushka.testweb.locators.homepage.LoginForm;

/**
 * Created by Home on 11.09.2016.
 */
public class NewUserHelper extends TestHelper {
    public NewUserHelper(BaseTest test) {
        super(test);
    }

    public void newUser(WebDevice device, String userEmail, String password) throws TestException {
        logStep("Step 1:Enter email john.smith@gmail.com in newUser-form:email<br>"+
                "Expected Result: Email john.smith@gmail.com is introduced<br>");

        ViewElement loginField = LoginForm.getUserName(device);
        loginField.sendKeys(userEmail);

        logStep("Step 2:Enter password john in newUser-form:password<br>"+
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
