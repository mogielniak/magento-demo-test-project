package main.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONreader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readConfig() throws IOException {
        File jsonFile = new File("src\\main\\resources\\config.json");
        if (!jsonFile.exists()) {
            throw new IOException("File not found: " + jsonFile.getAbsolutePath());
        }
        JsonNode rootNode = objectMapper.readTree(jsonFile);
        System.out.println("Read JSON data: " + rootNode.toString());
        return rootNode;
    }
}