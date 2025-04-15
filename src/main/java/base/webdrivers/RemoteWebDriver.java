package base.webdrivers;

import utilities.web.remote.docker.Docker;
import constants.Constants;
import enums.WebPlatform;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class RemoteWebDriver {
    private RemoteWebDriver() {

    }


    private static Map<WebPlatform, Supplier<WebDriver>> MAP = new EnumMap<>(WebPlatform.class);

    static {
        Supplier<WebDriver> DOCKER = Docker::getRemoteDriver;
        MAP.put(WebPlatform.DOCKER, DOCKER);
    }

    public static WebDriver getRemoteDriver2() {
        return MAP.get(Constants.getWebPlatformEnum()).get();
    }

    public static WebDriver getRemoteDriver() {//String browser, Object[] data
        if (WebPlatform.DOCKER == Constants.getWebPlatformEnum()) {
            return Docker.getRemoteDriver();
        }
        return null;
    }


}
