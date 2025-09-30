package custompanel;

import com.grafana.relocated.jackson.annotation.JsonProperty;

public class CpuPanelOptions {
    @JsonProperty("highlightMax")
    private Boolean highlightMax;

    /**
     * Set whether the panel should highlight the maximum data point.
     */
    public void setHighlightMax(Boolean highlightMax) {
        this.highlightMax = highlightMax;
    }
}