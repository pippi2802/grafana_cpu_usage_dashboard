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


    /**
     * Builds a timeseries dashboard with customizable parameters. (for this case for cpu_usage)
     *
     * @param dashboardTitle  Title of the dashboard (displayed in Grafana)
     * @param dashboardUid    Unique identifier for the dashboard
     * @param datasourceUid   UID of the Prometheus datasource to query
     * @param query           Prometheus query (e.g., "cpu_usage")
     * @param panelTitle      Title of the panel (displayed on the graph)
     * @param timeFrom        Start time range (e.g., "now-30m")
     * @param timeTo          End time range (e.g., "now")
     * @param refresh         Auto-refresh interval (e.g., "1m")
     * @return A {@link Dashboard} object that can be serialized to JSON and imported into Grafana
     */
    public static Dashboard buildCpuDashboard(
            String dashboardTitle,
            String dashboardUid,
            String datasourceUid,
            String datasourceName,
            String query,
            String refId,
            String panelTitle,
            String timeFrom,
            String timeTo,
            String refresh
    ) {
        return new DashboardBuilder(dashboardTitle)
                .uid(dashboardUid)
                .refresh(refresh)
                .time(new DashboardDashboardTimeBuilder()
                        .from(timeFrom)
                        .to(timeTo)
                )
                .timezone(Constants.TimeZoneBrowser)
                .withRow(new RowBuilder("CPU Metrics"))
                .withPanel(new CpuPanelBuilder()
                        .title(panelTitle)
                        .highlightMax()
                        .withTarget(
                                new CpuQueryBuilder(query)
                                        .refId(refId)
                                        .datasource(datasourceName, datasourceUid)
                        )
                )
                .build();
    }
}
