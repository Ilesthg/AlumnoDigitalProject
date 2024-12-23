package org.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.enums.Configurations;
import org.openqa.selenium.WebDriver;
import org.resources.PropertiesReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseDriver {
    protected BaseDriver(){}//Not allow to create instance from BaseTest, only inheritance

    private static  WebDriver driver;


    @BeforeMethod
    public void initDriver(){

        String a = PropertiesReader.returnKey(Configurations.BROWSER);
        System.out.println(a);
        if (driver == null) {
           driver = BrowserFactory.generateWebDriver();
        }


    }


    @AfterMethod
    public void closeDriver(){
        if (driver != null) {
            driver.close();
        }
    }

    public static WebDriver getDriverBaseTest(){
return driver;
    }



}
