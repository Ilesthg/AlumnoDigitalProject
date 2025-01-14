package constants;


import enums.*;

import utilities.datareader.PropertiesReader;

public final class Constants {

    private Constants() {
    }

    private static final String routeDir = System.getProperty("user.dir");


    private static final String BROWSER = PropertiesReader.returnKey(Configurations.BROWSER);
    private static final String WEBRUNMODE = PropertiesReader.returnKey(Configurations.WEBRUNMODE);
    private static final String WEBPLATFORM = PropertiesReader.returnKey(Configurations.WEBPLATFORM);


    private static final String MOBILERUNMODE = PropertiesReader.returnKey(Configurations.MOBILERUNMODE);
    private static final String MOBILEDEVICE = PropertiesReader.returnKey(Configurations.MOBILEDEVICE);
    private static final String MOBILEPLATFORM = PropertiesReader.returnKey(Configurations.MOBILEPLATFORM);



    private static final String URL = PropertiesReader.returnKey(Configurations.URL);

    private static  String dirForCreateExtentReport = "";


    private static final String ERRORMESSAGE = "Su intento de inicio de sesión no se realizó correctamente. Por favor, inténtelo de nuevo.";
    private static final String HOMEURL =  "https://siee.sepyc.gob.mx/ControlEscolar/vista.aspx";

    public static String getBrowser() {
        return BROWSER;
    }

    public static String getWebrunmode() {
        return WEBRUNMODE;
    }

    public static String getWEBPLATFORM() {
        return WEBPLATFORM;
    }

    public static String getUrl() {
        return URL;
    }

    public static String getErrormessage() {
        return ERRORMESSAGE;
    }
    public static String getHomeUrl() {
        return HOMEURL;
    }

    public static String getRouteDir() {
        if (PropertiesReader.returnKey(Configurations.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
            return dirForCreateExtentReport = routeDir + "/src/test/resources/reports/"+ System.currentTimeMillis()+".html";
        }
        return dirForCreateExtentReport = routeDir + "/src/test/resources/reports/index.html";
    }



    public static Browsers getBrowserEnum() {
        return Browsers.valueOf(BROWSER.toUpperCase());
    }

    public static MobileDevice getMobileDevice() {
        return MobileDevice.valueOf(MOBILEDEVICE.toUpperCase());
    }

    public static RunMode getWebRunModeEnum() {
        return RunMode.valueOf(WEBRUNMODE.toUpperCase());
    }
    public static RunMode getMobileRunModeEnum() {
        return RunMode.valueOf(MOBILERUNMODE.toUpperCase());
    }

 /*   public static MobilePlatform getMobilePlatformEnum() {
        System.out.println(WebPlatform.valueOf(MOBILEPLATFORM.toUpperCase()));
        return MOBILEPLATFORM.valueOf(MOBILEPLATFORM.toUpperCase());
    }*/


    public static WebPlatform getWebPlatformEnum() {
        return WebPlatform.valueOf(WEBPLATFORM.toUpperCase());
    }
}

