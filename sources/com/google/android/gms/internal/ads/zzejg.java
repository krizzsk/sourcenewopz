package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzejg extends ThreadLocal<Cipher> {
    zzejg() {
    }

    private static Cipher zzbca() {
        try {
            return zzekd.zzinj.zzhx("AES/ECB/NOPADDING");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return zzbca();
    }
}
