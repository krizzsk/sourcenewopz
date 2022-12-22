package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcqw implements zzesa<zzcqx> {
    private final zzesn<zzbac> zzfby;
    private final zzesn<zzdtw> zzgma;
    private final zzesn<zzdtx> zzgst;

    private zzcqw(zzesn<zzdtx> zzesn, zzesn<zzdtw> zzesn2, zzesn<zzbac> zzesn3) {
        this.zzgst = zzesn;
        this.zzgma = zzesn2;
        this.zzfby = zzesn3;
    }

    public static zzcqw zzy(zzesn<zzdtx> zzesn, zzesn<zzdtw> zzesn2, zzesn<zzbac> zzesn3) {
        return new zzcqw(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzcqx(this.zzgst.get(), this.zzgma.get(), this.zzfby.get());
    }
}
