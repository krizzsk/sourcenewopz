package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzfm {
    private static final zzfl zza;
    private static final zzfl zzb = new zzfl();

    static {
        zzfl zzfl;
        try {
            zzfl = (zzfl) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzfl = null;
        }
        zza = zzfl;
    }

    static zzfl zza() {
        return zza;
    }

    static zzfl zzb() {
        return zzb;
    }
}
