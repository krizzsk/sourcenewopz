package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzad;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzbrv implements zzdxw {
    private final Context zzdbt;
    private final zzbar zzfxh;
    private final zzdpm zzgaf;

    zzbrv(Context context, zzbar zzbar, zzdpm zzdpm) {
        this.zzdbt = context;
        this.zzfxh = zzbar;
        this.zzgaf = zzdpm;
    }

    public final Object apply(Object obj) {
        Context context = this.zzdbt;
        zzbar zzbar = this.zzfxh;
        zzdpm zzdpm = this.zzgaf;
        zzdot zzdot = (zzdot) obj;
        zzad zzad = new zzad(context);
        zzad.zzeo(zzdot.zzdxn);
        zzad.zzep(zzdot.zzhmm.toString());
        zzad.zzu(zzbar.zzbrz);
        zzad.setAdUnitId(zzdpm.zzhny);
        return zzad;
    }
}
