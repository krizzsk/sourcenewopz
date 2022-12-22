package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbko implements zzesa<zzbkp> {
    private final zzesn<zzf> zzeck;

    private zzbko(zzesn<zzf> zzesn) {
        this.zzeck = zzesn;
    }

    public static zzbko zza(zzesn<zzf> zzesn) {
        return new zzbko(zzesn);
    }

    public final /* synthetic */ Object get() {
        return new zzbkp(this.zzeck.get());
    }
}
