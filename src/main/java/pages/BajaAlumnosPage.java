package pages;

import enums.ExplicitWaitStrategy;
import fixtures.model.BajaAlumnosPOJO;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.enums.MENUS;
import pages.enums.SUBMENU;
import pages.page_components.TopMenuComponent;
import utilities.CustomMethods;

public final class BajaAlumnosPage extends CustomMethods {

    private static final By PRIMER_APELLIDO_INPUT_BOX = By.xpath("//input[@id='ContentPlaceHolder1_txtApellidoPaternoBusqueda']");
    private static final By SEGUNDO_APELLIDO_INPUT_BOX = By.xpath("//input[@id='ContentPlaceHolder1_txtApellidoMaternoBusqueda']");
    private static final By NOMBRE_INPUT_BOX = By.xpath("//input[@id='ContentPlaceHolder1_txtNombreBusqueda']");
    private static final By CURP_INPUT_BOX = By.xpath("//input[@id='ContentPlaceHolder1_txtCurpBusqueda']");
    private static final By SELECT_WEB_ELEMENT = By.xpath("//select[@id='ContentPlaceHolder1_ddlTipoBusqueda']");

    private final TopMenuComponent topMenuComponent;

    public BajaAlumnosPage() {
        this.topMenuComponent = new TopMenuComponent();
    }

    public void navigateToBajaAlumno() {
        topMenuComponent.clickMenu(MENUS.CAPTURAS);
        topMenuComponent.clickSubMenu(SUBMENU.BAJA_ALUMNO);
    }


    private void setPrimerApellido(String primerApellido) {
        sendKeys(PRIMER_APELLIDO_INPUT_BOX, primerApellido, "Primer Apellido", ExplicitWaitStrategy.PRESENT);
    }

    private void setSegundoApellidoInputBox(String segundoApellido) {
        sendKeys(SEGUNDO_APELLIDO_INPUT_BOX, segundoApellido, "Segundo Apellido");
    }

    private void setNombreInputBox(String nombre) {
        sendKeys(NOMBRE_INPUT_BOX, nombre, "Nombre", ExplicitWaitStrategy.PRESENT);
    }

    private void setCurpInputBox(String curp) {
        sendKeys(CURP_INPUT_BOX, curp, "CURP");
    }


    public BajaAlumnosPage deleteWithCURP() {
        consumerSelect(returnWebElement(SELECT_WEB_ELEMENT), select -> {
            select.selectByVisibleText("CURP");
        });
        return this;
    }

    private void fillDataNombre(BajaAlumnosPOJO bajaAlumnoPOJO) {
        setPrimerApellido(bajaAlumnoPOJO.getPrimerApellido());
        setSegundoApellidoInputBox(bajaAlumnoPOJO.getSegundoApellido());
        setNombreInputBox(bajaAlumnoPOJO.getNombre());

    }

    private void fillDataCurp(BajaAlumnosPOJO bajaAlumnoPOJO) {
        setCurpInputBox(bajaAlumnoPOJO.getCurp());
    }

    public void fillData(BajaAlumnosPOJO bajaAlumnoPOJO) {
        Select select = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(SELECT_WEB_ELEMENT)));

        if ((select.getFirstSelectedOption().getText().equalsIgnoreCase("Nombre"))) {
            fillDataNombre(bajaAlumnoPOJO);
        } else {
            fillDataCurp(bajaAlumnoPOJO);
        }


    }
}
