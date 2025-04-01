package base;

import constants.Constants;
import enums.WebPlatform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class RemoteDriver {
    private RemoteDriver() {

    }

    public static WebDriver getRemoteDriver() {//String browser, Object[] data
        if (Constants.getWebPlatformEnum() == WebPlatform.DOCKER) {
            return Docker.getRemoteDriver();
        }
        return null;
    }


}
