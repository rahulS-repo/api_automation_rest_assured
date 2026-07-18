package configs;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            InputStream input = Files.newInputStream(Path.of("src/test/resources/dev.properties"));
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + e.getMessage(), e);
        }
    }

    public ConfigReader() {
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
