package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzrw {
    private static MessageDigest zzbum;
    protected Object mLock = new Object();

    /* access modifiers changed from: package-private */
    public abstract byte[] zzbp(String str);

    /* access modifiers changed from: protected */
    public final MessageDigest zzmt() {
        synchronized (this.mLock) {
            if (zzbum != null) {
                MessageDigest messageDigest = zzbum;
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbum = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            MessageDigest messageDigest2 = zzbum;
            return messageDigest2;
        }
    }
}
