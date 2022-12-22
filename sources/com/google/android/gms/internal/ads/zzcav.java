package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcav implements zzesa<zzbzl<zzp>> {
    private final zzesn<zzcbt> zzfvz;
    private final zzcak zzgdr;

    private zzcav(zzcak zzcak, zzesn<zzcbt> zzesn) {
        this.zzgdr = zzcak;
        this.zzfvz = zzesn;
    }

    public static zzcav zzd(zzcak zzcak, zzesn<zzcbt> zzesn) {
        return new zzcav(zzcak, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), zzbat.zzeki));
    }
}
