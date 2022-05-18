package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    static Properties property;

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            property = new Properties();
            property.load(fis);
        } catch (IOException e) {
            System.err.println("Properties file does not exist");
        }
    }

    public static String getUrl() {
        String URL = property.getProperty("URL");
        return URL;
    }

    public static String getDriverName() {
        String driverName = property.getProperty("CHROME_DRIVER_NAME");
        return driverName;
    }

    public static String getDriverLocation() {
        String driverLocation = property.getProperty("CHROME_DRIVER_LOCATION");
        return driverLocation;
    }

    public static int getImplicityWaitValue() {
        int value = Integer.parseInt(property.getProperty("IMPLICITLY_WAIT_VALUE"));
        return value;
    }

    public static int getExplicityWaitValue() {
        int value = Integer.parseInt(property.getProperty("EXPLICITLY_WAIT_VALUE"));
        return value;
    }
}
