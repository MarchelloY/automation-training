package com.marchello.hotel.hunter.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class DataReader {
    private static String PATH_PROPERTIES_FILE = "src/test/resources/app.properties";

    public static String getData(String key) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(PATH_PROPERTIES_FILE);
        } catch (FileNotFoundException e) { e.printStackTrace(); }
        Properties properties = new Properties();
        try {
            properties.load(fis);
            Objects.requireNonNull(fis).close();
        } catch (IOException e) { e.printStackTrace(); }
        return properties.getProperty(key);
    }
}
