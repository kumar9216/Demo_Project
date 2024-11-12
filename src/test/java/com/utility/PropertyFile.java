package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
    public Properties properties;
    public void ConfigReaderMainMeter() {

        try {

            FileInputStream fileInput = new FileInputStream("./TestData/IrregularitiesMainMeter.property");

            properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ConfigReaderPoleMeter() {

        try {

            FileInputStream fileInput = new FileInputStream("./TestData/IrregularitiesPoleMeter.property");

            properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}