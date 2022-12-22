package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbck extends zzbcc {
    public final zzbbz zza(Context context, zzbcs zzbcs, int i, boolean z, zzach zzach, zzbcp zzbcp) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(applicationInfo == null || applicationInfo.targetSdkVersion >= 11)) {
            return null;
        }
        zzbcr zzbcr = new zzbcr(context, zzbcs.zzacc(), zzbcs.getRequestId(), zzach, zzbcs.zzabw());
        if (i == 2) {
            return new zzbcv(context, zzbcr, zzbcs, z, zzb(zzbcs), zzbcp);
        }
        return new zzbbq(context, zzbcs, z, zzb(zzbcs), zzbcp, new zzbcr(context, zzbcs.zzacc(), zzbcs.getRequestId(), zzach, zzbcs.zzabw()));
    }
}
