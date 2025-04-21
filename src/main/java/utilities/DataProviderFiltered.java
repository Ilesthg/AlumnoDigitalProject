package utilities;

import br.com.six2six.fixturefactory.Fixture;
import fixtures.model.BajaAlumnosPOJO;
import org.testng.annotations.DataProvider;
import utilities.datareader.ExcelReader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProviderFiltered {
    @DataProvider(name = "ValidData")
    public Object[] validDataProvider(Method m) {
        List<HashMap<String, String>> hashMapList = ExcelReader.excelReader("Data");
        List<Object> validData = new ArrayList<>();

        for (HashMap<String, String> hashMaps : hashMapList) {
            if ("valid".equalsIgnoreCase(hashMaps.get("expected")) // m.getName().startsWith(hashMaps.get("expected")
                    && hashMaps.get("execute").equalsIgnoreCase("yes")){ // Filter valid rows
                validData.add(hashMaps);
            }
        }

        return validData.toArray();
    }

    @DataProvider(name = "InvalidData")
    public Object[] invalidDataProvider(Method m) {
        List<HashMap<String, String>> hashMapList = ExcelReader.excelReader("Data");
        List<Object> invalidData = new ArrayList<>();

        for (HashMap<String, String> hashMaps : hashMapList) {
            if ("invalid".equalsIgnoreCase(hashMaps.get("expected"))
                    && hashMaps.get("execute").equalsIgnoreCase("yes") ){ // Filter invalid rows
                invalidData.add(hashMaps);
            }
        }

        return invalidData.toArray();
    }


    //&& hashMaps.get("execute").equalsIgnoreCase("y")
    @DataProvider(name = "DataFiltered")
    public Object[][] dataProviderFiltered(Method m){
        List<HashMap<String,String>> hashMapList =
                ExcelReader.excelReader("Data");

        List<Object> endResult= new ArrayList<>();

        for(HashMap<String,String> hashMaps: hashMapList){
            if (m.getName().startsWith(hashMaps.get("expected")) && hashMaps.get("execute").equalsIgnoreCase("yes")) {
                endResult.add(hashMaps);
            }
        }

        System.out.println("end result size = " + endResult.size());
        Object[][] combinedData = new Object[endResult.size()][2];

        //data from fixture
        //List<BajaAlumnosPOJO> fixtureData = Fixture.from(BajaAlumnosPOJO.class).gimme(2, "invalid");   //Data coming from Fixture
        List<BajaAlumnosPOJO> fixtureData = XSLXFileReader.returnDataExcel(); //Data coming from External File


        System.out.println(fixtureData);
        for (int i = 0; i < endResult.size(); i++) {
            combinedData[i][0] = endResult.get(i); // First parameter: existing data
            combinedData[i][1] = fixtureData.get(i % fixtureData.size()); // Second parameter: fixture data
        }

        return combinedData;
    }


   /* @DataProvider(name = "DataFiltered")
    public Object[] dataProviderFiltered(Method m){
        List<HashMap<String,String>> hashMapList =
                ExcelReader.excelReader("Data");

        List<Object> endResult= new ArrayList<>();

        for(HashMap<String,String> hashMaps: hashMapList){
            if (m.getName().startsWith(hashMaps.get("expected")) && hashMaps.get("execute").equalsIgnoreCase("yes")) {
                endResult.add(hashMaps);
            }
        }

        return endResult.toArray();
    }*/
}
