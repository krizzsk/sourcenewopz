package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzers {
    public abstract void zzip(String str);

    public static zzers zzp(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzerp(cls.getSimpleName());
        }
        return new zzerr(cls.getSimpleName());
    }
}
