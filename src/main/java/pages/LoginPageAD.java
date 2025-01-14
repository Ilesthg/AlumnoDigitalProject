package pages;

import constants.Constants;
import enums.ExplicitWaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CustomMethods;

import java.util.HashMap;
import java.util.List;

public final class LoginPageAD extends CustomMethods {

    private static final By inputEmail = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$Login2$UserName']");
    private static final String TXTEMAIL = "Email";// private bc no one can access outside here, final bc value wont change, and static cause it will be shared among all threads to increase performance


    private static final By inputPassword = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$Login2$Password']");
    private static final String TXTPASSWORD= "Contrase;a";// private bc no one can access outside here, final bc value wont change, and static cause it will be shared among all threads to increase performance


    private static final By buttonIngresar = By.xpath("//input[@name= 'ctl00$ContentPlaceHolder1$Login2$LoginButton']");
    private static final String BTTNINGRESAR = "Boton Ingresar";// private bc no one can access outside here, final bc value wont change, and static cause it will be shared among all threads to increase performance


    private static final By linkCtrlEscolar = By.xpath("//ul[@id='ic-menu']//a[@href='#']");
    private static final String LINKCONTROLESCOLAR = "Link Control Escolar";

    private static final By messages = By.xpath("//div[@id= 'toast-container']/div/button");


    private static final By mandatoryUsername = By.xpath("//span[@id='ContentPlaceHolder1_Login2_UserNameRequired']");
    private static final By mandatoryPassword = By.xpath("//span[@id='ContentPlaceHolder1_Login2_PasswordRequired']");
    private static final By errorMessage = By.xpath("//td[normalize-space()='Su intento de inicio de sesión no se realizó correctamente. Por favor, inténtelo de nuevo.']");


    public LoginPageAD() {
    }

    public HomePageAD validLogin(HashMap<String, String> data) {
        sendUsernamePassword(data);
        submitButton();
        linkCtrlEscolar();
        closeMessages();
        return new HomePageAD();
    }



    public LoginPageAD sendUsernamePassword(HashMap<String, String> data) {
        sendKeys(inputEmail, data.get("username"),TXTEMAIL);
        sendKeys(inputPassword, data.get("password"),TXTPASSWORD);
        return this;
    }

    public LoginPageAD submitButton() {
        click(buttonIngresar, BTTNINGRESAR, ExplicitWaitStrategy.CLICKABLE);
        return this;

    }

    public LoginPageAD linkCtrlEscolar() {
        click(linkCtrlEscolar,LINKCONTROLESCOLAR,ExplicitWaitStrategy.CLICKABLE);
        return this;
    }

    public void closeMessages() {
        //switchToAlertAndAccept();
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(messages));

        for (int i = 0; i < elementList.size(); i++) {
            System.out.println( elementList.get(i).getText());
           // elementList.get(i).click();
            click(elementList.get(i), elementList.get(i).getText());
        }
    }


    public boolean areMandatoryFieldsPresent() {
        return (!driver.findElement(mandatoryUsername).isDisplayed() || !driver.findElement(mandatoryPassword).isDisplayed());//True if username and password data is present, false is inputs field are empty
    }


    public boolean isRedirected() {
        return driver.getCurrentUrl().equalsIgnoreCase(Constants.getHomeUrl());
    }

    public boolean isMessageDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage)).isDisplayed();
        //return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isErrorMessageCorrect() {
        return driver.findElement(errorMessage).getText().equalsIgnoreCase(Constants.getErrormessage());
    }


}
