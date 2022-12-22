package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaby {
    public static boolean zza(zzach zzach, zzacf zzacf, String... strArr) {
        if (zzach == null || zzacf == null || !zzach.zzdcl || zzacf == null) {
            return false;
        }
        return zzach.zza(zzacf, zzr.zzlc().elapsedRealtime(), strArr);
    }

    public static zzacf zzb(zzach zzach) {
        if (zzach == null) {
            return null;
        }
        return zzach.zzex(zzr.zzlc().elapsedRealtime());
    }
}
