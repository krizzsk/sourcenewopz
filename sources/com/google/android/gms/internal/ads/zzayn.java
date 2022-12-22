package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzayd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzayn implements zzayd.zza {
    private final Context zzdbt;
    private final String zzdkl;

    zzayn(Context context, String str) {
        this.zzdbt = context;
        this.zzdkl = str;
    }

    public final void zza(zzbha zzbha) {
        Context context = this.zzdbt;
        zzbha.zzb(ObjectWrapper.wrap(context), this.zzdkl, context.getPackageName());
    }
}
