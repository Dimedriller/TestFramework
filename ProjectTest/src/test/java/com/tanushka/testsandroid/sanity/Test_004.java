package com.tanushka.testsandroid.sanity;

import com.tanushka.framework.platform.android.BaseAndroidTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.ViewElement;

/**
 * Created by Home on 02.06.2016.
 * Test_004 Check Settings panel by swiping.
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

public class Test_004 extends BaseAndroidTest {
    @Override
    protected void executeSetup() {

    }

    @Override
    protected void executeTest() throws TestException {

        logStep("Step 1: Open Fast Notepad. Open Settings panel by swiping.<br>" +
                "Expected Result: Panel navigation_drawer is opened.<br>");

        getDevice().swipeByCoordinates(2, 500, 700, 500);
        ViewElement navigationDrawer = getDevice().findElementById("com.taxaly.noteme.v2:id/navigation_drawer");

        logStep("Step 2:Check all elements: Navigation_drawer element with text Fast NotePad, navigation_drawer_list with 4 elements:\n " +
                "My notes, Trash bin, Settings, About.<br>" +
                "Expected Result: All elements are present in the list.<br>");

        navigationDrawer.findElementById("com.taxaly.noteme.v2:id/navigation_drawer_title").verifyTextAttribute("Fast Notepad");
        navigationDrawer.findElementByName("Fast Notepad");

        ViewElement navigationDRawerList = navigationDrawer.findElementById("com.taxaly.noteme.v2:id/navigation_drawer_list");
        navigationDRawerList.findElementByName("My notes");
        navigationDRawerList.findElementByName("Trash bin");
        navigationDRawerList.findElementByName("Settings");
        navigationDRawerList.findElementByName("About");


        logStep("Step 3: Close Settings panel by swiping.<br>" +
                " Expected result: Panel are closed.<br>");

        getDevice().swipeByCoordinates(700, 900, 50, 900);
        try {
            getDevice().findElementById("com.taxaly.noteme.v2:id/navigation_drawer");
            logProblem("Settings panel is not closed");
        } catch (TestException e) {
            // No actions
        }









    }
}
