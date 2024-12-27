package org.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.constants.Constants;
import org.enums.Browsers;
import org.enums.Configurations;
import org.enums.RunMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.resources.PropertiesReader;

public class BrowserFactory {
    private BrowserFactory() {}



    protected static WebDriver generateWebDriver() {





        if (RunMode.LOCAL == Constants.getRunModeEnum()) {
        return LocalDriver.getLocalDriver();
        }else if ( RunMode.REMOTE == Constants.getRunModeEnum()) {
/**/
        } else {
            System.out.println("Driver could not be set, returning null");
            throw new RuntimeException();
        }




        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximiza la ventana del navegador
        driver.get("https://siee.sepyc.gob.mx/");
        return driver;
    }
}
