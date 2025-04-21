package fixtures.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import fixtures.model.BajaAlumnosPOJO;
import org.testng.internal.junit.ArrayAsserts;

import java.util.Arrays;

public class BajaAlumnoTemplate implements TemplateLoader {

    @Override
    public void load() {
        // Define the template for the BajaAlumnosPOJO class
        // This is where you would define how to create instances of BajaAlumnosPOJO
        // using the FixtureFactory library.
        // Example:

        //controls data we are passing
        Fixture.of(BajaAlumnosPOJO.class).addTemplate("valid", new Rule() {{
            add("primerApellido", "Doe");
            add("segundoApellido", "Smith");
            add("nombre", "John");
            add("curp", "DOES123456HDFRRT00");
        }});
        Fixture.of(BajaAlumnosPOJO.class).addTemplate("invalid").inherits("valid", new Rule() {{
            add("primerApellido",uniqueRandom("Doe", "Smith1", "Johnson_()*%"));

        }});


    }

/*To load data into fixture from external file
 private final List<HashMap<String, String>> externalData;

    // Constructor to accept external data
    public BajaAlumnoTemplate(List<HashMap<String, String>> externalData) {
        this.externalData = externalData;
    }

    @Override

 Instead, it overwrites the same template ("valid") repeatedly for each row in the externalData list. This means that only the last row of data from externalData will be used in the "valid" template because each iteration replaces the previous one.
    public void load() {
        // Use external data to populate the template
        for (HashMap<String, String> data : externalData) {
            Fixture.of(BajaAlumnosPOJO.class).addTemplate("valid", new Rule() {{
                add("primerApellido", data.getOrDefault("primerApellido", "DefaultApellido"));
                add("segundoApellido", data.getOrDefault("segundoApellido", "DefaultApellido"));
                add("nombre", data.getOrDefault("nombre", "DefaultNombre"));
                add("curp", data.getOrDefault("curp", "DefaultCURP"));
            }});
        }
        /*




 */
/*
  Collect all values for each property from external data
  This will be pick all data from each column feed into a list and pass it to the fixture
   public void load() {
    List<String> primerApellidos = new ArrayList<>();
    List<String> segundoApellidos = new ArrayList<>();
    List<String> nombres = new ArrayList<>();
    List<String> curps = new ArrayList<>();

    for (HashMap<String, String> data : externalData) {
        primerApellidos.add(data.getOrDefault("primerApellido", "DefaultApellido"));
        segundoApellidos.add(data.getOrDefault("segundoApellido", "DefaultApellido"));
        nombres.add(data.getOrDefault("nombre", "DefaultNombre"));
        curps.add(data.getOrDefault("curp", "DefaultCURP"));
    }

    // Create a single template with random selection from the collected values
    Fixture.of(BajaAlumnosPOJO.class).addTemplate("valid", new Rule() {{
        add("primerApellido", random(primerApellidos.toArray()));
        add("segundoApellido", random(segundoApellidos.toArray()));
        add("nombre", random(nombres.toArray()));
        add("curp", random(curps.toArray()));
    }});
 */
/*
    }

    // Static method to create an instance with external data
    public static BajaAlumnoTemplate withExternalData(String filePath) {
        List<HashMap<String, String>> externalData = ExcelReader.excelReader(filePath);
        return new BajaAlumnoTemplate(externalData);
    }
*/

}
