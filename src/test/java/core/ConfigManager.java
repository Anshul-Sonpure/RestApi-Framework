package core;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ConfigManager {
    private static final String CONFIG_NAME = "test-config";
    private static ResourceBundle bundle;

    private ConfigManager() {
    }

    public static void load() {
        try {
            bundle = ResourceBundle.getBundle(CONFIG_NAME);
        } catch (MissingResourceException e) {
            throw new RuntimeException(
                    "Unable to load test-config.properties from classpath", e);
        }
    }

    public static String getTestBaseUrl() {
        if (bundle == null) {
            throw new IllegalStateException(
                    "ConfigManager not initialized. Call load() first.");
        }
        return bundle.getString("test.base.url");
    }
}
