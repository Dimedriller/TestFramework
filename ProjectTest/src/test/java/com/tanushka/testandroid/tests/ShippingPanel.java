package com.tanushka.testandroid.tests;

import com.tanushka.framework.platform.android.AndroidDevice;
import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;
import org.openqa.selenium.By;

/**
 * Created by Home on 02.06.2016.
 * ShippingPanel Check Settings panel by swiping.
 *
 * Setup:
 *
 * Step 1: Open Fast Notepad. Open Settings panel by swiping.
 * Expected Result: Panel navigation_drawer is opened.
 *
 * Step 2: Check all elements: Navigation_drawer element with text Fast NotePad, navigation_drawer_list with 4 elements:
 * My Notes, Trash bin, Settings, About.
 * Expected Result: All elements are present in the list.
 *
 * Step 3: Close Settings panel by swiping.
 * Expected result: Panel are closed.
 *
 */

public class ShippingPanel extends BaseAndroidTest {
    @Override
    protected void executeSetup(AndroidDevice device) {

    }

    @Override
    protected void executeTest(AndroidDevice device) throws TestException {

        logStep("Step 1: Open Fast Notepad. Open Settings panel by swiping.<br>" +
                "Expected Result: Panel navigation_drawer is opened.<br>");

        device.swipeByCoordinates(2, 500, 700, 500);
        ViewElement navigationDrawer = device.findElement(By.id("com.taxaly.noteme.v2:id/navigation_drawer"));

        logStep("Step 2:Check all elements: Navigation_drawer element with text Fast NotePad, navigation_drawer_list with 4 elements:\n " +
                "My notes, Trash bin, Settings, About.<br>" +
                "Expected Result: All elements are present in the list.<br>");

        navigationDrawer.findElement(By.id("com.taxaly.noteme.v2:id/navigation_drawer_title")).verifyTextAttribute("Fast Notepad");
        navigationDrawer.findElement(By.name("Fast Notepad"));

        ViewElement navigationDRawerList = navigationDrawer.findElement(By.id("com.taxaly.noteme.v2:id/navigation_drawer_list"));
        navigationDRawerList.findElement(By.name("My notes"));
        navigationDRawerList.findElement(By.name("Trash bin"));
        navigationDRawerList.findElement(By.name("Settings"));
        navigationDRawerList.findElement(By.name("About"));


        logStep("Step 3: Close Settings panel by swiping.<br>" +
                " Expected result: Panel are closed.<br>");

        device.swipeByCoordinates(700, 900, 50, 900);
        try {
            device.findElement(By.id("com.taxaly.noteme.v2:id/navigation_drawer"));
            logProblem("Settings panel is not closed");
        } catch (TestException e) {
            // No actions
        }









    }
}
