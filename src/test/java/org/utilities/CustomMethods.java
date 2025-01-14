package org.utilities;

import org.base.ParallelDriver;
import org.enums.ExplicitWaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomMethods {
    // private final WebDriver driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected CustomMethods() {
        this.driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }


    protected void sendKeys(By by, String valueToSend) {
        try {
            //  WebDriver driver = GetDriverStaticM.getDriverStaticMethod();
            driver.findElement(by).sendKeys(valueToSend);
            System.out.println("Send Keys Method SUCCESS, able to send key on element: ->" + by + " with value: ->" + valueToSend);
        } catch (NullPointerException e) {
            throw new RuntimeException("Failed to send keys to element located by: " + by, e);
        }
    }

    protected void sendKeys(By by, String valueToSend, ExplicitWaitStrategy explicitWaitStrategy) {
        try {
            waitStrategy(by, explicitWaitStrategy).sendKeys(valueToSend);//2 option
        } catch (Exception e) {
            throw new RuntimeException("Failed to send keys to element located by: " + by, e);
        }
    }


    protected void click(By by) {
        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on element located by: " + by, e);
        }
    }

    protected void click(By by, ExplicitWaitStrategy explicitWaitStrategy) {
        try {
            waitStrategy(by, explicitWaitStrategy).click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on element located by: " + by, e);
        }
    }

    protected void clear(By by) {
        try {
            driver.findElement(by).clear();
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear element located by: " + by, e);
        }
    }

    protected void getText(By by, String valueToSend) {
        try {

            driver.findElement(by).getText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get text on element located by: " + by, e);
        }
    }

    protected void getText(By by, String valueToSend, ExplicitWaitStrategy explicitWaitStrategy) {
        try {
            waitStrategy(by, explicitWaitStrategy).getText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get text on element located by: " + by, e);
        }
    }

    protected Boolean isDisplayed(By by) {
        boolean flag;
        try {
            flag = false;
            flag = driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException("Failed to determine if element is displayed located by: " + by, e);
        }
        return flag;
    }

    protected void moveToElement(WebElement element, String elementName) {
        try {
            //WebDriver driver = GetDriverStaticM.getDriverStaticMethod();
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("argument[0].scrollIntoView(true);", element);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            //  logger.log(Status.PASS, MarkupHelper.createLabel("Move to Element method SUCCESS,: " + elementName, ExtentColor.GREEN));
        } catch (Exception e) {
            throw new RuntimeException(e);
            //logger.log(Status.FAIL, MarkupHelper.createLabel("Move to Element method FAILED,: " + elementName + " due to exception: " + e, ExtentColor.RED));
        }
    }

    protected static void selectDropDownByVisibleText(WebElement webElement, String elementName, String visibleText) {
        try {
            Select s = new Select(webElement);
            s.selectByVisibleText(visibleText);
            // logger.log(Status.PASS, MarkupHelper.createLabel("Select DD by Visible Text method SUCCESS,: " + elementName, ExtentColor.GREEN));
        } catch (Exception e) {
            throw new RuntimeException(e);
            //  logger.log(Status.FAIL, MarkupHelper.createLabel("Select DD by Visible Text method FAILED,: " + elementName + " due to exception: " + e, ExtentColor.RED));
        }
    }

    private WebElement waitStrategy(By by, ExplicitWaitStrategy explicitWaitStrategy) {
        WebElement element = null;
        //WebDriver driver = GetDriverStaticM.getDriverStaticMethod();
        if (explicitWaitStrategy == ExplicitWaitStrategy.CLICKABLE) {
            return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(by));
        } else if (explicitWaitStrategy == ExplicitWaitStrategy.PRESENT) {
            return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (explicitWaitStrategy == ExplicitWaitStrategy.VISIBLE) {
            return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        return null;

    }

}
