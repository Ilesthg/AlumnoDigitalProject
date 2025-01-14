package fixtures.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public  class BajaAlumnoPOJO {


    private String primerApellido;
    private String segundoApellido;
    private String nombre;
    private String curp;
    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurp() {
        return curp;
    }
}
