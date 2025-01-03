package org.constants;


import org.enums.Browsers;
import org.enums.Configurations;
import org.enums.RunMode;
import org.enums.WebPlatform;
import org.resources.PropertiesReader;

public final class Constants {

    private Constants() {
    }

    private static String browser = PropertiesReader.returnKey(Configurations.BROWSER);
    private static String runMode = PropertiesReader.returnKey(Configurations.RUNMODE);
    private static String webPlatform = PropertiesReader.returnKey(Configurations.WEBPLATFORM);


    public static String getBrowser() {
        return browser;
    }

    public static String getRunmode() {
        return runMode;
    }
    public static String getWebPlatform() {
        return webPlatform;
    }

    public static Browsers getBrowserEnum() {
        System.out.println(Browsers.valueOf(browser.toUpperCase()));
        return Browsers.valueOf(browser.toUpperCase());
    }

    public static RunMode getRunModeEnum() {
        System.out.println( RunMode.valueOf(runMode.toUpperCase()));
        return RunMode.valueOf(runMode.toUpperCase());
    }

    public static WebPlatform getWebPlatformEnum() {
        System.out.println(WebPlatform.valueOf(webPlatform.toUpperCase()));
        return WebPlatform.valueOf(webPlatform.toUpperCase());
    }
}

