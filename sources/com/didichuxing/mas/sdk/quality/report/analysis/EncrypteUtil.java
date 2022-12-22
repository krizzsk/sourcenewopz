package com.didichuxing.mas.sdk.quality.report.analysis;

import android.text.TextUtils;
import android.util.Base64;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncrypteUtil {
    public static String KEY = "";
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTEC/rjRUW+STDe3PbGD9n6Aet/EOpCeLohlEp+aeS8JvoL8I4AU4uWZnuVumSccIdLKB/CzutW4kZQVw7GyV5soHZrigJf1YWbaQYUf+FEo+MtzMaYuUqBfc7cM/4GDpmcJfJLUCUWDjs1jSkv5iG0YYpT1OHspKsx6ZG0CopgwIDAQAB";
    private static Cipher mEncryptCipher;

    public static String encryptionByPublicKey(String str) {
        PublicKey publicKey = getPublicKey();
        if (publicKey == null) {
            return "";
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
            instance.init(1, publicKey);
            instance.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(instance.doFinal(), 0);
        } catch (Exception e) {
            OLog.m34419e("encryptionByPublicKey exception", e);
            return "";
        }
    }

    private static PublicKey getPublicKey() {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(PUBLIC_KEY, 0)));
        } catch (Exception e) {
            OLog.m34419e("getPublicKey exception", e);
            return null;
        }
    }

    private static Key getKey(byte[] bArr) throws Exception {
        byte[] bArr2 = new byte[8];
        int i = 0;
        while (i < bArr.length && i < 8) {
            bArr2[i] = bArr[i];
            i++;
        }
        return new SecretKeySpec(bArr2, "DES");
    }

    public static String encrypt(String str) {
        try {
            return byte2HexStr(encrypt(str.getBytes()));
        } catch (Exception e) {
            OLog.m34419e("encrypt Exception ", e);
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr) throws Exception {
        mEncryptCipher = Cipher.getInstance("DES");
        generatorKey();
        mEncryptCipher.init(1, getKey(KEY.getBytes()));
        return mEncryptCipher.doFinal(bArr);
    }

    private static void generatorKey() {
        if (TextUtils.isEmpty(KEY)) {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < 8; i++) {
                sb.append(LETTERS.charAt(random.nextInt(62)));
            }
            KEY = sb.toString();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String byte2HexStr(byte[] r6) throws java.lang.Exception {
        /*
            int r0 = r6.length
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            int r2 = r0 * 2
            r1.<init>(r2)
            r2 = 0
        L_0x0009:
            if (r2 >= r0) goto L_0x0025
            byte r3 = r6[r2]
        L_0x000d:
            if (r3 >= 0) goto L_0x0012
            int r3 = r3 + 256
            goto L_0x000d
        L_0x0012:
            r4 = 16
            if (r3 >= r4) goto L_0x001b
            java.lang.String r5 = "0"
            r1.append(r5)
        L_0x001b:
            java.lang.String r3 = java.lang.Integer.toString(r3, r4)
            r1.append(r3)
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0025:
            java.lang.String r6 = r1.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.analysis.EncrypteUtil.byte2HexStr(byte[]):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043 A[SYNTHETIC, Splitter:B:21:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050 A[SYNTHETIC, Splitter:B:27:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String compress(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0059
            int r0 = r2.length()
            if (r0 != 0) goto L_0x0009
            goto L_0x0059
        L_0x0009:
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0038 }
            r1.<init>()     // Catch:{ IOException -> 0x0038 }
            java.util.zip.GZIPOutputStream r0 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            byte[] r2 = r2.getBytes()     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r0.write(r2)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r0.close()     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            byte[] r2 = r1.toByteArray()     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r0 = 0
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r0)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x004d
        L_0x002b:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x004d
        L_0x0030:
            r2 = move-exception
            r0 = r1
            goto L_0x004e
        L_0x0033:
            r2 = move-exception
            r0 = r1
            goto L_0x0039
        L_0x0036:
            r2 = move-exception
            goto L_0x004e
        L_0x0038:
            r2 = move-exception
        L_0x0039:
            r2.printStackTrace()     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = "compress exception"
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34419e(r1, r2)     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x004b
            r0.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r2 = move-exception
            r2.printStackTrace()
        L_0x004b:
            java.lang.String r2 = ""
        L_0x004d:
            return r2
        L_0x004e:
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0058:
            throw r2
        L_0x0059:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.analysis.EncrypteUtil.compress(java.lang.String):java.lang.String");
    }

    public static String getDesKey() {
        try {
            return encryptionByPublicKey(KEY);
        } catch (Exception e) {
            e.printStackTrace();
            OLog.m34419e("getDesKey exception", e);
            return "";
        }
    }
}
