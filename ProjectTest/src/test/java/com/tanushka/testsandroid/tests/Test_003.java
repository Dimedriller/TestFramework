package com.tanushka.testsandroid.tests;

import com.tanushka.framework.platform.android.AndroidDevice;
import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import org.openqa.selenium.By;

/**
 * Created by Home on 31.05.2016.
 * Test_003 Create, Save and Delete a note.
 *
 * Setup:
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
public class Test_003 extends BaseAndroidTest{
    @Override
    protected void executeSetup(AndroidDevice device) {

    }

    @Override
    protected void executeTest(AndroidDevice device) throws TestException {

        logStep("Step 1: Open Fast Notepad. Click on content_addbtn. Find actionbar_toggle element.<br>" +
                "Expected Result: Creation note screen with Fast Notepad title is opened.<br>");

        device.findElement(By.id("com.taxaly.noteme.v2:id/content_addbtn")).click();
        device.findElement(By.name("Fast Notepad"));

        logStep("Step 2: Print Hello Fast NotePad. <br>" +
                "Expected Result: Element editor has text Hello Fast NotePad.<br>");

        ViewElement editorElement= device.findElement(By.id("com.taxaly.noteme.v2:id/scrollView"));
        editorElement.sendKeys("Hello Fast NotePad");
        editorElement.findElement(By.name("Hello Fast NotePad"));

        logStep("Step 3: Click on actionbar_back element. <br>" +
                "Expected Result: A new note is saved.<br>");

        device.findElement(By.id("com.taxaly.noteme.v2:id/actionbar_back")).click();
        ViewElement listView = device.findElement(By.id("com.taxaly.noteme.v2:id/fragment_main_list"));
        ViewElement createdNote = listView.findElement(By.name("Hello Fast NotePad"));

        logStep("Step 4: Long press on created note in the list.<br>" +
                " Expected Result: Settings select_dialog_listview is displayed.<br>");


        createdNote.longPress();



        logStep("Step 5: Verify all elements in select_dialog_listview.<br>" +
                "Expected Result: Open, Clone, Delete, Move to are present. Cancel is present.<br>");

        ViewElement selectDialogListview = device.findElement(By.id("android:id/select_dialog_listview"));
        selectDialogListview.findElement(By.name("Open"));
        selectDialogListview.findElement(By.name("Clone"));
        selectDialogListview.findElement(By.name("Delete"));
        selectDialogListview.findElement(By.name("Move to"));

        device.findElement(By.name("Cancel"));

        logStep("Step 6: Click Delete.<br>" +
                "Expected Result: The first note is deleted.<br>");

        selectDialogListview.findElement(By.name("Delete")).click();


    }
}
