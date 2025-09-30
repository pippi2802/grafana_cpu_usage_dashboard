package customquery;

import com.grafana.foundation.cog.Builder;
import com.grafana.foundation.cog.variants.Dataquery;
/**
 * Builder for creating {@link CpuQuery} objects.
 */
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

    public CpuQueryBuilder datasource(String datasource_name, String uid) {
        this.internal.datasource = new DatasourceRef(datasource_name, uid);
        return this;
    }

    @Override
    public CpuQuery build() {
        return internal;
    }
}