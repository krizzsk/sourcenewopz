package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdc implements Runnable {
    private zzdc() {
    }

    public final void run() {
        try {
            MessageDigest unused = zzda.zzny = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        } catch (NoSuchAlgorithmException unused2) {
        } finally {
            zzda.zzob.countDown();
        }
    }
}
