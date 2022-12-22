package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcyy implements zzesa<zzcyz> {
    private final zzesn<zzckb> zzgzb;

    private zzcyy(zzesn<zzckb> zzesn) {
        this.zzgzb = zzesn;
    }

    public static zzcyy zzai(zzesn<zzckb> zzesn) {
        return new zzcyy(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzcyz(this.zzgzb.get());
    }
}
