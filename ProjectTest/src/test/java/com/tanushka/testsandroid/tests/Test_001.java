package com.tanushka.testsandroid.tests;

import com.tanushka.framework.platform.android.AndroidDevice;
import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import org.openqa.selenium.By;

/**
 * Created by Home on 31.05.2016.
 * Test_001 Verify all elements in the main screen.
 * Setup:
 *
 * Step 1: Open Fast Notepad. Find RelativeLayout widget.
 * Expected Result: Widget RelativeLayout is found.
 *
 * Step 2: Find actionbar_toggle element.
 * Expected Result: Element actionbar_toggle is found.
 *
 * Step 3: Find actionbar_title element.
 * Expected Result: Element actionbar_title is found.
 *
 * Step 4: Find actionbar_search element.
 * Expected Result: Element actionbar_search is found.
 *
 * Step 5: Find actionbar_menu element.
 * Expected Result: Element actionbar_menu is found.
 *
 * Step 6: Find fragment_main_list element.
 * Expected Result: Element fragment_main_list is found.
 *
 * Step 7: Find content_addbtn element.
 * Expected Result: Element content_addbtn is found.
 *
 * Step 8: Close application by pressing Back button.
 * Expected Result: Application is closed correctly.
 *
 */
public class Test_001 extends BaseAndroidTest {
    @Override
    protected void executeSetup(AndroidDevice device) {

    }

    @Override
    protected void executeTest(AndroidDevice device) throws TestException {


        logStep("Step 1: Open Fast Notepad. Find RelativeLayout widget.<br>" +
                "Expected Result: Widget RelativeLayout is found.<br>");

        ViewElement relativeLayoutElement= device.findElement(By.className("android.widget.RelativeLayout"));

        logStep("Step 2: Find actionbar_toggle element.<br>" +
                "Expected Result: Element actionbar_toggle is found.<br>");

        relativeLayoutElement.findElement(By.id("com.taxaly.noteme.v2:id/actionbar_toggle"));

        logStep("Step 3: Find actionbar_title element.<br>" +
                "Expected Result: Element actionbar_title is found.<br>");

        relativeLayoutElement.findElement(By.id("com.taxaly.noteme.v2:id/actionbar_title"));

        logStep("Step 4: Find actionbar_search element.<br>" +
                "Expected Result: Element actionbar_search is found.<br>");

        relativeLayoutElement.findElement(By.id("com.taxaly.noteme.v2:id/actionbar_search"));

        logStep("Step 5: Find actionbar_menu element.<br>" +
                "Expected Result: Element actionbar_menu is found.<br>");

        relativeLayoutElement.findElement(By.id("com.taxaly.noteme.v2:id/actionbar_menu"));

        logStep("Step 6: Find fragment_main_list element.<br>" +
                "Expected Result: Element fragment_main_list is found.<br>");

        relativeLayoutElement.findElement(By.id("com.taxaly.noteme.v2:id/fragment_main_list"));

        logStep("Step 7: Find content_addbtn element.<br>" +
                "Expected Result: Element content_addbtn is found.<br>");

        relativeLayoutElement.findElement(By.id("com.taxaly.noteme.v2:id/content_addbtn"));

        logStep("Step 8: Close application by clicking Back button.<br>" +
                "Expected Result: Application is closed.<br>");


        device.back();

        device.findElement(By.className("android.widget.RelativeLayout"));

        relativeLayoutElement.findElement(By.id("com.taxaly.noteme.v2:id/actionbar_toggle"));



        }



    }

