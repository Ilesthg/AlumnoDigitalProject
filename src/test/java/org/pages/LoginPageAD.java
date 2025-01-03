package org.pages;

import org.base.ParallelDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class LoginPageAD {

    private static final By inputEmail = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$Login2$UserName']");
    private static final By inputPassword = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$Login2$Password']");
    private static final By buttonIngresar = By.xpath("//input[@name= 'ctl00$ContentPlaceHolder1$Login2$LoginButton']");
    private static By linkCtrlEscolar = By.xpath("//ul[@id='ic-menu']//a[@href='#']");
    private static final By messages = By.xpath("//div[@id= 'toast-container']//div[@class = 'toast toast-warning']");


    public static LoginPageAD loginMethod() {
        WebDriver driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        driver.findElement(inputEmail).sendKeys("25epr0175u");
        driver.findElement(inputPassword).sendKeys("S");
        driver.findElement(buttonIngresar).click();
        driver.findElement(linkCtrlEscolar).click();
        return new LoginPageAD();
    }

    public static void closeMessages() {
        WebDriver driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(messages));


        for (int i = 0; i < elementList.size(); i++) {
            elementList.get(i).click();
        }

    }

}
