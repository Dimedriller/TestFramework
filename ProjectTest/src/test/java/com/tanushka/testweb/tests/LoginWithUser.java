package com.tanushka.testweb.tests;

import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.web.BaseWebTest;
import com.tanushka.framework.platform.web.WebDevice;
import com.tanushka.testweb.helpers.LoginHelper;
import org.testng.annotations.Parameters;

public class LoginWithUser extends BaseWebTest{
    private final LoginHelper mLoginHelper = new LoginHelper(this);

    private final String mUserName;
    private final String mPassword;

    @Parameters({"userName", "password"})
    public LoginWithUser(String userName, String password) {
        mUserName = userName;
        mPassword = password;
    }


    @Override
    protected void executeSetup(WebDevice device) {
        device.loadPage("http://demo.borland.com/InsuranceWebExtJS/index.jsf");
    }

    @Override
    protected void executeTest(WebDevice device) throws TestException {
        mLoginHelper.login(device, mUserName, mPassword);

    }
}

