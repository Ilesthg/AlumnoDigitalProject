package org.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.enums.Browsers;
import org.enums.Configurations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.resources.PropertiesReader;

public class BrowserFactory {
    private BrowserFactory() {}

  private static String browser = PropertiesReader.returnKey(Configurations.BROWSER);

    protected static WebDriver generateWebDriver() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximiza la ventana del navegador
        driver.get("https://alumnodigital.sepyc.gob.mx/Cuentas/IniciarSesion/vista.aspx");
        return driver;
    }
}
