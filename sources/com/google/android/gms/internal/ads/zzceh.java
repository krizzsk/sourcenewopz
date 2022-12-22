package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzceh implements zzesa<zzaya> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdpm> zzfxn;
    private final zzced zzghs;

    private zzceh(zzced zzced, zzesn<Context> zzesn, zzesn<zzdpm> zzesn2) {
        this.zzghs = zzced;
        this.zzeyq = zzesn;
        this.zzfxn = zzesn2;
    }

    public static zzceh zza(zzced zzced, zzesn<Context> zzesn, zzesn<zzdpm> zzesn2) {
        return new zzceh(zzced, zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzaya) zzesg.zzbd(new zzaya(this.zzeyq.get(), this.zzfxn.get().zzhny));
    }
}
