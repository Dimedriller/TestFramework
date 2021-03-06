package com.tanushka.testweb.tests;

import com.tanushka.framework.platform.web.BaseWebTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.web.WebDevice;
import com.tanushka.testweb.helpers.LoginHelper;

public class LoginWithDefaultUser extends BaseWebTest{
    private final LoginHelper mLoginHelper = new LoginHelper(this);

    @Override
    protected void executeSetup(WebDevice device) {
        device.loadPage("http://demo.borland.com/InsuranceWebExtJS/index.jsf");
    }

    @Override
    protected void executeTest(WebDevice device) throws TestException {
        mLoginHelper.login(device, "john.smith@gmail.com", "john");

    }
}

