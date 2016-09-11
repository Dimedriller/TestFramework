package com.tanushka.testsandroid.tests;

import com.tanushka.framework.platform.android.AndroidDevice;
import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;

/**
 * Created by Home on 02.06.2016.
 * Test_006 Create new 20 notes. Scroll to 5th and delete.
 *
 * Setup:
 * Create 10 new notes.
 * Expected Result: 10 new notes are created.
 *
 * Step 1: Scroll to Notes5 and delete.
 * Expected Result: Notes5 are deleted.
 *
 */

public class Test_006 extends BaseAndroidTest {
    @Override
    protected void executeSetup(AndroidDevice device) throws TestException {
        logStep("Setup: Create 10 new notes.<br>" +
                " Expected result: 20 new notes are created.<br>");

        for(int size = 0; size < 10; size++) {
            device.findElementById("com.taxaly.noteme.v2:id/content_addbtn").click();
            device.findElementByName("Fast Notepad");
            ViewElement editorElement = device.findElementById("com.taxaly.noteme.v2:id/scrollView");
            editorElement.sendKeys("Fast NotePad" + size);

            device.findElementById("com.taxaly.noteme.v2:id/actionbar_back").click();
            ViewElement listView = device.findElementById("com.taxaly.noteme.v2:id/fragment_main_list");
            listView.findElementByName("Fast NotePad"+size);
        }
    }

    @Override
    protected void executeTest(AndroidDevice device) throws TestException {

        logStep("Step 1: Scroll to Fast NotePad5 and delete.<br>" +
                " Expected result: Fast NotePad5 are deleted.<br>");

        ViewElement createdNote = device.scrollForElementByName("Fast NotePad5");
        createdNote.longPress();
        ViewElement selectDialogListView = device.findElementById("android:id/select_dialog_listview");
        selectDialogListView.findElementByName("Delete").click();
        try {
            createdNote.findElementByName("Fast NotePad5");
            logProblem("Fast NotePad5 is not deleted");
        } catch (TestException e) {
            // No actions
        }
















    }
}
