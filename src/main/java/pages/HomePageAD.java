package pages;

import pages.page_components.TopMenuComponent;
import pages.enums.MENUS;
import pages.enums.SUBMENU;
import utilities.CustomMethods;

public final class HomePageAD extends CustomMethods {
    //translate will normalize the Dom, and make the value to lowerCase
    //private static final String menu = "//div[@id = 'menuContainer']/child::ul/child::li/a[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '%s']";
    //private static final String subMenu = "//div[@id = 'menuContainer']/child::ul/child::li/a[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '%s']/following-sibling::ul/child::li/a[text()= '%s']";

    /*private static final String MENU = "Menu";// private bc no one can access outside here, final bc value wont change, and static cause it will be shared among all threads to increase performance
        private static final String SUBMENU = "SubMenu";*/
    private static final String menu = "//div[@id = 'menuContainer']/child::ul/child::li/a[(text()= '%s')]";
    private static final String subMenu = "//div[@id = 'menuContainer']/ul/li/ul/li/a[(text()= '%s')]";
    private TopMenuComponent topMenuComponent;

    //Constructor
    public HomePageAD() {
        topMenuComponent = new TopMenuComponent();
    }

    public TopMenuComponent getTopMenuComponentHomePage() {
        return topMenuComponent;
    }

    public void navigateActaulizarPadres(){
     topMenuComponent.clickMenu(MENUS.CAPTURAS)
                .clickSubMenu(SUBMENU.ACTUALIZACION_DE_DATOS_PADRES);
    }

    public BajaAlumnos navigateToBajaAlumno(){
        topMenuComponent.clickMenu(MENUS.CAPTURAS);
        topMenuComponent.clickSubMenu(SUBMENU.BAJA_ALUMNO);
        return new BajaAlumnos();
    }

 /*   private static By getXPathWith(String xpath, Object... replacement) {
        String resolvedXPath = String.format(xpath, replacement);
        return By.xpath(resolvedXPath);

    }

    public HomePageAD clickMenu(MENUS menus) {
        click(getXPathWith(menu, menus.getName()), menus.getName(), ExplicitWaitStrategy.CLICKABLE); // to lower case is used to normalize the DOM
        return this;
    }

    public void clickSubMenu(SUBMENU subMenuFromTest) {//MENUS menuFromTest,
        //clickMenu(menuFromTest);
        click(getXPathWith(subMenu, subMenuFromTest.getName()), subMenuFromTest.getName(), ExplicitWaitStrategy.CLICKABLE);
    }*/

/*
  public void clickMenu(String menu) {
        click(getXPathWith(menu, menu), menu); // to lower case is used to normalize the DOM

    }

          public static By getXPathWithWildcard(String xpath, String replacement) {
          // String xpath = String.valueOf(by);//If you need dynamic locators often, handling them as String templates and converting to By when needed is the recommended pattern.*//*
        String resolvedXPath = xpath.replace("{value}", replacement);// Will depend on the menu
        return By.xpath(resolvedXPath);

     public static String replacementMenu(String xpath, String replacement) {
        String resolvedXPath = xpath.replace("{value}", replacement);// Will depend on the menu
        return resolvedXPath;
    }
*/


}
