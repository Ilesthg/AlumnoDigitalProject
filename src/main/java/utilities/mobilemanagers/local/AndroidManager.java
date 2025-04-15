package utilities.mobilemanagers.local;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class AndroidManager {

  private AndroidManager() {
  }

  public static WebDriver getDriver() {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setApp("C:/Users/vhgm/IdeaProjects/AlumnoDigitalProject/mdandroid-app.apk");
      try {
          return new AndroidDriver(new URL("http://192.168.1.78:4723/wd/hub"), options);
      } catch (MalformedURLException e) {
          throw new RuntimeException(e);
      }
  }
}
