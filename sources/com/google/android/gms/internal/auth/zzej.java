package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzej {
    private static final zzeh<?> zza = new zzei();
    private static final zzeh<?> zzb;

    static {
        zzeh<?> zzeh;
        try {
            zzeh = (zzeh) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzeh = null;
        }
        zzb = zzeh;
    }

    static zzeh<?> zza() {
        zzeh<?> zzeh = zzb;
        if (zzeh != null) {
            return zzeh;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzeh<?> zzb() {
        return zza;
    }
}
