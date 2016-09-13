package com.tanushka.testweb.helpers;

import com.tanushka.framework.platform.BaseTest;
import com.tanushka.framework.platform.TestException;
import com.tanushka.framework.platform.TestHelper;
import com.tanushka.framework.platform.ViewElement;
import com.tanushka.framework.platform.web.WebDevice;
import com.tanushka.testweb.locators.createnewaccount.CreateNewUser;
import com.tanushka.testweb.locators.homepage.LoginForm;

/**
 * Created by Home on 11.09.2016.
 */
public class NewUserHelper extends TestHelper {
    public NewUserHelper(BaseTest test) {
        super(test);
    }

    public void newUser(WebDevice device, String userEmail, String password) throws TestException {

        logStep("Step 1:Click on SighUp button<br>"+
                "Expected Result: Create user page is displayed.<br>");

        ViewElement sighUpButton = CreateNewUser.getSignUpButton(device);
        sighUpButton.click();

        logStep("Step 2:Enter Sam in First name field<br>"+
                "Expected Result: Name Sam is introduced<br>");

        ViewElement nameField = CreateNewUser.getFirstName(device);
        nameField.sendKeys("Sam");

        logStep("Step 3:Enter Hunt in Last name field<br>"+
                "Expected Result: Last name Hunt is introduced<br>");

        ViewElement lastField = CreateNewUser.getLastName(device);
        lastField.sendKeys("Hunt");

        logStep("Step 4:Enter birthday by choosing Today date in Birthday field<br>"+
                "Expected Result: Birthday is introduced<br>");

        ViewElement birthdayField = CreateNewUser.getBirthdayTrigger(device);
        birthdayField.click();

        ViewElement birthdayTodayButton = CreateNewUser.getBirthdayTodayButton(device);
        birthdayTodayButton.click();

        logStep("Step 5:Enter email sam@gmail.com in email field<br>"+
                "Expected Result: Email sam@gmail.com is introduced<br>");

        ViewElement emailField = CreateNewUser.getEmail(device);
        emailField.sendKeys(userEmail);

        logStep("Step 6:Enter address 40 Young street in Mailing field<br>"+
                "Expected Result:Address 40 Young street is introduced<br>");

        ViewElement addressField = CreateNewUser.getAddressStreet(device);
        addressField.sendKeys("40 Young street");

        logStep("Step 7:Enter city Toronto in City field<br>"+
                "Expected Result:City Toronto is introduced<br>");

        ViewElement cityField = CreateNewUser.getAddressCity(device);
        cityField.sendKeys("Toronto");

        logStep("Step 8:Enter State Alaska in State field<br>"+
                "Expected Result:State Alaska is introduced<br>");

        ViewElement stateMenuField = CreateNewUser.getStateMenu(device);
        stateMenuField.click();

        ViewElement stateField = CreateNewUser.getState(device);
        stateField.click();

        logStep("Step 9:Enter Postal code L4K5M7 in Postal Code field<br>"+
                "Expected Result:Postal code L4K5M7 is introduced<br>");

        ViewElement zipField = CreateNewUser.getPostalCode(device);
        zipField.sendKeys("L4K5M7");

        logStep("Step 10:Enter Password 1234 in Password field<br>"+
                "Expected Result:Postal code L4K5M7 is introduced<br>");

        ViewElement passwordField = CreateNewUser.getPassword(device);
        passwordField.sendKeys(password);

        logStep("Step 11:Click on Sigh Up Button<br>"+
                "Expected Result:New User Sam is created<br>");

        ViewElement createUserSighUpButton = CreateNewUser.getSighUpButtonCreateUser(device);
        createUserSighUpButton.click();

        ViewElement continueButton = CreateNewUser.getContinueButton(device);
        continueButton.click();

    }
}
