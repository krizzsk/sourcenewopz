package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzfw {
    private static final zzfv zza;
    private static final zzfv zzb = new zzfv();

    static {
        zzfv zzfv;
        try {
            zzfv = (zzfv) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzfv = null;
        }
        zza = zzfv;
    }

    static zzfv zza() {
        return zza;
    }

    static zzfv zzb() {
        return zzb;
    }
}
