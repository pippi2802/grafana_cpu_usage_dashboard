package customquery;

import com.grafana.foundation.cog.variants.Dataquery;
import com.grafana.relocated.jackson.annotation.JsonProperty;

public class CpuQuery implements Dataquery {
    @JsonProperty("refId")
    public String refId;

    @JsonProperty("hide")
    public Boolean hide;

    @JsonProperty("query")
    public String query;

    @JsonProperty("datasource")
    public DatasourceRef datasource;

    @Override
    public String dataqueryName() {
        return "cpu-query";
    }
}