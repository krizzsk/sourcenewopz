package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbri implements zzesa<zzbzl<zzp>> {
    private final zzesn<zzbpz> zzfvz;
    private final zzbra zzgad;

    private zzbri(zzbra zzbra, zzesn<zzbpz> zzesn) {
        this.zzgad = zzbra;
        this.zzfvz = zzesn;
    }

    public static zzbri zza(zzbra zzbra, zzesn<zzbpz> zzesn) {
        return new zzbri(zzbra, zzesn);
    }

    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), zzbat.zzekj));
    }
}
