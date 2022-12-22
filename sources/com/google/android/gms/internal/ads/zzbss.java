package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbss implements zzesa<zzbsp> {
    private final zzesn<zzctc> zzfcq;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<String> zzgbj;

    private zzbss(zzesn<zzdot> zzesn, zzesn<String> zzesn2, zzesn<zzctc> zzesn3) {
        this.zzfxz = zzesn;
        this.zzgbj = zzesn2;
        this.zzfcq = zzesn3;
    }

    public static zzbss zzm(zzesn<zzdot> zzesn, zzesn<String> zzesn2, zzesn<zzctc> zzesn3) {
        return new zzbss(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzbsp(this.zzfxz.get(), this.zzgbj.get(), this.zzfcq.get());
    }
}
