package base;

import base.webdrivers.WebDFactory;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import base.mobiledrivers.MobileDFactory;

public class BaseDriver {
    protected BaseDriver() {
    }

    private WebDriver driver;


    @BeforeMethod
    protected void initDriver() {
        WebDriver driver = WebDFactory.generateWebDriver();


        ParallelDriver.getInstanceParallelDriver().setWebDriver(driver);
        this.driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        this.driver.get(Constants.getUrl());
        this.driver.manage().window().maximize();

    }
    @AfterMethod
    protected void closeDriver() {
        ParallelDriver.getInstanceParallelDriver().closeWebDriver();

    }
    protected String getUrl() {
        return Constants.getUrl();
    }

  /*  public static WebDriver getWeb(){
        WebDriver driver2 = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        WebDriver driver1= returnDriver();
    }

    public WebDriver returnDriver(){
        return new ChromeDriver();
    }*/

}






