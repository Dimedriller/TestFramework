package com.tanushka.framework.reporting;

import com.tanushka.framework.platform.BaseTest;
import com.tanushka.framework.platform.Device;
import org.apache.velocity.VelocityContext;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.uncommons.reportng.HTMLReporter;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Sergey Kuts
 * Date: 9/17/13
 * Time: 6:49 PM
 */
public class BaseHTMLReporter extends HTMLReporter implements ITestListener {
    public static final String DRIVER_ATTRIBUTE = "framework";
    private static final String UTILS_KEY = "utils";
    private static final String DATE = "date";
    private static final String TEST_CASES_INFO = "testCasesInfo";

    private static final ReportUtils REPORT_UTILS = new ReportUtils();




    protected VelocityContext createContext() {
        final VelocityContext context = super.createContext();
        context.put(UTILS_KEY, REPORT_UTILS);
        return context;
    }

    private void createScreenshot(final ITestResult result, final Device device) {
        final DateFormat timeFormat = new SimpleDateFormat("MM.dd.yyyy HH-mm-ss");
        final String fileName = result.getMethod().getMethodName() + "_" + timeFormat.format(new Date());
        String outputDirectory = result.getTestContext().getOutputDirectory();

        File screenshotFile = device.takeScreenshot(outputDirectory, fileName);
        if (screenshotFile != null)
            result.setAttribute("screenshot", screenshotFile.getName());
    }

    public void onTestFailure(final ITestResult result) {
        BaseTest testClass = (BaseTest) result.getTestClass().getInstances(true)[0];
        createScreenshot(result, testClass.getDevice());
    }

    public void onTestSuccess(final ITestResult result) {
        BaseTest testClass = (BaseTest) result.getTestClass().getInstances(true)[0];
        createScreenshot(result, testClass.getDevice());
    }

    public void onTestStart(final ITestResult result) {
    }

    public void onTestSkipped(final ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
    }

    public void onStart(final ITestContext context) {
    }

    public void onFinish(final ITestContext context) {
    }
}
