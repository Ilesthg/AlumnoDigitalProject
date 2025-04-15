package pages.homepage.enums;

public enum MENUS {

    CAPTURAS("Capturas"),
    IMPRESION("Impresión"),
    CONSULAS("Consultas"),
    SELECCION_DE_ESCUELA("Seleccion de escuela"),
    CERRAR_SESION("Cerrar Sesion");

//proerties
    private final String name;

//constructor
    MENUS(String name) {
        this.name = name;
    }
//methods to get name of enum
    public String getName() {
        return name;
    }
}
