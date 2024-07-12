package main.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties = new Properties();

    static { //we load the properties from config.properties once we load the class to memory
        try(InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties")){
            if(input == null){
                throw new IllegalStateException("no config.properties file");
            }
            properties.load(input);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String propertyKey){
        return properties.getProperty(propertyKey);
    }
}
