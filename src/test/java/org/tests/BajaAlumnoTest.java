package org.tests;

import base.BaseDriver;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import fixtures.model.BajaAlumnoPOJO;
import fixtures.template.BajaAlumnoTemplate;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BajaAlumnos;
import pages.LoginPageAD;
import utilities.DataProviderFiltered;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public final class BajaAlumnoTest extends BaseDriver {

    public BajaAlumnoTest() {
    }


/*    @DataProvider(name = "ValidDataFixtures")
    public Object[] validDataProvider(Method m) {
        List<Object> bajaAlumnoPOJO = Fixture.from(BajaAlumnoTemplate.class).gimme(2, "valid");
        return new Object[]{
                bajaAlumnoPOJO.toArray()
        };

    }

 */
    @Test( dataProvider = "DataFiltered", dataProviderClass = DataProviderFiltered.class)
    public void validBajaAlumno(HashMap<String, String> data, BajaAlumnoPOJO bajaAlumnos) {

        new LoginPageAD()
                .validLogin(data)
                .navigateToBajaAlumno()
                .changeToCurp()
                .fillData(bajaAlumnos);



    }

}
