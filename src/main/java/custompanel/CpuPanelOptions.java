package custompanel;

import com.grafana.relocated.jackson.annotation.JsonProperty;

public class CpuPanelOptions {
    @JsonProperty("highlightMax")
    private Boolean highlightMax;

    public void setHighlightMax(Boolean highlightMax) {
        this.highlightMax = highlightMax;
    }
}