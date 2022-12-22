package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcbu implements zzesa<zzcbv> {
    private final zzesn<zzbts> zzgam;

    private zzcbu(zzesn<zzbts> zzesn) {
        this.zzgam = zzesn;
    }

    public static zzcbu zzx(zzesn<zzbts> zzesn) {
        return new zzcbu(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzcbv(this.zzgam.get());
    }
}
