package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwp implements zzesa<zzcwm> {
    private final zzesn<zzcjw> zzezi;
    private final zzesn<zzcmb> zzfac;
    private final zzesn<zzdpz> zzfaq;
    private final zzesn<zzdtw> zzgma;

    private zzcwp(zzesn<zzdpz> zzesn, zzesn<zzcjw> zzesn2, zzesn<zzcmb> zzesn3, zzesn<zzdtw> zzesn4) {
        this.zzfaq = zzesn;
        this.zzezi = zzesn2;
        this.zzfac = zzesn3;
        this.zzgma = zzesn4;
    }

    public static zzcwp zze(zzesn<zzdpz> zzesn, zzesn<zzcjw> zzesn2, zzesn<zzcmb> zzesn3, zzesn<zzdtw> zzesn4) {
        return new zzcwp(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzcwm(this.zzfaq.get(), this.zzezi.get(), this.zzfac.get(), this.zzgma.get());
    }
}
