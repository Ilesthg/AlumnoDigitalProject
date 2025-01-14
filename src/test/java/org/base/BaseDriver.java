package org.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Objects;

public class BaseDriver {
    protected BaseDriver() {
    }

    private WebDriver driver;


    @BeforeMethod
    protected void initDriver() {
        WebDriver driver = BrowserFactory.generateWebDriver();
        ParallelDriver.getInstanceParallelDriver().setWebDriver(driver);
        this.driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        this.driver.get("https://siee.sepyc.gob.mx/");
        this.driver.manage().window().maximize();

    }


 @AfterMethod
 protected void closeDriver() {
            ParallelDriver.getInstanceParallelDriver().closeWebDriver();

    }

/*    public static WebDriver getDriverBaseTest(){
return driver;
    }*/


}






