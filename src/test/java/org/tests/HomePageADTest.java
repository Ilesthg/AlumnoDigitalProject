package org.tests;

import base.BaseDriver;
import pages.LoginPageAD;
import org.testng.annotations.Test;
import utilities.DataProviderFiltered;

import java.util.HashMap;

public final class HomePageADTest extends BaseDriver {

    private HomePageADTest(){}

//(dependsOnMethods = "org.tests.LoginADTest.validLoginTest", dataProvider = "ValidData", dataProviderClass = DataProviderFiltered.class)
    @Test( dataProvider = "DataFiltered", dataProviderClass = DataProviderFiltered.class)
    public void validHomePageTest(HashMap<String, String> data){

       new LoginPageAD()
               .validLogin(data)
               .navigateActaulizarPadres();



    }




}
