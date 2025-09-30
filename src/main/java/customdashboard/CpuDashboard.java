package customdashboard;
import com.grafana.foundation.dashboard.Dashboard;
import com.grafana.foundation.dashboard.DashboardBuilder;

import com.grafana.foundation.dashboard.RowBuilder;
import com.grafana.foundation.common.Constants;
import com.grafana.foundation.dashboard.DashboardDashboardTimeBuilder;

import config.ConfigLoader;
import custompanel.CpuPanelBuilder;
import customquery.CpuQueryBuilder;

import java.io.ObjectInputFilter;


public class CpuDashboard {
    static String prometheusUid = ConfigLoader.getPrometheusUid();

    public static Dashboard buildCpuDashboard() {
        return new DashboardBuilder("CPU Usage Dashboard")
                .uid("cpu-usage-java")
                .refresh("1m")
                .time(new DashboardDashboardTimeBuilder()
                        .from("now-30m")
                        .to("now")
                )
                .timezone(Constants.TimeZoneBrowser)
                .withRow(new RowBuilder("CPU Metrics"))
                .withPanel(new CpuPanelBuilder()
                        .title("CPU Usage %")
                        .highlightMax()
                        .withTarget(
                                new CpuQueryBuilder("cpu_usage")
                                        .datasource(prometheusUid)
                        )
                )
                .build();
    }
}
