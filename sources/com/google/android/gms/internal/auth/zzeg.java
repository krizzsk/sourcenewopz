package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzeg {
    static final zzeg zza = new zzeg(true);
    private static volatile boolean zzb = false;
    private static volatile zzeg zzc;
    private final Map zzd;

    zzeg() {
        this.zzd = new HashMap();
    }

    public static zzeg zza() {
        zzeg zzeg = zzc;
        if (zzeg == null) {
            synchronized (zzeg.class) {
                zzeg = zzc;
                if (zzeg == null) {
                    zzeg = zza;
                    zzc = zzeg;
                }
            }
        }
        return zzeg;
    }

    zzeg(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
