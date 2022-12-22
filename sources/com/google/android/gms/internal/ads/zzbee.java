package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbee extends zzbl {
    static final zzbee zzero = new zzbee();

    zzbee() {
    }

    public final zzbs zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbu();
        }
        if ("mvhd".equals(str)) {
            return new zzbt();
        }
        return new zzbv(str);
    }
}
