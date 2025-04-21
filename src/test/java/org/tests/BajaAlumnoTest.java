package org.tests;

import base.BaseDriver;
import fixtures.model.BajaAlumnosPOJO;
import org.testng.annotations.Test;
import pages.LoginPageAD;
import utilities.DataProviderFiltered;

import java.util.HashMap;

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
    public void validBajaAlumno(HashMap<String, String> data, BajaAlumnosPOJO bajaAlumnos) {

        new LoginPageAD()
                .validLogin(data)
                .navigateToBajaAlumno()
                //.deleteWithCURP()
                .fillData(bajaAlumnos);



    }

}
