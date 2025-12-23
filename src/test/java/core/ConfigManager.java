package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ConfigManager {
    private static final String CONFIG_NAME = "test-config";
    private static ResourceBundle bundle;
    private static final Logger log = LogManager.getLogger(ConfigManager.class);
    private ConfigManager() {
    }

    public static void load() {
        try {
            bundle = ResourceBundle.getBundle(CONFIG_NAME);
        } catch (MissingResourceException e) {
            log.info("Unable to load test-config.properties from classpath");
            throw new RuntimeException(
                    "Unable to load test-config.properties from classpath", e);

        }
    }

    public static String getTestBaseUrl() {
        if (bundle == null) {
            log.info("ConfigManager not initialized. Call load() first.");
            throw new IllegalStateException(
                    "ConfigManager not initialized. Call load() first.");
        }
        return bundle.getString("test.base.url");
    }
    public static String getEnv(String key) {

        return bundle.getString(key);
    }
}
