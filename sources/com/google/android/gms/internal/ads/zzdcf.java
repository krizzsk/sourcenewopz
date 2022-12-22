package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcf implements zzesa<zzdcd> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<ViewGroup> zzgxx;
    private final zzesn<zzebs> zzhdg;

    public zzdcf(zzesn<zzebs> zzesn, zzesn<Context> zzesn2, zzesn<zzdpm> zzesn3, zzesn<ViewGroup> zzesn4) {
        this.zzhdg = zzesn;
        this.zzeyq = zzesn2;
        this.zzfxn = zzesn3;
        this.zzgxx = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzdcd(this.zzhdg.get(), this.zzeyq.get(), this.zzfxn.get(), this.zzgxx.get());
    }
}
