package customquery;

import com.grafana.relocated.jackson.annotation.JsonProperty;

public class DatasourceRef {
    @JsonProperty("type")
    public String type;

    @JsonProperty("uid")
    public String uid;

    public DatasourceRef(String type, String uid) {
        this.type = type;
        this.uid = uid;
    }
}
