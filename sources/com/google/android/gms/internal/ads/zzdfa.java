package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfa implements zzesa<zzdey> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzebs> zzhdg;
    private final zzesn<Set<String>> zzhdt;
    private final zzesn<ViewGroup> zzhfd;

    private zzdfa(zzesn<zzebs> zzesn, zzesn<ViewGroup> zzesn2, zzesn<Context> zzesn3, zzesn<Set<String>> zzesn4) {
        this.zzhdg = zzesn;
        this.zzhfd = zzesn2;
        this.zzeyq = zzesn3;
        this.zzhdt = zzesn4;
    }

    public static zzdfa zzj(zzesn<zzebs> zzesn, zzesn<ViewGroup> zzesn2, zzesn<Context> zzesn3, zzesn<Set<String>> zzesn4) {
        return new zzdfa(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzdey(this.zzhdg.get(), this.zzhfd.get(), this.zzeyq.get(), this.zzhdt.get());
    }
}
