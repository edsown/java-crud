import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Credentials {
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream("config.properties");) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getJdbcUrl() {
        return properties.getProperty("JDBC_URL");
    }

    public static String getJdbcUser() {
        return properties.getProperty("JDBC_USER");
    }

    public static String getJdbcPassword() {
        return properties.getProperty("JDBC_PASSWORD");
    }
}
