package utilities;

import fixtures.model.BajaAlumnosPOJO;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XSLXFileReader {

    @Test
    public static List<BajaAlumnosPOJO> returnDataExcel() {

        List<HashMap<String, String>> hashMapList = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/testData2.xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int totalRows = sheet.getLastRowNum();
            int totalColumns = sheet.getRow(0).getLastCellNum();


            for (int i = 1; i <= totalRows; i++) {
                HashMap<String, String> hm = new HashMap<>();

                for (int j = 0; j < totalColumns; j++) {
                    String key = sheet.getRow(0).getCell(j).toString();
                    String value = sheet.getRow(i).getCell(j).toString();

                    System.out.println("key = " + key);
                    System.out.println("value = " + value);
                    hm.put(key, value);

                }
                hashMapList.add(hm);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<BajaAlumnosPOJO> bajaAlumnosPOJOList = new ArrayList<>();
        for (HashMap hashMap : hashMapList) {
            BajaAlumnosPOJO bajaAlumnosPOJO=  BajaAlumnosPOJO.builder()
                    .primerApellido(String.valueOf(hashMap.get("Primer Apellido")))
                    .segundoApellido(String.valueOf(hashMap.get("Segundo Apellido")))
                    .curp(String.valueOf(hashMap.get("CURP")))
                    .nombre(String.valueOf(hashMap.get("Nombre")))
                    .build();
            bajaAlumnosPOJOList.add(bajaAlumnosPOJO);
        }
        System.out.println("bajaAlumnosPOJOList = " + bajaAlumnosPOJOList);
        return bajaAlumnosPOJOList;
    }
}
