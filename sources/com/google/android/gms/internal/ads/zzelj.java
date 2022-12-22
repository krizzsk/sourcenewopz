package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzelj {
    private static final Class<?> zziot = zzhy("libcore.io.Memory");
    private static final boolean zziou = (zzhy("org.robolectric.Robolectric") != null);

    static boolean zzbhb() {
        return zziot != null && !zziou;
    }

    static Class<?> zzbhc() {
        return zziot;
    }

    private static <T> Class<T> zzhy(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
