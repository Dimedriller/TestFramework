package com.tanushka.testweb.tests;

import com.tanushka.framework.platform.web.BaseWebTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;


/**
 * Created by Home on 31.07.2016.
 */

public class LogInWithDefaultUserIE extends BaseWebTest{
    @Override
    protected void executeSetup() {


        String baseUrl = "http://demo.borland.com/InsuranceWebExtJS/index.jsf";
        getDevice().mWebDriver.get(baseUrl);

    }

    @Override
    protected void executeTest() throws TestException {

        logStep("Step 1:Enter email john.smith@gmail.com in login-form:email<br>"+
                "Expected Result: Email john.smith@gmail.com is introduced<br>");

        ViewElement loginField = getDevice().findElementById("login-form:email");
        loginField.sendKeys("john.smith@gmail.com");

        logStep("Step 2:Enter password john in login-form:password<br>"+
                "Expected Result: Password john is introduced<br>");

        ViewElement passwordField = getDevice().findElementById("login-form:password");
        passwordField.sendKeys("john");

        logStep("Step 3:Click LogIn button<br>"+
                "Expected Result: Notice Logged in as John Smith is displayed <br>");

        ViewElement loginBtn = getDevice().findElementById("login-form:login");
        loginBtn.click();

        getDevice().findElementByXPath(".//*[@id='logout-form']/div[2]/label[contains(text(), 'John')]");

      /*  try {
            getDevice().findElementById("logocont");
            logProblem("logocont is not deleted");
        } catch (TestException e) {
            // No actions
        }
        //getDevice().findElementById("logocont");*/

    }
}



