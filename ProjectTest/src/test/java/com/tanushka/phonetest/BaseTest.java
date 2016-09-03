package com.tanushka.phonetest;

import com.tanushka.reporting.BaseHTMLReporter;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@Listeners(BaseHTMLReporter.class)
public abstract class BaseTest<D extends Device> {
    private D mDevice;
    private final List<String> mProblemList = new ArrayList<String>();

    //@Parameters({"platform","deviceName"})

    protected abstract void executeSetup() throws TestException;

    @BeforeClass
    public void setUp() throws MalformedURLException, TestException {
        mDevice = initializeDevice();

        executeSetup();
    }

    protected abstract void executeTest() throws TestException;

    @Test
    public void test() {
        try {
            executeTest();
        } catch (TestException e) {
            logProblem(e.getMessage());
        }

        if (mProblemList.size() > 0) {
            Assertion softAssert = new Assertion();
            softAssert.assertTrue(false);
        }
    }

    @AfterClass
    public void tearDown() {
       mDevice.closeApp();
    }

    protected void logProblem(String message) {
        mProblemList.add(message);
        Reporter.log(message);
    }

    protected void logStep(String message) {
        Reporter.log(message);
    }

    public D getDevice() {
        return mDevice;
    }

    protected abstract D initializeDevice() throws MalformedURLException;


}
