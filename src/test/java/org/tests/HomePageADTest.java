package org.tests;

import base.BaseDriver;
import pages.LoginPageAD;
import org.testng.annotations.Test;
import pages.homepage.enums.MENUS;
import pages.homepage.enums.SUBMENU;
import utilities.DataProviderFiltered;

import java.util.HashMap;

public final class HomePageADTest extends BaseDriver {

    private HomePageADTest(){}

//(dependsOnMethods = "org.tests.LoginADTest.validLoginTest", dataProvider = "ValidData", dataProviderClass = DataProviderFiltered.class)
    @Test( dataProvider = "DataFiltered", dataProviderClass = DataProviderFiltered.class)
    public void validHomePageTest(HashMap<String, String> data){

       new LoginPageAD()
               .validLogin(data)
               .clickMenu(MENUS.CAPTURAS)
               .clickSubMenu(SUBMENU.ACTUALIZACION_DE_DATOS_PADRES);

     //   homePageAD.clickMenu(MENUS.CONSULAS);
      //  loginPageAD.validLogin(data).getMenu("consultas");

    }




}
