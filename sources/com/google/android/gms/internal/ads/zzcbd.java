package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcbd implements zzesa<zzbzl<zzbwy>> {
    private final zzesn<Executor> zzeyl;
    private final zzcak zzgdr;

    private zzcbd(zzcak zzcak, zzesn<Executor> zzesn) {
        this.zzgdr = zzcak;
        this.zzeyl = zzesn;
    }

    public static zzcbd zzf(zzcak zzcak, zzesn<Executor> zzesn) {
        return new zzcbd(zzcak, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(this.zzgdr.zzb(this.zzeyl.get()));
    }
}
