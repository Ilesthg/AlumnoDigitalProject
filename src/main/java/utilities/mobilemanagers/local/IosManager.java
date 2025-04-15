package utilities.mobilemanagers.local;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class IosManager {

  private IosManager() {
  }

  public static WebDriver getDriver() {
    XCUITestOptions options = new XCUITestOptions();
    options.setDeviceName("iPhone 13 Pro Max")
      .setApp(System.getProperty("user.dir") + "/ios-app.zip");
      try {
          return new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
      } catch (MalformedURLException e) {
          throw new RuntimeException(e);
      }
  }
}
