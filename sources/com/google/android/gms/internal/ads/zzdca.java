package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdca implements zzear<zzauj, zzdcb> {
    private Executor executor;
    private zzcon zzhcz;

    public zzdca(Executor executor2, zzcon zzcon) {
        this.executor = executor2;
        this.zzhcz = zzcon;
    }

    public final /* synthetic */ zzebt zzf(Object obj) throws Exception {
        zzauj zzauj = (zzauj) obj;
        return zzebh.zzb(this.zzhcz.zzg(zzauj), new zzdbz(zzauj), this.executor);
    }
}
