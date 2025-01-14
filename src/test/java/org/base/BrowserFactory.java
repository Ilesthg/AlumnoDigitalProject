package org.base;

import org.constants.Constants;
import org.enums.RunMode;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    private BrowserFactory() {
    }


    protected static WebDriver generateWebDriver() {

        try {
            if (RunMode.LOCAL == Constants.getRunModeEnum()) {
                return LocalDriver.getLocalDriver();
            } else if (RunMode.REMOTE == Constants.getRunModeEnum()) {
                return RemoteDriver.getRemoteDriver();
            } else {
                throw new IllegalArgumentException("Invalid run mode: " + Constants.getRunModeEnum());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate WebDriver: " + e.getMessage(), e);
        }
    }
}
