package src.test.java.ru.training.at.hw3.util;

import java.io.*;
import java.util.Properties;

public class PropertiesFileReader {

    public String getProperties(String name) {
        String propertiesPath = "src/test/resources/hw3.properties";
        String value = "";
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(propertiesPath)) {
            properties.load(inputStream);
            value = properties.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO error with properties file");
        }
        return value;
    }
}
