package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcaw implements zzesa<zzaya> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdpm> zzfxn;
    private final zzcak zzgdr;

    private zzcaw(zzcak zzcak, zzesn<Context> zzesn, zzesn<zzdpm> zzesn2) {
        this.zzgdr = zzcak;
        this.zzeyq = zzesn;
        this.zzfxn = zzesn2;
    }

    public static zzcaw zza(zzcak zzcak, zzesn<Context> zzesn, zzesn<zzdpm> zzesn2) {
        return new zzcaw(zzcak, zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return (zzaya) zzesg.zzbd(new zzaya(this.zzeyq.get(), this.zzfxn.get().zzhny));
    }
}
