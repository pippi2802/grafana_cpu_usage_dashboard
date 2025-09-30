package customquery;

import com.grafana.foundation.cog.Builder;
import com.grafana.foundation.cog.variants.Dataquery;

public class CpuQueryBuilder implements Builder<Dataquery> {
    private final CpuQuery internal;

    public CpuQueryBuilder(String query) {
        this.internal = new CpuQuery();
        this.internal.query = query;
    }

    public CpuQueryBuilder refId(String refId) {
        this.internal.refId = refId;
        return this;
    }

    public CpuQueryBuilder hide(Boolean hide) {
        this.internal.hide = hide;
        return this;
    }

    public CpuQueryBuilder datasource(String uid) {
        this.internal.datasource = new DatasourceRef("prometheus", uid);
        return this;
    }

    @Override
    public CpuQuery build() {
        return internal;
    }
}