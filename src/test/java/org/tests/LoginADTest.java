package org.tests;

import base.BaseDriver;
import pages.LoginPageAD;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviderFiltered;

import java.util.HashMap;

public final class LoginADTest extends BaseDriver {


    private LoginADTest() {}


    @Test(dataProvider = "DataFiltered", dataProviderClass = DataProviderFiltered.class)
    public void validLoginTest(HashMap<String, String> data) {
        LoginPageAD loginPageAD = new LoginPageAD();
        loginPageAD.validLogin(data);
        Assert.assertTrue(loginPageAD.isRedirected(), "Login failed despite valid credentials.");}



    @Test(dataProvider = "DataFiltered", dataProviderClass = DataProviderFiltered.class)
    public void invalidLoginTest(HashMap<String, String> data) {

        LoginPageAD loginPageAD = new LoginPageAD();
        loginPageAD.sendUsernamePassword(data).submitButton();

        if ((data.get("username") == null || data.get("username").isEmpty()) &&
                (data.get("password") == null || data.get("password").isEmpty())) {
            // Handle "no data" case
            Assert.assertFalse(loginPageAD.areMandatoryFieldsPresent(), "Mandatory fields should not be present for empty data.");
            Assert.assertFalse(loginPageAD.isRedirected(), "User was unexpectedly redirected.");
        } else {
            // Handle "invalid with data" case
            Assert.assertTrue(loginPageAD.isMessageDisplayed(), "Error message is not displayed.");
            Assert.assertTrue(loginPageAD.isErrorMessageCorrect(), "Unexpected error message.");
            Assert.assertFalse(loginPageAD.isRedirected(), "User logged in with invalid credentials.");
        }
    }

}


//HomePageAD.getMenu("Capturas");
//HomePageAD.getSubMenu("Capturas","Actualización de datos de padres");