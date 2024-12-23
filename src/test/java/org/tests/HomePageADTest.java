package org.tests;

import org.base.BaseDriver;
import org.pages.HomePageAlumnoDigital;
import org.testng.annotations.Test;

public final class HomePageADTest extends BaseDriver {

    private HomePageADTest(){};

    @Test
    public void loginTest(){
        HomePageAlumnoDigital.loginMethod();
    }
}
