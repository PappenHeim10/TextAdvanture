package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvLoader {

    public static String getApiKey() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("C:\\Users\\Cohen\\Documents\\Coding\\TextAdvanture\\util\\.env")) {
            properties.load(input);
            return properties.getProperty("GOOGLE_API_KEY");
        } catch (IOException e) {
            System.err.println("Fehler beim Laden der .env-Datei: " + e.getMessage());
            return null; // Oder eine andere Fehlerbehandlung
        }
    }
}