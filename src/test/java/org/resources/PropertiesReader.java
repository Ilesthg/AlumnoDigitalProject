package org.resources;

import org.apache.poi.util.StringUtil;
import org.enums.Configurations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesReader {
    static Properties prop = new Properties();

    static {

        try (FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/java/org/resources/Configurations.properties")) {
            prop.load(fr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static String returnKey(Configurations config) {
        String key = config.toString().toLowerCase();
        String valueToReturn = prop.getProperty(key);

        if (key == null || StringUtil.isBlank(key) || valueToReturn == null) {
            throw new RuntimeException("VALUE IS NOT SPECIFIED FOR THE KEY" + key + "in properties files");
        }
        return valueToReturn;
    }

}
