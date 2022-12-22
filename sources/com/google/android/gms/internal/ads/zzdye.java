package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzdye {
    private static final Logger logger = Logger.getLogger(zzdye.class.getName());
    private static final zzdyf zzhza = new zza();

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    private static final class zza {
        private zza() {
        }
    }

    private zzdye() {
    }

    static String zzhn(@NullableDecl String str) {
        return str == null ? "" : str;
    }

    static boolean zzhm(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    static String emptyToNull(@NullableDecl String str) {
        if (zzhm(str)) {
            return null;
        }
        return str;
    }
}
