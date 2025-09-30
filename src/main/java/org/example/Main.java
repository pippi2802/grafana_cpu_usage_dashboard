package org.example;

import com.grafana.foundation.cog.variants.Registry;
import com.grafana.foundation.dashboard.Dashboard;
import com.grafana.relocated.jackson.core.JsonProcessingException;
import config.ConfigLoader;
import customdashboard.CpuDashboard;
import customquery.CpuQuery;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        // Register custom query
        Registry.registerDataquery("cpu-query", CpuQuery.class);

        // Read datasource UID from config
        String prometheusUid = ConfigLoader.getPrometheusUid();

        // Build the dashboard with parameters
        Dashboard dashboard = CpuDashboard.buildCpuDashboard(
                "CPU Usage Dashboard",          // dashboard title
                "cpu-usage-java",               // dashboard uid
                prometheusUid,                  // datasource uid
                "prometheus",                   // datasource name
                "cpu_usage",                    // query
                "A",                            // refId for target
                "CPU Usage %",                  // panel title
                "now-30m",                      // time from
                "now",                          // time to
                "1m"                            // refresh interval
        );

        // Convert dashboard to JSON
        String json = dashboard.toJSON();

        // Save JSON to file
        try {
            Path outputPath = Paths.get("generated_dashboards/cpu-dashboard.json");
            Files.createDirectories(outputPath.getParent());
            Files.writeString(outputPath, json);
            System.out.println("Dashboard JSON saved to: " + outputPath.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

