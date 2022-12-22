package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbzs implements zzesa<zzbzt> {
    private final zzesn<zzdup> zzfab;
    private final zzesn<zzdot> zzfua;

    private zzbzs(zzesn<zzdot> zzesn, zzesn<zzdup> zzesn2) {
        this.zzfua = zzesn;
        this.zzfab = zzesn2;
    }

    public static zzbzs zzs(zzesn<zzdot> zzesn, zzesn<zzdup> zzesn2) {
        return new zzbzs(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzbzt(this.zzfua.get(), this.zzfab.get());
    }
}
