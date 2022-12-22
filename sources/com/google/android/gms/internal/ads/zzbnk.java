package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbnk implements zzbuj {
    private final Context zzdbt;
    private final zzbar zzfxh;
    private final zzdot zzfxi;
    private final zzdpm zzfxj;

    zzbnk(Context context, zzbar zzbar, zzdot zzdot, zzdpm zzdpm) {
        this.zzdbt = context;
        this.zzfxh = zzbar;
        this.zzfxi = zzdot;
        this.zzfxj = zzdpm;
    }

    public final void onAdLoaded() {
        zzr.zzlf().zzb(this.zzdbt, this.zzfxh.zzbrz, this.zzfxi.zzhmm.toString(), this.zzfxj.zzhny);
    }
}
