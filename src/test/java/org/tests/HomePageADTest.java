package org.tests;

import base.BaseDriver;
import pages.HomePageAD;
import pages.LoginPageAD;
import org.testng.annotations.Test;
import utilities.DataProviderFiltered;

import java.util.HashMap;

public final class HomePageADTest extends BaseDriver {

    private HomePageADTest(){}

//(dependsOnMethods = "org.tests.LoginADTest.validLoginTest", dataProvider = "ValidData", dataProviderClass = DataProviderFiltered.class)
    @Test( dataProvider = "DataFiltered", dataProviderClass = DataProviderFiltered.class)
    public void validHomePageTest(HashMap<String, String> data){

        LoginPageAD loginPageAD = new LoginPageAD();
        loginPageAD.validLogin(data);

        HomePageAD homePageAD = new HomePageAD();
        homePageAD.getMenu("consultas");
      //  loginPageAD.validLogin(data).getMenu("consultas");

    }




}
