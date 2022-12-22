package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzekt {
    private static final ThreadLocal<SecureRandom> zzioc = new zzeks();

    /* access modifiers changed from: private */
    public static SecureRandom zzbgs() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzgb(int i) {
        byte[] bArr = new byte[i];
        zzioc.get().nextBytes(bArr);
        return bArr;
    }
}
