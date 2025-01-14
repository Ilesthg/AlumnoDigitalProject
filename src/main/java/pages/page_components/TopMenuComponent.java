package pages.page_components;

import enums.ExplicitWaitStrategy;
import org.openqa.selenium.By;
import pages.enums.MENUS;
import pages.enums.SUBMENU;
import utilities.CustomMethods;
public  class TopMenuComponent extends CustomMethods{

    private static final String MENU = "//div[@id = 'menuContainer']/child::ul/child::li/a[(text()= '%s')]";
    private static final String SUB_MENU = "//div[@id = 'menuContainer']/ul/li/ul/li/a[(text()= '%s')]";


    private static By dynamicXpath(String xpath, Object... replacement) {
        String resolvedXPath = String.format(xpath,replacement);
        return By.xpath(resolvedXPath);

    }
    public TopMenuComponent clickMenu(MENUS menus) {
        click(dynamicXpath(MENU, menus.getName()), menus.getName(), ExplicitWaitStrategy.CLICKABLE); // to lower case is used to normalize the DOM
        return this;
    }

    public void clickSubMenu(SUBMENU subMenuFromTest) {//MENUS menuFromTest,
        //clickMenu(menuFromTest);
        click(dynamicXpath(SUB_MENU, subMenuFromTest.getName()), subMenuFromTest.getName(),ExplicitWaitStrategy.CLICKABLE);
    }



}
