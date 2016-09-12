package com.tanushka.testweb.tests;

import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.web.BaseWebTest;
import com.tanushka.framework.platform.web.WebDevice;
import com.tanushka.testweb.helpers.NewUserHelper;
import org.testng.annotations.Parameters;

/**
 * Created by Home on 11.09.2016.
 */
public class CreateNewUser  extends BaseWebTest{
    private final NewUserHelper mNewUserHelper = new NewUserHelper(this);

    private final String mEmail;
    private final String mPassword;

    @Parameters({"userEmail", "password"})
    public CreateNewUser(String userEmail, String password) {
        mEmail = userEmail;
        mPassword = password;
    }


    @Override
    protected void executeSetup(WebDevice device) {
        device.loadPage("http://demo.borland.com/InsuranceWebExtJS/index.jsf");
    }

    @Override
    protected void executeTest(WebDevice device) throws TestException {
        mNewUserHelper.newUser(device, mEmail, mPassword);

    }
}
