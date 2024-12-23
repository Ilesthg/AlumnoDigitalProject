package org.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.base.BaseDriver;
import org.base.ParallelDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageAlumnoDigital  {

    private static final By inputEmail = By.xpath("//input[@title = 'Usuario']");
    private static final By inputPassword= By.xpath("//input[@title = 'Contraseña']");
    private static final By buttonIngresar= By.xpath("//a[@id = 'ContentPlaceHolder1_Login1_LoginButton']");



    public static void loginMethod() {
        WebDriver driver = ParallelDriver.getInstanceParallelDriver().getThreadLocalWebDriver();
        driver.findElement(inputEmail).sendKeys("Hola");
        driver.findElement(inputPassword).sendKeys("Pepe");
        driver.findElement(buttonIngresar).click();
    }

}
