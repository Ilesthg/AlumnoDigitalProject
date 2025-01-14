package org.tests;

import org.base.BaseDriver;
import org.pages.LoginPageAD;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.ExcelReader;

import java.util.HashMap;

public final class LoginADTest extends BaseDriver {


    private LoginADTest() {}


//(dataProvider = "DataExcel" , dataProviderClass = ExcelReader.class)
    @Test
    public void validLoginTest(HashMap<String, String> data) {
        // LoginPageAD.loginMethod().closeMessages();

    LoginPageAD loginPageAD = new LoginPageAD();
        loginPageAD.sendUsernamePassword(data);
        //Assert.assertTrue(loginPageAD.mandatoryFieldsPresent(),"Mandatory fields are not present.");

        loginPageAD.submitButton();
        loginPageAD.linkCtrlEscolar().closeMessages();
        Assert.assertTrue(loginPageAD.isRedirected(), "User was redirected to expected page");
    }

    @Test
    public void invalidLoginWithData(HashMap<String, String> data) {
        LoginPageAD loginPageAD = new LoginPageAD();
        loginPageAD.sendUsernamePassword(data).submitButton();
        Assert.assertTrue(loginPageAD.isMessageDisplayed(), "Error message is not displayed.");
        Assert.assertTrue(loginPageAD.isErrorMessageCorrect(), "Error message generated, wasn't expected.");
        Assert.assertFalse(loginPageAD.isRedirected(), "User was not redirected to the expected page.");

    }
@Test
    public void invalidWithNoData(HashMap<String, String> data) {
        LoginPageAD loginPageAD = new LoginPageAD();
    //login feature does not accept blank data
        loginPageAD.sendUsernamePassword(data).submitButton();
        Assert.assertFalse(loginPageAD.mandatoryFieldsPresent());
        Assert.assertFalse(loginPageAD.isRedirected(), "User was not redirected to the expected page.");
    }
}


//HomePageAD.getMenu("Capturas");
//HomePageAD.getSubMenu("Capturas","Actualización de datos de padres");