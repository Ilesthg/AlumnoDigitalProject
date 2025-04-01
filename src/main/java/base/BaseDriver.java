package base;

import constants.Constants;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseDriver {
    protected BaseDriver() {
    }

    private WebDriver driver;


    @BeforeMethod
    protected void initDriver() {
        WebDriver driver = BrowserFactory.generateWebDriver();
        ParallelDriver.getInstanceParallelDriver().setWebDriver(driver);
        this.driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        this.driver.get(Constants.getUrl());
        this.driver.manage().window().maximize();

    }
    @AfterMethod
    protected void closeDriver() {
        ParallelDriver.getInstanceParallelDriver().closeWebDriver();

    }

  /*  public static WebDriver getWeb(){
        WebDriver driver2 = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        WebDriver driver1= returnDriver();
    }

    public WebDriver returnDriver(){
        return new ChromeDriver();
    }*/

}






