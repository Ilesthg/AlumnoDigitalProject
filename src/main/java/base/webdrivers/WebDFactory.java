package base.webdrivers;

import constants.Constants;
import enums.RunMode;
import org.openqa.selenium.WebDriver;

public class WebDFactory {
    private WebDFactory() {
    }


    public static WebDriver generateWebDriver() {

     /*   try {
          return  (RunMode.LOCAL == Constants.getWebRunModeEnum() )
                    ? LocalWebDriver.getLocalDriver()
                    : RemoteWebDriver.getRemoteDriver();
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid run mode: " + Constants.getWebRunModeEnum());
           // throw new RuntimeException("Failed to generate WebDriver: " + e.getMessage(), e);
        }*/


        try {
            if (RunMode.LOCAL == Constants.getWebRunModeEnum()) {
                return LocalWebDriver.getLocalDriver();
            } else if (RunMode.REMOTE == Constants.getWebRunModeEnum()) {
                return RemoteWebDriver.getRemoteDriver2();
            } else {
                throw new IllegalArgumentException("Invalid run mode: " + Constants.getWebRunModeEnum());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate WebDriver: " + e.getMessage(), e);
        }
    }
}
