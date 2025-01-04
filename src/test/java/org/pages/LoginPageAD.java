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
    private static final By linkCtrlEscolar = By.xpath("//ul[@id='ic-menu']//a[@href='#']");
    private static final By messages = By.xpath("//div[@id= 'toast-container']//div[@class = 'toast toast-warning']");

    private static final By mandatoryUsername = By.xpath("//span[@id='ContentPlaceHolder1_Login2_UserNameRequired']");
    private static final By mandatoryPassword = By.xpath("//span[@id='ContentPlaceHolder1_Login2_PasswordRequired']");


    WebDriver driver;

    public LoginPageAD() {
        this.driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
    }

    public LoginPageAD loginMethod() {

        driver.findElement(inputEmail).sendKeys("25epr0175u");
        driver.findElement(inputPassword).sendKeys("S");
        driver.findElement(buttonIngresar).click();
        driver.findElement(linkCtrlEscolar).click();
        return new LoginPageAD();
    }

    /*public boolean errorMessageDisplayed(){
        return driver.findElement();
    }*/

    public Boolean mandatoryFieldsPresent() {
        if (driver.findElement(mandatoryUsername).isDisplayed() || driver.findElement(mandatoryPassword).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRedirected() {
        return driver.getCurrentUrl().equalsIgnoreCase("https://siee.sepyc.gob.mx/Sistemas/seleccionarSistema.aspx");
    }


    public void closeMessages() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(messages));

        for (int i = 0; i < elementList.size(); i++) {
            elementList.get(i).click();
        }
    }
}
