package constants;


import enums.Browsers;
import enums.Configurations;
import enums.RunMode;
import enums.WebPlatform;
import utilities.datareader.PropertiesReader;

public final class Constants {

    private Constants() {
    }

    private static final String routeDir = System.getProperty("user.dir");


    private static final String BROWSER = PropertiesReader.returnKey(Configurations.BROWSER);
    private static final String RUNMODE = PropertiesReader.returnKey(Configurations.RUNMODE);
    private static final String WEBPLATFORM = PropertiesReader.returnKey(Configurations.WEBPLATFORM);
    private static final String URL = PropertiesReader.returnKey(Configurations.URL);
    private static  String dirForCreateExtentReport = "";


    private static final String ERRORMESSAGE = "Su intento de inicio de sesión no se realizó correctamente. Por favor, inténtelo de nuevo.";
    private static final String HOMEURL =  "https://siee.sepyc.gob.mx/ControlEscolar/vista.aspx";

    public static String getBrowser() {
        return BROWSER;
    }

    public static String getRunmode() {
        return RUNMODE;
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
        System.out.println(Browsers.valueOf(BROWSER.toUpperCase()));
        return Browsers.valueOf(BROWSER.toUpperCase());
    }

    public static RunMode getRunModeEnum() {
        System.out.println(RunMode.valueOf(RUNMODE.toUpperCase()));
        return RunMode.valueOf(RUNMODE.toUpperCase());
    }

    public static WebPlatform getWebPlatformEnum() {
        System.out.println(WebPlatform.valueOf(WEBPLATFORM.toUpperCase()));
        return WebPlatform.valueOf(WEBPLATFORM.toUpperCase());
    }
}

