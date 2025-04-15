package pages.homepage.components;

import enums.ExplicitWaitStrategy;
import org.openqa.selenium.By;
import pages.homepage.enums.MENUS;
import pages.homepage.enums.SUBMENU;
import utilities.CustomMethods;
public  class TopMenuComponentHomePage extends CustomMethods{

    private static final String menu = "//div[@id = 'menuContainer']/child::ul/child::li/a[(text()= '%s')]";
    private static final String subMenu = "//div[@id = 'menuContainer']/ul/li/ul/li/a[(text()= '%s')]";


    private static By dynamicXpath(String xpath, Object... replacement) {
        String resolvedXPath = String.format(xpath,replacement);
        return By.xpath(resolvedXPath);

    }
    public TopMenuComponentHomePage clickMenu(MENUS menus) {
        click(dynamicXpath(menu, menus.getName()), menus.getName(), ExplicitWaitStrategy.CLICKABLE); // to lower case is used to normalize the DOM
        return this;
    }

    public void clickSubMenu(SUBMENU subMenuFromTest) {//MENUS menuFromTest,
        //clickMenu(menuFromTest);
        click(dynamicXpath(subMenu, subMenuFromTest.getName()), subMenuFromTest.getName(),ExplicitWaitStrategy.CLICKABLE);
    }



}
