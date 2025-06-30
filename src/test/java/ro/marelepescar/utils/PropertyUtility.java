package ro.marelepescar.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
    private final Properties properties;

    public PropertyUtility(String fileName) {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/" + fileName + ".properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

