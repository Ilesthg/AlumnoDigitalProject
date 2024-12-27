package org.utilities.BrowsersManagers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeManager {
    private EdgeManager(){};
    public static WebDriver edgeManagerLocal(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        return new EdgeDriver(edgeOptions);
    }
    public static RemoteWebDriver edgeManagerRemote(String browserName){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);//map.get("Browser") || String browser
        capabilities.setCapability("browserVersion", "114.0");   // Usa "browserVersion" en lugar de "chromeVersion"
        capabilities.setCapability("acceptInsecureCerts", true);
        //capabilities.setCapability("platformName", "WINDOWS");
        /*        capabilities.setCapability("goog:chromeOptions", new HashMap<String, Object>() {{
                    put("args", Arrays.asList("--headless", "--incognito"));
                }});
        */

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
