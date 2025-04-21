package utilities;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import fixtures.template.BajaAlumnoTemplate;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;

public final class DataFixtures {
    @DataProvider(name = "ValidDataFixtures")
    public Object[] validDataProvider(Method m) {


        // Load the templates from the specified package
        FixtureFactoryLoader.loadTemplates("src/main/java/fixtures/template");


        List<Object> bajaAlumnoPOJO = Fixture.from(BajaAlumnoTemplate.class).gimme(2, "valid");

        return new Object[]{
                bajaAlumnoPOJO.toArray()
        };

    }
}
