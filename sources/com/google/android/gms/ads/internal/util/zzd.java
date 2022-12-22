package com.google.android.gms.ads.internal.util;

import com.didi.sdk.apm.SystemUtils;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.ads.zzadm;
import com.google.android.gms.internal.ads.zzbao;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzd extends zzbao {
    public static void zzed(String str) {
        if (zzyz()) {
            SystemUtils.log(2, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.ads.internal.util.zzd", 2);
        }
    }

    public static void zza(String str, Throwable th) {
        if (zzyz()) {
            SystemUtils.log(2, AdRequest.LOGTAG, str, th, "com.google.android.gms.ads.internal.util.zzd", 5);
        }
    }

    public static boolean zzyz() {
        return isLoggable(2) && zzadm.zzdfe.get().booleanValue();
    }
}
