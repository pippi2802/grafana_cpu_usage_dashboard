package custompanel;

import com.grafana.foundation.cog.Builder;
import com.grafana.foundation.cog.variants.Dataquery;
import com.grafana.foundation.dashboard.Panel;

import java.util.ArrayList;

public class CpuPanelBuilder implements Builder<Panel> {
    private final Panel internal;

    /**
     * Creates a new CPU panel builder with default type <b>timeseries</b>.
     * Initializes the target list for queries.
     */
    public CpuPanelBuilder() {
        this.internal = new Panel();
        this.internal.type = "timeseries";
        this.internal.targets = new ArrayList<>();
    }

    /**
     * Set the title for the panel.
     *
     * @param title Panel title
     */
    public CpuPanelBuilder title(String title) {
        this.internal.title = title;
        return this;
    }

    /**
     * Add query target to the panel.
     *
     * @param target Query builder (e.g., Prometheus query)
     */
    public CpuPanelBuilder withTarget(Builder<Dataquery> target) {
        this.internal.targets.add(target.build());
        return this;
    }

    /**
     * Enable highlighting of the maximum value in the panel visualization.
     */
    public CpuPanelBuilder highlightMax() {
        if (this.internal.options == null) {
            this.internal.options = new CpuPanelOptions();
        }

        CpuPanelOptions options = (CpuPanelOptions) this.internal.options;
        options.setHighlightMax(true);

        this.internal.options = options;
        return this;
    }
    /**
     * Build the final {@link Panel}.
     */
    @Override
    public Panel build() {
        return internal;
    }
}