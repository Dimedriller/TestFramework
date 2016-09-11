package com.tanushka.testsandroid.tests;

import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;

/**
 * Created by Home on 02.06.2016.
 * Test_005 Create new folder.
 *
 * Setup:
 *
 * Step 1: Open Fast Notepad. Click on actionbar_menu.
 * Expected Result: Dialog with actions are displayed.
 *
 * Step 2: Verify all element in dialog: Order by date, Order by title, Create folder. And Cancel button.
 * Expected Result: All elements are present in the dialog.
 *
 * Step 3: Click Create folder.
 * Expected Result: Dialog for create a new folder is displayed.
 *
 * Step 4: Print "Test". Click OK.
 * Expected Result: Folder is created.
 *
 * Step 5: Open Settings panel by swiping. And verify that Fast Folder element is in the list.
 * Expected Result: Fast Folder element is present.
 *
 */

public class Test_005 extends BaseAndroidTest {
    @Override
    protected void executeSetup() {

    }

    @Override
    protected void executeTest() throws TestException {

        logStep("Step 1: Open NotePad. Click on actionbar_menu.<br>" +
                " Expected result: Dialog with actions are displayed.<br>");

        getDevice().findElementById("com.taxaly.noteme.v2:id/actionbar_menu").click();
        ViewElement dialogListView = getDevice().findElementById("android:id/select_dialog_listview");

        logStep("Step 2: Verify all element in dialog: Order by date, Order by title, Create folder. And Cancel button.<br>" +
                " Expected result: All elements are present in the dialog.<br>");

        dialogListView.findElementByName("Order by date");
        dialogListView.findElementByName("Order by title");
        dialogListView.findElementByName("Create folder");

        getDevice().findElementById("android:id/button3");

        logStep("Step 3: Click Create folder.<br>" +
                " Expected result: Dialog for create a new folder is displayed.<br>");

        dialogListView.findElementByName("Create folder").click();


        //Check all elements in Create dialog
        ViewElement nameFolderField = getDevice().findElementByName("Enter folder name");
        getDevice().findElementByName("Fast folder");

        getDevice().findElementByName("Cancel");
        getDevice().findElementByName("OK");

        logStep("Step 4: Print Test. Click OK.<br>" +
                " Expected result: Folder is created.<br>");

        nameFolderField.sendKeys("Test");
        getDevice().findElementByName("OK").click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //getPhone().findElementByName("Fast folder");

        logStep("Step 5: Open Settings panel by swiping. And verify that Fast folder element is in the list.<br>" +
                " Expected result: Fast folder element is present.<br>");

        getDevice().swipeByCoordinates(2, 500, 700, 500);
        ViewElement navigationDrawer = getDevice().findElementById("com.taxaly.noteme.v2:id/navigation_drawer");

        navigationDrawer.findElementByName("Test").click();
        getDevice().findElementByName("Test");















    }
}
