package com.tanushka.testweb;

import com.tanushka.phonetest.BaseWebTest;
import com.tanushka.phonetest.TestException;
import com.tanushka.phonetest.ViewElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;


/**
 * Created by Home on 06.09.2016.
 */
public class LogInWithDefaultUserChrome extends BaseWebTest{
    @Override
    protected void executeSetup() {



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

