package com.tanushka.testweb.sanity;

import com.tanushka.phonetest.BaseWebTest;
import com.tanushka.phonetest.TestException;
import com.tanushka.phonetest.ViewElement;
import com.tanushka.phonetest.WebDevice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Home on 31.07.2016.
 */
/*Setup:
        *
        * Step 1: Open Fast Notepad. Click on content_addbtn. Find actionbar_toggle element.
        * Expected Result: Creation note screen with "Fast Notepad" title is opened.
        *
        * Step 2: Print "Hello Fast NotePad".
        * Expected Result: Element editor has text "Hello".
        *
        * Step 3: Click on actionbar_back element.
        * Expected result: A new note is saved.
        *
        * Step 4: Long press on created element in the list.
        * Expected Result: Settings select_dialog_listview is displayed.
        *
        * Step 5: Verify all elements in select_dialog_listview.
        * Expected Result: Open, Clone, Delete, Move to are present. Cancel is present.
        *
        * Step 6: Click Delete.
        * Expected Result: The first note is deleted.
        *
        */
public class Test_001 extends BaseWebTest{
    @Override
    protected void executeSetup() {
        String baseUrl = "https://www.google.ca/";
        ((WebDevice) getDevice()).mWebDriver.get(baseUrl);

    }

    @Override
    protected void executeTest() throws TestException {

        logStep("Step 1:Bla-bla<br>");

        ViewElement searchField = getDevice().findElementById("lst-ib");
        searchField.sendKeys("wiki");
        getDevice().findElementById("sblsbb").click();
        try {
            getDevice().findElementById("logocont");
            logProblem("logocont is not deleted");
        } catch (TestException e) {
            // No actions
        }
        //getDevice().findElementById("logocont");

    }
}

