package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdae implements zzesa<zzczm> {
    private final zzesn<zzdtw> zzgma;

    private zzdae(zzesn<zzdtw> zzesn) {
        this.zzgma = zzesn;
    }

    public static zzdae zzaj(zzesn<zzdtw> zzesn) {
        return new zzdae(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzczm(this.zzgma.get());
    }
}
