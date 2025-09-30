package customquery;

import com.grafana.relocated.jackson.annotation.JsonProperty;

/**
 * Datasource definition for Grafana
 */
public class DatasourceRef {
    /** Type of the datasource*/
    @JsonProperty("type")
    public String type;

    /** Unique identifier of the datasource in Grafana. */
    @JsonProperty("uid")
    public String uid;

    public DatasourceRef(String type, String uid) {
        this.type = type;
        this.uid = uid;
    }
}
