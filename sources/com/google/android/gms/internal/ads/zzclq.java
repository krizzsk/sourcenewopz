package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzclq implements zzesa<zzclr> {
    private final zzesn<zzcmg> zzezo;
    private final zzesn<zzclz> zzfbz;

    private zzclq(zzesn<zzclz> zzesn, zzesn<zzcmg> zzesn2) {
        this.zzfbz = zzesn;
        this.zzezo = zzesn2;
    }

    public static zzclq zzaf(zzesn<zzclz> zzesn, zzesn<zzcmg> zzesn2) {
        return new zzclq(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzclr(this.zzfbz.get(), this.zzezo.get());
    }
}
