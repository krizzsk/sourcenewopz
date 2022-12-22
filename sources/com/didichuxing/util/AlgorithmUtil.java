package com.didichuxing.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public final class AlgorithmUtil {
    public static final String md5(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            throw new IllegalArgumentException("empty data");
        }
        try {
            return toHexString(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static final String md5(String str) {
        if (str != null) {
            try {
                return toHexString(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes()));
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("null string");
        }
    }

    public static final String sha1(String str) {
        if (str != null) {
            try {
                return toHexString(MessageDigest.getInstance("SHA-1").digest(str.getBytes()));
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("null string");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:17|(2:21|22)|23|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e A[SYNTHETIC, Splitter:B:21:0x003e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0041=Splitter:B:23:0x0041, B:14:0x0027=Splitter:B:14:0x0027} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String md5(java.io.File r5) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0043
            boolean r0 = r5.exists()
            if (r0 == 0) goto L_0x0043
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0042 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x003a }
            r3.<init>(r5)     // Catch:{ all -> 0x003a }
        L_0x0018:
            int r5 = r3.read(r0)     // Catch:{ all -> 0x0038 }
            r4 = -1
            if (r5 == r4) goto L_0x0024
            r4 = 0
            r2.update(r0, r4, r5)     // Catch:{ all -> 0x0038 }
            goto L_0x0018
        L_0x0024:
            r3.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            java.math.BigInteger r5 = new java.math.BigInteger     // Catch:{ NoSuchAlgorithmException -> 0x0042 }
            r0 = 1
            byte[] r2 = r2.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0042 }
            r5.<init>(r0, r2)     // Catch:{ NoSuchAlgorithmException -> 0x0042 }
            r0 = 16
            java.lang.String r5 = r5.toString(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0042 }
            return r5
        L_0x0038:
            r5 = move-exception
            goto L_0x003c
        L_0x003a:
            r5 = move-exception
            r3 = r1
        L_0x003c:
            if (r3 == 0) goto L_0x0041
            r3.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            throw r5     // Catch:{ NoSuchAlgorithmException -> 0x0042 }
        L_0x0042:
            return r1
        L_0x0043:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "file is unavailable"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.util.AlgorithmUtil.md5(java.io.File):java.lang.String");
    }

    public static String toHexString(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return sb.toString();
    }

    private AlgorithmUtil() {
    }
}
