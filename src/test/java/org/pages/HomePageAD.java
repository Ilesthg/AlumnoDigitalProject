package org.pages;

import org.base.ParallelDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.utilities.CustomMethods;

public final class HomePageAD extends CustomMethods {
    //translate will normalize the Dom, and make the value to lowerCase

    private static final String menu = "//div[@id = 'menuContainer']/child::ul/child::li/a[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '%s']";
    private static final String subMenu = "//div[@id = 'menuContainer']/child::ul/child::li/a[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '%s']/following-sibling::ul/child::li/a[text()= '%s']";


//    public static By getXPathWithWildcard(String xpath, String replacement) {
//        //String xpath = String.valueOf(by);/*If you need dynamic locators often, handling them as String templates and converting to By when needed is the recommended pattern.*/
//        String resolvedXPath = xpath.replace("{value}", replacement);// Will depend on the menu
//        return By.xpath(resolvedXPath);
//
//    }

    /* public static String replacementMenu(String xpath, String replacement) {
        String resolvedXPath = xpath.replace("{value}", replacement);// Will depend on the menu
        return resolvedXPath;
    }*/
    public static By getXPathWith(String xpath, Object... replacement) {
        String resolvedXPath = String.format(xpath,replacement);
        return By.xpath(resolvedXPath);

    }
    public static void getMenu(String menuFromTest){
        WebDriver driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        driver.findElement(getXPathWith(menu,menuFromTest.toLowerCase())).click();
    }
    public static void getSubMenu(String menuFromTest, String subMenuFromTest){
        WebDriver driver = ParallelDriver.getInstanceParallelDriver().getWebDriver();
        getMenu(menuFromTest);
        driver.findElement(getXPathWith(subMenu,menuFromTest.toLowerCase(),subMenuFromTest)).click();

    }




}
