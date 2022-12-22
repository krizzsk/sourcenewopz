package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcro implements zzesa<zzcrp> {
    private final zzesn<zzf> zzecf;
    private final zzesn<zzcru> zzgtd;

    private zzcro(zzesn<zzcru> zzesn, zzesn<zzf> zzesn2) {
        this.zzgtd = zzesn;
        this.zzecf = zzesn2;
    }

    public static zzcro zzar(zzesn<zzcru> zzesn, zzesn<zzf> zzesn2) {
        return new zzcro(zzesn, zzesn2);
    }

    public final /* synthetic */ Object get() {
        return new zzcrp(this.zzgtd.get(), this.zzecf.get());
    }
}
