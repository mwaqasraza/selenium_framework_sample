package config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
    private static Properties properties;
    static {
        try {
            Properties defaultProps = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            defaultProps.load(fis);
            String env = System.getProperty("env", defaultProps.getProperty("env"));
            properties = new Properties();
            properties.putAll(defaultProps);
            String envFilePath = "src/test/resources/config." + env + ".properties";
            FileInputStream envFis = new FileInputStream(envFilePath);
            properties.load(envFis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration files", e);
        }
    }
    public static String get(String key) { return properties.getProperty(key); }
}
