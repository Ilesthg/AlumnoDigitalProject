package org.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageAlumnoDigital extends BaseDriver {

    private final By inputEmail = By.xpath("//input[@title = 'Usuario']");
    private final By inputPassword= By.xpath("//input[@title = 'Contraseña']");

    @Test
    public void loginMethod() {
        WebDriver driver = BaseDriver.getDriverBaseTest();
        driver.findElement(inputEmail).sendKeys("Hola");
        driver.findElement(inputPassword).sendKeys("Pepe");
    }

}
