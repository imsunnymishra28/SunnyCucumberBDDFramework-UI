package PageObject;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public Properties readConfig;

    public ConfigReader() throws Exception {
        readConfig = new Properties();

        // Load from classpath
        try (InputStream fis = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (fis == null) {
                throw new RuntimeException("config.properties not found in resources folder");
            }
            readConfig.load(fis);
        }
    }

    public String getBrowser() {
        String value = readConfig.getProperty("browser");
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("browser not specified in config file");
        }
    }

    }

