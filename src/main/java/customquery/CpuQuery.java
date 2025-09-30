package customquery;

import com.grafana.foundation.cog.variants.Dataquery;
import com.grafana.relocated.jackson.annotation.JsonProperty;
/**
 * Represents a custom CPU query for Grafana dashboards.
 */
public class CpuQuery implements Dataquery {
    /** Reference ID for the query  */
    @JsonProperty("refId")
    public String refId;

    /** Hide query in Grafana */
    @JsonProperty("hide")
    public Boolean hide;

    /** Query string  */
    @JsonProperty("expr")
    public String expr;

    /** Datasource reference  */
    @JsonProperty("datasource")
    public DatasourceRef datasource;

    @Override
    public String dataqueryName() {
        return "cpu-query";
    }
}