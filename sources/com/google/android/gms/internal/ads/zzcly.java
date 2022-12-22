package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcly implements zzesa<zzclz> {
    private final zzesn<zzcmg> zzezo;
    private final zzesn<zzbac> zzfby;

    private zzcly(zzesn<zzcmg> zzesn, zzesn<zzbac> zzesn2) {
        this.zzezo = zzesn;
        this.zzfby = zzesn2;
    }

    public static zzcly zzag(zzesn<zzcmg> zzesn, zzesn<zzbac> zzesn2) {
        return new zzcly(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzclz(this.zzezo.get(), this.zzfby.get());
    }
}
