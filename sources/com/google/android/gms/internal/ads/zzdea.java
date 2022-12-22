package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdea implements zzesa<zzddy> {
    private final zzesn<zzdlr> zzgan;

    private zzdea(zzesn<zzdlr> zzesn) {
        this.zzgan = zzesn;
    }

    public static zzdea zzam(zzesn<zzdlr> zzesn) {
        return new zzdea(zzesn);
    }

    public static zzddy zzb(zzdlr zzdlr) {
        return new zzddy(zzdlr);
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzgan.get());
    }
}
