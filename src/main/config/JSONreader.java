/*package main.config;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.InputStream;

public class JSONreader {
    private static final String JSON_FILE = "/config.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static customConfig readConfig() {
        try (InputStream input = JSONreader.class.getResourceAsStream(JSON_FILE)) {
            if (input == null) {
                throw new IllegalStateException("no config.json file");
            }
            return objectMapper.readValue(input, customConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getConfig(String jsonKey){
        return objectMapper.readConfig();
    }
}*/