package org.resources;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.util.StringUtil;
import org.enums.Configurations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


//--> Use getResourceAsStream() for internal resources (bundled with your application) as it's portable and simplifies deployment.
//Properties properties = new Properties();
//properties.load(MyClass.class.getClassLoader().getResourceAsStream("config.properties"));
//properties file must be in the route src/main/resources if using maven or gradle
//Files in src/main/resources are automatically included in the runtime classpath without additional configuration.


//--> Use FileReader: For external, user-editable configuration files.
public class PropertiesReader {
    static Properties prop = new Properties();

    static {
        try (FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/test/java/org/resources/Configurations.properties")) {
            prop.load(fr);
           // prop.load(PropertiesReader.class.getClassLoader().getResourceAsStream("Configurations.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config properties file", e);
        }
    }


    public static String returnKey(Configurations config) {
        if (config == null) {
            throw new RuntimeException("Configuration cannot be null");
        }
        String key = config.toString().toLowerCase();
        if (StringUtil.isBlank(key)) {
            throw new RuntimeException("Value is blank for the key provided");
        }
        String valueToReturn = prop.getProperty(key);
        if (valueToReturn == null) {
            throw new RuntimeException("Key '" + key + "' is not present properties files");
        }
        return valueToReturn;
    }

    public static String getProperty(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }


}
