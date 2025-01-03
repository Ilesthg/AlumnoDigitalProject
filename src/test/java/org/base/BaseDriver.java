package org.base;

import org.enums.Configurations;
import org.openqa.selenium.WebDriver;
import org.resources.PropertiesReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseDriver {
    protected BaseDriver() {
    }//Not allow to create instance from BaseTest, only inheritance

    private WebDriver driver;


@BeforeMethod
    public void initDriver() {


        if (driver == null) {
            driver = BrowserFactory.generateWebDriver();
            ParallelDriver.getInstanceParallelDriver().setWebDriver(driver);
        }
        //ParallelDriver.getInstanceParallelDriver().getWebDriver().get("https://siee.sepyc.gob.mx/");
        // ParallelDriver.getInstanceParallelDriver().getWebDriver().manage().window().maximize();
        driver.get("https://siee.sepyc.gob.mx/");
        driver.manage().window().maximize(); // Maximiza la ventana del navegador

    }


 @AfterMethod
    public void closeDriver() {
    /*    if (driver != null) {
            driver.close();
        }*/
    }

/*    public static WebDriver getDriverBaseTest(){
return driver;
    }*/


}
