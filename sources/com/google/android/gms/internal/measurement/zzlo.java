package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzlo {
    private static final zzln zza;
    private static final zzln zzb = new zzln();

    static {
        zzln zzln;
        try {
            zzln = (zzln) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzln = null;
        }
        zza = zzln;
    }

    static zzln zza() {
        return zza;
    }

    static zzln zzb() {
        return zzb;
    }
}
