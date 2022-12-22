package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzcn<T> implements zzcp<T> {
    private zzct<T> zza;

    public final T zza() {
        zzct<T> zzct = this.zza;
        if (zzct != null) {
            return zzct.zza();
        }
        throw new IllegalStateException();
    }

    public static <T> void zza(zzct<T> zzct, zzct<T> zzct2) {
        zzcu.zza(zzct2);
        zzcn zzcn = (zzcn) zzct;
        if (zzcn.zza == null) {
            zzcn.zza = zzct2;
            return;
        }
        throw new IllegalStateException();
    }
}
