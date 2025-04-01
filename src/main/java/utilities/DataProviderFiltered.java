package utilities;

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
    }
}
