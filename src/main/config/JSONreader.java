package main.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONreader {
    public static final String basicConfig = "src\\main\\resources\\config.json";
    public static final String apiConfig = "src\\test\\resources\\configApi.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readConfig(String filePath) throws IOException {
        File jsonFile = new File(filePath);
        if (!jsonFile.exists()) {
            throw new IOException("File not found: " + jsonFile.getAbsolutePath());
        }
        try {
            JsonNode rootNode = objectMapper.readTree(jsonFile);
            return rootNode;
        }catch (IOException e){
            throw new IOException("parsing failed " + jsonFile.getAbsolutePath(), e);
        }
    }
}