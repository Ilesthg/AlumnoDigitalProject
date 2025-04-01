package pages;

import org.openqa.selenium.By;
import utilities.CustomMethods;

public final class HomePageAD extends CustomMethods {
    //translate will normalize the Dom, and make the value to lowerCase

    private static final String menu = "//div[@id = 'menuContainer']/child::ul/child::li/a[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '%s']";
    private static final String MENU = "Menu";// private bc no one can access outside here, final bc value wont change, and static cause it will be shared among all threads to increase performance

    private static final String subMenu = "//div[@id = 'menuContainer']/child::ul/child::li/a[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '%s']/following-sibling::ul/child::li/a[text()= '%s']";
    private static final String SUBMENU = "SubMenu";

 /*   public static By getXPathWithWildcard(String xpath, String replacement) {
       // String xpath = String.valueOf(by);//If you need dynamic locators often, handling them as String templates and converting to By when needed is the recommended pattern.*//*
        String resolvedXPath = xpath.replace("{value}", replacement);// Will depend on the menu
        return By.xpath(resolvedXPath);
*/
    /* public static String replacementMenu(String xpath, String replacement) {
        String resolvedXPath = xpath.replace("{value}", replacement);// Will depend on the menu
        return resolvedXPath;
    }*/
    private static By getXPathWith(String xpath, Object... replacement) {
        String resolvedXPath = String.format(xpath,replacement);
        return By.xpath(resolvedXPath);

    }
    public  void getMenu(String menuFromTest){
        click(getXPathWith(menu,menuFromTest.toLowerCase()),menuFromTest);

    }
    public  void getSubMenu(String menuFromTest, String subMenuFromTest){
        getMenu(menuFromTest);
        click(getXPathWith(subMenu,menuFromTest.toLowerCase(),subMenuFromTest),subMenuFromTest);
    }




}
