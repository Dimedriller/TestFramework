package com.tanushka.testandroid.tests;

import com.tanushka.framework.platform.android.AndroidDevice;
import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import org.openqa.selenium.By;

/**
 * Created by Home on 02.06.2016.
 * CreateNewFolder Create new folder.
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

public class CreateNewFolder extends BaseAndroidTest {
    @Override
    protected void executeSetup(AndroidDevice device) {

    }

    @Override
    protected void executeTest(AndroidDevice device) throws TestException {

        logStep("Step 1: Open NotePad. Click on actionbar_menu.<br>" +
                " Expected result: Dialog with actions are displayed.<br>");

        device.findElement(By.id("com.taxaly.noteme.v2:id/actionbar_menu")).click();
        ViewElement dialogListView = device.findElement(By.id("android:id/select_dialog_listview"));

        logStep("Step 2: Verify all element in dialog: Order by date, Order by title, Create folder. And Cancel button.<br>" +
                " Expected result: All elements are present in the dialog.<br>");

        dialogListView.findElement(By.name("Order by date"));
        dialogListView.findElement(By.name("Order by title"));
        dialogListView.findElement(By.name("Create folder"));

        device.findElement(By.id("android:id/button3"));

        logStep("Step 3: Click Create folder.<br>" +
                " Expected result: Dialog for create a new folder is displayed.<br>");

        dialogListView.findElement(By.name("Create folder")).click();


        //Check all elements in Create dialog
        ViewElement nameFolderField = device.findElement(By.name("Enter folder name"));
        device.findElement(By.name("Fast folder"));

        device.findElement(By.name("Cancel"));
        device.findElement(By.name("OK"));

        logStep("Step 4: Print Test. Click OK.<br>" +
                " Expected result: Folder is created.<br>");

        nameFolderField.sendKeys("Test");
        device.findElement(By.name("OK")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        logStep("Step 5: Open Settings panel by swiping. And verify that Fast folder element is in the list.<br>" +
                " Expected result: Fast folder element is present.<br>");

        device.swipeByCoordinates(2, 500, 700, 500);
        ViewElement navigationDrawer = device.findElement(By.id("com.taxaly.noteme.v2:id/navigation_drawer"));

        navigationDrawer.findElement(By.name("Test")).click();
        device.findElement(By.name("Test"));
    }
}
