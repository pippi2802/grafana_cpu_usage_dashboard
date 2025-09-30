package custompanel;

import com.grafana.foundation.cog.Builder;
import com.grafana.foundation.cog.variants.Dataquery;
import com.grafana.foundation.dashboard.Panel;

import java.util.ArrayList;

public class CpuPanelBuilder implements Builder<Panel> {
    private final Panel internal;

    public CpuPanelBuilder() {
        this.internal = new Panel();
        this.internal.type = "timeseries";
        this.internal.targets = new ArrayList<>();
    }

    public CpuPanelBuilder title(String title) {
        this.internal.title = title;
        return this;
    }

    public CpuPanelBuilder withTarget(Builder<Dataquery> target) {
        this.internal.targets.add(target.build());
        return this;
    }

    public CpuPanelBuilder highlightMax() {
        if (this.internal.options == null) {
            this.internal.options = new CpuPanelOptions();
        }

        CpuPanelOptions options = (CpuPanelOptions) this.internal.options;
        options.setHighlightMax(true);

        this.internal.options = options;
        return this;
    }

    @Override
    public Panel build() {
        return internal;
    }
}