package org.pages;

import org.base.ParallelDriver;
import org.enums.ExplicitWaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utilities.CustomMethods;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public final class LoginPageAD extends CustomMethods {

    private static final By inputEmail = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$Login2$UserName']");
    private static final By inputPassword = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$Login2$Password']");
    private static final By buttonIngresar = By.xpath("//input[@name= 'ctl00$ContentPlaceHolder1$Login2$LoginButton']");
    private static final By linkCtrlEscolar = By.xpath("//ul[@id='ic-menu']//a[@href='#']");
    private static final By messages = By.xpath("//div[@id= 'toast-container']//div[@class = 'toast toast-warning']");

    private static final By mandatoryUsername = By.xpath("//span[@id='ContentPlaceHolder1_Login2_UserNameRequired']");
    private static final By mandatoryPassword = By.xpath("//span[@id='ContentPlaceHolder1_Login2_PasswordRequired']");

    private static final By errorMessage = By.xpath("//td[normalize-space()='Su intento de inicio de sesión no se realizó correctamente. Por favor, inténtelo de nuevo.']");


    public LoginPageAD() {
    }


    public LoginPageAD sendUsernamePassword(HashMap<String, String> data) {
        sendKeys(inputEmail,data.get("username"));
        sendKeys(inputPassword, data.get("password"));
        return this;
    }

    public LoginPageAD submitButton() {
        click(buttonIngresar, ExplicitWaitStrategy.CLICKABLE);
        return this;

    }

    public LoginPageAD linkCtrlEscolar() {
        click(linkCtrlEscolar);
        return this;
    }

    public void closeMessages() {

        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(messages));

        for (int i = 0; i < elementList.size(); i++) {
            elementList.get(i).click();
        }
    }

    public boolean mandatoryFieldsPresent() {
        return (!driver.findElement(mandatoryUsername).isDisplayed() || !driver.findElement(mandatoryPassword).isDisplayed());//True if username and password data is present, false is inputs field are empty
    }


    public boolean isRedirected() {
        return driver.getCurrentUrl().equalsIgnoreCase("https://siee.sepyc.gob.mx/ControlEscolar/vista.aspx");
    }

    public boolean isMessageDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage)).isDisplayed();
        //return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isErrorMessageCorrect() {
        return driver.findElement(errorMessage).getText().equalsIgnoreCase("Su intento de inicio de sesión no se realizó correctamente. Por favor, inténtelo de nuevo.");
    }



}
