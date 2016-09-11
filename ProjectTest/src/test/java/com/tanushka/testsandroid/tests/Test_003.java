package com.tanushka.testsandroid.tests;

import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;

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
    protected void executeSetup() {

    }

    @Override
    protected void executeTest() throws TestException {

        logStep("Step 1: Open Fast Notepad. Click on content_addbtn. Find actionbar_toggle element.<br>" +
                "Expected Result: Creation note screen with Fast Notepad title is opened.<br>");

        getDevice().findElementById("com.taxaly.noteme.v2:id/content_addbtn").click();
        getDevice().findElementByName("Fast Notepad");

        logStep("Step 2: Print Hello Fast NotePad. <br>" +
                "Expected Result: Element editor has text Hello Fast NotePad.<br>");

        ViewElement editorElement= getDevice().findElementById("com.taxaly.noteme.v2:id/scrollView");
        editorElement.sendKeys("Hello Fast NotePad");
        editorElement.findElementByName("Hello Fast NotePad");

        logStep("Step 3: Click on actionbar_back element. <br>" +
                "Expected Result: A new note is saved.<br>");

        getDevice().findElementById("com.taxaly.noteme.v2:id/actionbar_back").click();
        ViewElement listView = getDevice().findElementById("com.taxaly.noteme.v2:id/fragment_main_list");
        ViewElement createdNote = listView.findElementByName("Hello Fast NotePad");

        logStep("Step 4: Long press on created note in the list.<br>" +
                " Expected Result: Settings select_dialog_listview is displayed.<br>");

        //ViewElement firstElement=getPhone().findElementByXPath("//android.widget.RelativeLayout[1]");
        //getPhone().findElementByXPath("//android.widget.RelativeLayout[@index='2']").click();
        createdNote.longPress();

        //getPhone().longPressByName("Hello Fast NotePad");


        logStep("Step 5: Verify all elements in select_dialog_listview.<br>" +
                "Expected Result: Open, Clone, Delete, Move to are present. Cancel is present.<br>");

        ViewElement selectDialogListview = getDevice().findElementById("android:id/select_dialog_listview");
        selectDialogListview.findElementByName("Open");
        selectDialogListview.findElementByName("Clone");
        selectDialogListview.findElementByName("Delete");
        selectDialogListview.findElementByName("Move to");

        getDevice().findElementByName("Cancel");

        logStep("Step 6: Click Delete.<br>" +
                "Expected Result: The first note is deleted.<br>");

        selectDialogListview.findElementByName("Delete").click();


    }
}
