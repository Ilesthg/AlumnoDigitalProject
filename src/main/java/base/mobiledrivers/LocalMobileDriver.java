package base.mobiledrivers;

import constants.Constants;
import enums.MobileDevice;
import org.openqa.selenium.WebDriver;
import utilities.mobilemanagers.local.AndroidManager;
import utilities.mobilemanagers.local.IosManager;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalMobileDriver {

    private LocalMobileDriver() {
    }

    private static final Map<MobileDevice, Supplier<WebDriver>> MAP =
            new EnumMap<>(MobileDevice.class);

    static {
        MAP.put(MobileDevice.ANDROID, AndroidManager::getDriver); // why not AndroidManager.getDriver()
        MAP.put(MobileDevice.IOS, IosManager::getDriver);
    }

    public static WebDriver getDriver() {
        System.out.println("======"+ Constants.getMobileDevice());
        return MAP.get(Constants.getMobileDevice()).get();
    }

}