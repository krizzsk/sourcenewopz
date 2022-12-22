package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchl implements zzesa<zzchg> {
    private final zzesn<zzcdr> zzgff;
    private final zzesn<zzcdf> zzgld;

    private zzchl(zzesn<zzcdf> zzesn, zzesn<zzcdr> zzesn2) {
        this.zzgld = zzesn;
        this.zzgff = zzesn2;
    }

    public static zzchl zzv(zzesn<zzcdf> zzesn, zzesn<zzcdr> zzesn2) {
        return new zzchl(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzchg(this.zzgld.get(), this.zzgff.get());
    }
}
