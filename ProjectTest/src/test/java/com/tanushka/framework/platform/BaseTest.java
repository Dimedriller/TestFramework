package com.tanushka.framework.platform;

import com.tanushka.framework.reporting.BaseHTMLReporter;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@Listeners(BaseHTMLReporter.class)
public abstract class BaseTest<D extends Device> {
    private D mDevice;
    private final EventLogger mEventLogger = new EventLogger();

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

        if (mEventLogger.hasProblems()) {
            Assertion softAssert = new Assertion();
            softAssert.assertTrue(false);
        }
    }

    @AfterClass
    public void tearDown() {
       mDevice.closeApp();
    }

    protected void logProblem(String message) {
        mEventLogger.logProblem(message);
    }

    protected void logStep(String message) {
        mEventLogger.logStep(message);
    }

    public D getDevice() {
        return mDevice;
    }

    EventLogger getEventLogger() {
        return mEventLogger;
    }

    protected abstract D initializeDevice() throws MalformedURLException;


}
