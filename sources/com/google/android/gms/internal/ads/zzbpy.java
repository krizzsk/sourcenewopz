package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbpy implements zzesa<zzbpz> {
    private final zzesn<zzbty> zzfio;

    private zzbpy(zzesn<zzbty> zzesn) {
        this.zzfio = zzesn;
    }

    public static zzbpy zze(zzesn<zzbty> zzesn) {
        return new zzbpy(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbpz(this.zzfio.get());
    }
}
