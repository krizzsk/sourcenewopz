package com.google.android.gms.internal.ads;

import android.util.Base64;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcy {
    public static String zza(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    public static byte[] zzb(String str, boolean z) throws IllegalArgumentException {
        byte[] decode = Base64.decode(str, z ? 11 : 2);
        if (decode.length != 0 || str.length() <= 0) {
            return decode;
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Unable to decode ".concat(valueOf) : new String("Unable to decode "));
    }
}
