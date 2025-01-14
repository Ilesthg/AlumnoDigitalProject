package fixtures.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import fixtures.model.BajaAlumnoPOJO;

public class BajaAlumnoTemplate implements TemplateLoader {

    @Override
    public void load() {
        // Define the template for the BajaAlumnoPOJO class
        // This is where you would define how to create instances of BajaAlumnoPOJO
        // using the FixtureFactory library.
        // Example:

        Fixture.of(BajaAlumnoPOJO.class).addTemplate("valid", new Rule() {{
            add("primerApellido", "Doe");
            add("segundoApellido", "Smith");
            add("nombre", "John");
            add("curp", "DOES123456HDFRRT00");
        }});



    }



}
