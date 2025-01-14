package pages;

import fixtures.model.BajaAlumnoPOJO;
import javafx.util.Builder;
import org.openqa.selenium.By;
import pages.enums.MENUS;
import pages.enums.SUBMENU;
import pages.page_components.TopMenuComponent;
import utilities.CustomMethods;

public final class BajaAlumnos extends CustomMethods {

    private static final By PRIMER_APELLIDO_INPUT_BOX = By.xpath("//input[@id='ContentPlaceHolder1_txtApellidoPaternoBusqueda']");
    private static final By SEGUNDO_APELLIDO_INPUT_BOX = By.xpath("//input[@id='ContentPlaceHolder1_txtApellidoMaternoBusqueda']");
    private static final By NOMBRE_INPUT_BOX = By.xpath("//input[@id='ContentPlaceHolder1_txtNombreBusqueda']");


    private final TopMenuComponent topMenuComponent;

    public BajaAlumnos() {
        this.topMenuComponent = new TopMenuComponent();
    }

    public void navigateToBajaAlumno() {
        topMenuComponent.clickMenu(MENUS.CAPTURAS);
        topMenuComponent.clickSubMenu(SUBMENU.BAJA_ALUMNO);
    }


    private void setPrimerApellido(String primerApellido) {
        sendKeys(PRIMER_APELLIDO_INPUT_BOX, primerApellido, "Primer Apellido");
    }
    private void setSegundoApellidoInputBox(String segundoApellido) {
        sendKeys(SEGUNDO_APELLIDO_INPUT_BOX, segundoApellido, "Segundo Apellido");
    }
    private void setNombreInputBox(String nombre) {
        sendKeys(NOMBRE_INPUT_BOX, nombre, "Nombre");
    }
    public void fillData(BajaAlumnoPOJO bajaAlumnoPOJO) {
        setPrimerApellido(bajaAlumnoPOJO.getPrimerApellido());
        setSegundoApellidoInputBox(bajaAlumnoPOJO.getSegundoApellido());
        setNombreInputBox(bajaAlumnoPOJO.getNombre());

    }

}
