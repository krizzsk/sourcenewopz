package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeko implements zzefu {
    private final ThreadLocal<Mac> zzint = new zzekr(this);
    /* access modifiers changed from: private */
    public final String zzinu;
    /* access modifiers changed from: private */
    public final Key zzinv;
    private final int zzinw;

    public zzeko(String str, Key key) throws GeneralSecurityException {
        this.zzinu = str;
        this.zzinv = key;
        if (key.getEncoded().length >= 16) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1823053428:
                    if (str.equals("HMACSHA1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 392315118:
                    if (str.equals("HMACSHA256")) {
                        c = 1;
                        break;
                    }
                    break;
                case 392316170:
                    if (str.equals("HMACSHA384")) {
                        c = 2;
                        break;
                    }
                    break;
                case 392317873:
                    if (str.equals("HMACSHA512")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                this.zzinw = 20;
            } else if (c == 1) {
                this.zzinw = 32;
            } else if (c == 2) {
                this.zzinw = 48;
            } else if (c != 3) {
                String valueOf = String.valueOf(str);
                throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
            } else {
                this.zzinw = 64;
            }
            this.zzint.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    public final byte[] zzd(byte[] bArr, int i) throws GeneralSecurityException {
        if (i <= this.zzinw) {
            this.zzint.get().update(bArr);
            return Arrays.copyOf(this.zzint.get().doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
