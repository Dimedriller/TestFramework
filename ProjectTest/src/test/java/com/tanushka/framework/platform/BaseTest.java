package com.tanushka.framework.platform;

import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.net.MalformedURLException;
import java.util.Map;

@Listeners(BaseHTMLReporter.class)
public abstract class BaseTest<D extends Device> {
    private D mDevice;
    private final EventLogger mEventLogger = new EventLogger();

    protected abstract D initializeDevice(Map<String, String> params) throws MalformedURLException;

    protected abstract void executeSetup(D device) throws TestException;

    @BeforeClass
    public void setUp(ITestContext context) throws MalformedURLException, TestException {
        TestRunner runnerContext = (TestRunner) context;
        Map<String, String> testParams = runnerContext.getTest().getAllParameters();

        mDevice = initializeDevice(testParams);

        executeSetup(mDevice);
    }

    protected abstract void executeTest(D device) throws TestException;

    @Test
    public void test(ITestContext context) {
        try {
            executeTest(mDevice);
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

    Device getDevice() {
        return mDevice;
    }

    EventLogger getEventLogger() {
        return mEventLogger;
    }
}
