package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    public static String getPrometheusUid() {
        Properties props = new Properties();

        // Load the properties file from resources
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in resources");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }

        // Get the Prometheus UID
        String prometheusUid = props.getProperty("prometheus.uid");
        if (prometheusUid == null || prometheusUid.isEmpty()) {
            throw new RuntimeException("prometheus.uid not set in config.properties");
        }
        return prometheusUid;
    }
}
