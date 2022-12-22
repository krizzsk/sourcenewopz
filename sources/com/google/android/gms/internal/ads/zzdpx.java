package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdpx implements zzesa<zzdpu> {
    private final zzesn<zzdup> zzfab;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdoy> zzgmb;

    private zzdpx(zzesn<zzcsh> zzesn, zzesn<zzdup> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzdoy> zzesn4) {
        this.zzglz = zzesn;
        this.zzfab = zzesn2;
        this.zzfxz = zzesn3;
        this.zzgmb = zzesn4;
    }

    public static zzdpx zzk(zzesn<zzcsh> zzesn, zzesn<zzdup> zzesn2, zzesn<zzdot> zzesn3, zzesn<zzdoy> zzesn4) {
        return new zzdpx(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        return new zzdpu(this.zzglz.get(), this.zzfab.get(), this.zzfxz.get(), this.zzgmb.get());
    }
}
