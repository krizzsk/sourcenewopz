package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchs implements zzesa<zzcht> {
    private final zzesn<String> zzgbj;
    private final zzesn<zzcdr> zzgff;
    private final zzesn<zzcdf> zzgld;

    private zzchs(zzesn<String> zzesn, zzesn<zzcdf> zzesn2, zzesn<zzcdr> zzesn3) {
        this.zzgbj = zzesn;
        this.zzgld = zzesn2;
        this.zzgff = zzesn3;
    }

    public static zzchs zzr(zzesn<String> zzesn, zzesn<zzcdf> zzesn2, zzesn<zzcdr> zzesn3) {
        return new zzchs(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        return new zzcht(this.zzgbj.get(), this.zzgld.get(), this.zzgff.get());
    }
}
