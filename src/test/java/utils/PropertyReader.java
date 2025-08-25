package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Nie znaleziono pliku config.properties w resources!");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas ładowania pliku config.properties: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}