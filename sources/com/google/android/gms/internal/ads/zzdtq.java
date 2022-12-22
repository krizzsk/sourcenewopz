package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdtq implements zzesa<zzamo> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzgbl;
    private final zzdtr zzhuj;

    public zzdtq(zzdtr zzdtr, zzesn<Context> zzesn, zzesn<zzbar> zzesn2) {
        this.zzhuj = zzdtr;
        this.zzeyq = zzesn;
        this.zzgbl = zzesn2;
    }

    public final /* synthetic */ Object get() {
        return (zzamo) zzesg.zzbd(new zzamj().zzb(this.zzeyq.get(), this.zzgbl.get()));
    }
}
