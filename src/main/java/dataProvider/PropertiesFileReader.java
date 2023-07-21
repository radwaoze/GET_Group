package dataProvider;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader{

    public static Properties proObj;

    public static Properties readPropertiesFile(String configFilePath) {
        BufferedReader fileObj;
        try {
            fileObj = new BufferedReader(new FileReader(configFilePath));
            proObj = new Properties();
            proObj.load(fileObj);

        } catch (IOException e) {
            throw new RuntimeException("Config.properties not found at " + configFilePath);
        }
        return proObj;
    }}