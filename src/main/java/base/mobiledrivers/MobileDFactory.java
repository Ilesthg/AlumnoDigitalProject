package base.mobiledrivers;

import constants.Constants;
import enums.RunMode;
import org.openqa.selenium.WebDriver;

public class MobileDFactory {
    public static WebDriver generateMobileDriver() {

        try {
            if (RunMode.LOCAL == Constants.getMobileRunModeEnum()) {
                return LocalMobileDriver.getDriver();
            } else if (RunMode.REMOTE == Constants.getMobileRunModeEnum()) {
                    return null;//Unimplemented
            } else {
                throw new IllegalArgumentException("Invalid run mode: " + Constants.getMobileRunModeEnum());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate WebDriver: " + e.getMessage(), e);
        }





    }
}
