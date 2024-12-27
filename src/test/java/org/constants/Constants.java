package org.constants;

import org.enums.Browsers;
import org.enums.Configurations;
import org.enums.RunMode;
import org.resources.PropertiesReader;

public final class Constants {

    private Constants() {
    }

    private static String browser = PropertiesReader.returnKey(Configurations.BROWSER);
    private static String runmode = PropertiesReader.returnKey(Configurations.RUNMODE);


    public static String getBrowser() {
        return browser;
    }

    public static String getRunmode() {
        return runmode;
    }

    public static Browsers getBrowserEnum() {
        return Browsers.valueOf(browser.toUpperCase());
    }

    public static RunMode getRunModeEnum() {
        return RunMode.valueOf(runmode.toUpperCase());
    }
}
