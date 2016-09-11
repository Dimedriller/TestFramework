package com.tanushka.testweb.tests;

import com.tanushka.framework.platform.web.BaseWebTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import com.tanushka.testweb.helpers.LoginHelper;
import com.tanushka.testweb.locators.LoginForm;

public class LogInWithDefaultUserFF extends BaseWebTest{
    private final LoginHelper mLoginHelper = new LoginHelper(this);

    @Override
    protected void executeSetup() {
        getDevice().loadPage("http://demo.borland.com/InsuranceWebExtJS/index.jsf");
    }

    @Override
    protected void executeTest() throws TestException {
        mLoginHelper.login(getDevice());


      /*  try {
            getDevice().findElementById("logocont");
            logProblem("logocont is not deleted");
        } catch (TestException e) {
            // No actions
        }
        //getDevice().findElementById("logocont");*/

    }
}

