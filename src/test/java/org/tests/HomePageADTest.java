package org.tests;

import org.base.BaseDriver;
import org.pages.HomePageAD;
import org.pages.LoginPageAD;
import org.testng.annotations.Test;

public final class HomePageADTest extends BaseDriver {

    private HomePageADTest(){}

    @Test
    public void loginTest(){
        LoginPageAD.loginMethod().closeMessages();
        //HomePageAD.getMenu("Capturas");
        //HomePageAD.getSubMenu("Capturas","Actualización de datos de padres");
    }
}
