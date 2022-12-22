package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzle {
    private static final zzld zza;
    private static final zzld zzb = new zzld();

    static {
        zzld zzld;
        try {
            zzld = (zzld) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzld = null;
        }
        zza = zzld;
    }

    static zzld zza() {
        return zza;
    }

    static zzld zzb() {
        return zzb;
    }
}
