package base;

import base.mobiledrivers.MobileDFactory;
import base.webdrivers.WebDFactory;

public final class Driver {

    private  Driver(){

    }

    public static void generateDriver(){
        WebDFactory.generateWebDriver();
        MobileDFactory.generateMobileDriver();
    }
}
