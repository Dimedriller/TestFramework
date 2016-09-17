package com.tanushka.testandroid.tests;

import com.tanushka.framework.platform.android.AndroidDevice;
import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import org.openqa.selenium.By;

/**
 * Created by Home on 02.06.2016.
 * ScrollToDelete Create new 20 notes. Scroll to 5th and delete.
 *
 * Setup:
 * Create 10 new notes.
 * Expected Result: 10 new notes are created.
 *
 * Step 1: Scroll to Notes5 and delete.
 * Expected Result: Notes5 are deleted.
 *
 */

public class ScrollToDelete extends BaseAndroidTest {
    @Override
    protected void executeSetup(AndroidDevice device) throws TestException {
        logStep("Setup: Create 10 new notes.<br>" +
                " Expected result: 20 new notes are created.<br>");

        for(int size = 0; size < 10; size++) {
            device.findElement(By.id("com.taxaly.noteme.v2:id/content_addbtn")).click();
            device.findElement(By.name("Fast Notepad"));
            ViewElement editorElement = device.findElement(By.id("com.taxaly.noteme.v2:id/scrollView"));
            editorElement.sendKeys("Fast NotePad" + size);

            device.findElement(By.id("com.taxaly.noteme.v2:id/actionbar_back")).click();
            ViewElement listView = device.findElement(By.id("com.taxaly.noteme.v2:id/fragment_main_list"));
            listView.findElement(By.name("Fast NotePad"+size));
        }
    }

    @Override
    protected void executeTest(AndroidDevice device) throws TestException {

        logStep("Step 1: Scroll to Fast NotePad5 and delete.<br>" +
                " Expected result: Fast NotePad5 are deleted.<br>");

        ViewElement createdNote = device.scrollForElementByName("Fast NotePad5");
        createdNote.longPress();
        ViewElement selectDialogListView = device.findElement(By.id("android:id/select_dialog_listview"));
        selectDialogListView.findElement(By.name("Delete")).click();
        try {
            createdNote.findElement(By.name("Fast NotePad5"));
            logProblem("Fast NotePad5 is not deleted");
        } catch (TestException e) {
            // No actions
        }
















    }
}
