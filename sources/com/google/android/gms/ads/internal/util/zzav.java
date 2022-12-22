package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzav {
    /* access modifiers changed from: private */
    public final List<String> zzehy = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzehz = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzeia = new ArrayList();

    public final zzav zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zzehy.size()) {
            double doubleValue = this.zzeia.get(i).doubleValue();
            double doubleValue2 = this.zzehz.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzehy.add(i, str);
        this.zzeia.add(i, Double.valueOf(d));
        this.zzehz.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzau zzaah() {
        return new zzau(this);
    }
}
