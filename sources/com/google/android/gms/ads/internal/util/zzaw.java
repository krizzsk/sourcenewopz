package com.google.android.gms.ads.internal.util;

import com.didi.entrega.customer.app.constant.Const;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaw {
    public final int count;
    public final String name;
    private final double zzeib;
    private final double zzeic;
    public final double zzeid;

    public zzaw(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzeic = d;
        this.zzeib = d2;
        this.zzeid = d3;
        this.count = i;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.name).add("minBound", Double.valueOf(this.zzeic)).add("maxBound", Double.valueOf(this.zzeib)).add("percent", Double.valueOf(this.zzeid)).add(Const.PageParams.COUNT, Integer.valueOf(this.count)).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaw)) {
            return false;
        }
        zzaw zzaw = (zzaw) obj;
        if (Objects.equal(this.name, zzaw.name) && this.zzeib == zzaw.zzeib && this.zzeic == zzaw.zzeic && this.count == zzaw.count && Double.compare(this.zzeid, zzaw.zzeid) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzeib), Double.valueOf(this.zzeic), Double.valueOf(this.zzeid), Integer.valueOf(this.count));
    }
}
