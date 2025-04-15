package pages.homepage.enums;

public enum SUBMENU {
    ACTUALIZACION_DE_DATOS_PADRES("Actualización de datos de padres"),
    ASIGNACION_ALUMNOS_GRUPOS("Asignación de alumnos a grupos"),
    BAJA_ALUMNOS("Baja de alumnos"),
    CAPTURA_NUEVOS_ALUMNOS("Captura de Alumnos Nuevos"),
    EVALUACIONES("Evaluaciones"),
    ACTUALIZACION_DE_DATOS_ALUMNO("Actualización de información para la atención del alumno"),
    TRALADO_DE_ALUMNOS("Traslado de alumnos"),
    AUTONOMIA_CURRICULAR("Autonomía Curricular"),
    CONTACTOS_CENTRO_TRABAJO("Contactos de Centros de Trabajo");


    /*
    * Pending to add sub menus for  Impresion, Consultas, Seleccion de escuela*/


    private final String name;

    SUBMENU(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

