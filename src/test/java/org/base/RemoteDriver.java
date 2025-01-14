package org.base;

import org.constants.Constants;
import org.enums.WebPlatform;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class RemoteDriver {
    private RemoteDriver() {

    }

    public static RemoteWebDriver getRemoteDriver() {//String browser, Object[] data
        if (Constants.getWebPlatformEnum() == WebPlatform.DOCKER) {
            return Docker.getRemoteDriver();
        }
        return null;
    }


}
