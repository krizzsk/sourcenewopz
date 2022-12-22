package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchn implements zzesa<zzchk> {
    private final zzesn<String> zzgbj;
    private final zzesn<zzcdr> zzgff;
    private final zzesn<zzcdf> zzgld;

    private zzchn(zzesn<String> zzesn, zzesn<zzcdf> zzesn2, zzesn<zzcdr> zzesn3) {
        this.zzgbj = zzesn;
        this.zzgld = zzesn2;
        this.zzgff = zzesn3;
    }

    public static zzchn zzp(zzesn<String> zzesn, zzesn<zzcdf> zzesn2, zzesn<zzcdr> zzesn3) {
        return new zzchn(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzchk(this.zzgbj.get(), this.zzgld.get(), this.zzgff.get());
    }
}
