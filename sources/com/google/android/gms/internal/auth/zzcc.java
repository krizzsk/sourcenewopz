package com.google.android.gms.internal.auth;

import android.os.Build;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzcc {
    private static volatile boolean zza = (!zza());

    public static boolean zza() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
