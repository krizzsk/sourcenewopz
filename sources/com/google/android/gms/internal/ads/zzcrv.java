package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrv implements zzesa<zzcrs> {
    private final zzesn<zzcrr> zzgtu;

    private zzcrv(zzesn<zzcrr> zzesn) {
        this.zzgtu = zzesn;
    }

    public static zzcrv zzag(zzesn<zzcrr> zzesn) {
        return new zzcrv(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzcrs(this.zzgtu.get());
    }
}
