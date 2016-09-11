package com.tanushka.testsandroid.tests;

import com.tanushka.framework.platform.android.AndroidDevice;
import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;

/**
 * Created by Home on 31.05.2016.
 * Test_002 Verify all elements in creation note screen.
 * Setup:
 *
 * Step 1: Open Fast Notepad. Click on content_addbtn. Find actionbar_toggle element.
 * Expected Result: Creation note screen with "Fast Notepad" title is opened.
 *
 * Step 2: Find actionbar_back element.
 * Expected Result: Element actionbar_back is found.
 *
 * Step 3: Find actionbar_share element.
 * Expected Result: Element actionbar_share is found.
 *
 * Step 4: Find actionbar_menu element.
 * Expected Result: Element actionbar_menu is found.
 *
 * Step 5: Find scrollView element.
 * Expected Result: Element scrollView is found".
 *
 */
public class Test_002 extends BaseAndroidTest {
    @Override
    protected void executeSetup(AndroidDevice device) {

    }

    @Override
    protected void executeTest(AndroidDevice device) throws TestException {

        logStep("Step 1: Open Fast Notepad. Click on content_addbtn. Find actionbar_toggle element.<br>" +
                "Expected Result: Creation note screen with Fast Notepad title is opened.<br>");

        device.findElementById("com.taxaly.noteme.v2:id/content_addbtn").click();
        device.findElementByName("Fast Notepad");

        logStep("Step 2: Find actionbar_back element.<br>" +
                "Expected Result: Element actionbar_back is found.<br>");

        device.findElementById("com.taxaly.noteme.v2:id/actionbar_back");

        logStep("Step 3: Find actionbar_share element.<br>" +
                "Expected Result: Element actionbar_share is found.<br>");

        device.findElementById("com.taxaly.noteme.v2:id/actionbar_share");

        logStep("Step 4: Find actionbar_menu element.<br>" +
                "Expected Result: Element actionbar_menu is found.<br>");

        device.findElementById("com.taxaly.noteme.v2:id/actionbar_menu");

        logStep("Step 5: Find scrollView element.<br>" +
                "Expected Result: Element scrollView is found.<br>");

        device.findElementById("com.taxaly.noteme.v2:id/scrollView");
    }
}
