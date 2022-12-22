package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcdc implements zzesa<zzcdd> {
    private final zzesn<zzcdr> zzgff;

    private zzcdc(zzesn<zzcdr> zzesn) {
        this.zzgff = zzesn;
    }

    public static zzcdc zzy(zzesn<zzcdr> zzesn) {
        return new zzcdc(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzcdd(this.zzgff.get());
    }
}
