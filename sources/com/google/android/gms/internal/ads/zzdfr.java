package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfr implements zzesa<zzdfp> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzebs> zzhdg;
    private final zzesn<Set<String>> zzhdt;

    private zzdfr(zzesn<zzebs> zzesn, zzesn<Context> zzesn2, zzesn<Set<String>> zzesn3) {
        this.zzhdg = zzesn;
        this.zzeyq = zzesn2;
        this.zzhdt = zzesn3;
    }

    public static zzdfr zzaa(zzesn<zzebs> zzesn, zzesn<Context> zzesn2, zzesn<Set<String>> zzesn3) {
        return new zzdfr(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzdfp(this.zzhdg.get(), this.zzeyq.get(), this.zzhdt.get());
    }
}
