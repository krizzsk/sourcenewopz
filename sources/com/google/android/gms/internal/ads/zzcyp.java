package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcyp<AdT> implements zzesa<zzcyl<AdT>> {
    private final zzesn<zzebs> zzfxf;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzacm> zzgzr;
    private final zzesn<zzcym<AdT>> zzgzy;

    public zzcyp(zzesn<zzdtg> zzesn, zzesn<zzebs> zzesn2, zzesn<zzacm> zzesn3, zzesn<zzcym<AdT>> zzesn4) {
        this.zzfxq = zzesn;
        this.zzfxf = zzesn2;
        this.zzgzr = zzesn3;
        this.zzgzy = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzcyl(this.zzfxq.get(), this.zzfxf.get(), this.zzgzr.get(), this.zzgzy.get());
    }
}
