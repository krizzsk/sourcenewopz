package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzczj implements zzesa<zzczg> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzxc> zzhap;
    private final zzesn<zzbne> zzhaq;

    public zzczj(zzesn<Context> zzesn, zzesn<zzxc> zzesn2, zzesn<zzdpm> zzesn3, zzesn<zzbne> zzesn4) {
        this.zzeyq = zzesn;
        this.zzhap = zzesn2;
        this.zzfxn = zzesn3;
        this.zzhaq = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzczg(this.zzeyq.get(), this.zzhap.get(), this.zzfxn.get(), this.zzhaq.get());
    }
}
