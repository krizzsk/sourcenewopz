package com.didichuxing.dfbasesdk.encrypt;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.AESUtils;
import com.didichuxing.dfbasesdk.utils.Base64Utils;
import com.didichuxing.dfbasesdk.utils.GZipUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.RSAUtils;
import com.didichuxing.security.safecollector.WsgSecInfo;
import javax.crypto.KeyGenerator;

public class Encrypter {
    public static final String DEFAULT_RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDiZdxEXDa2Fg9xwu16TL8jlr1l\nREeLokkHMrRw0e3rysHYO4rXMpfDHI+dEhzvipXaBfU+XrMPM3oOlYO61svYuInc\nplatu04on1JgciH4TQ0IHHayQEyptZnhisDg2prCBKCUT5+3nthgmQVzdq3pyxHP\nd7de9QT4vAm/xrDHZQIDAQAB";

    /* renamed from: a */
    private static final int f46577a = 128;

    public static class Input {
        public String plainText;
        public String rsaPublic;
    }

    public static class Output {
        public String cipherSecret;
        public String cipherText;
    }

    public static byte[] generateAesKey() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128);
            return instance.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String encryptAesKey(byte[] bArr) {
        try {
            return RSAUtils.encipher(bArr, DEFAULT_RSA_PUBLIC);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String encrypt(String str, byte[] bArr) {
        if (!(str == null || bArr == null || bArr.length <= 0)) {
            if (WsgSecInfo.isDebug()) {
                LogUtils.m33566e("encrypter", str);
            }
            try {
                return Base64Utils.encode(AESUtils.aesEncrypt(GZipUtils.compress(str.getBytes("UTF-8")), bArr));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null || bArr2.length <= 0)) {
            if (bArr.length <= 0) {
                return new byte[0];
            }
            try {
                return AESUtils.aesEncrypt(bArr, bArr2);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0081 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008d A[SYNTHETIC, Splitter:B:40:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094 A[SYNTHETIC, Splitter:B:44:0x0094] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File encrypt(java.io.File r9, byte[] r10) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x0097
            boolean r1 = r9.isFile()
            if (r1 == 0) goto L_0x0097
            if (r10 == 0) goto L_0x0097
            int r1 = r10.length
            if (r1 > 0) goto L_0x0010
            goto L_0x0097
        L_0x0010:
            java.io.File r1 = new java.io.File
            java.io.File r2 = r9.getParentFile()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r9.getName()
            r3.append(r4)
            java.lang.String r4 = ".ec"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3)
            r1.delete()     // Catch:{ all -> 0x0089 }
            boolean r2 = r1.createNewFile()     // Catch:{ all -> 0x0089 }
            if (r2 != 0) goto L_0x0038
            return r0
        L_0x0038:
            java.lang.String r2 = "AES/ECB/PKCS5Padding"
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ all -> 0x0089 }
            r3 = 1
            javax.crypto.spec.SecretKeySpec r4 = new javax.crypto.spec.SecretKeySpec     // Catch:{ all -> 0x0089 }
            java.lang.String r5 = "AES"
            r4.<init>(r10, r5)     // Catch:{ all -> 0x0089 }
            r2.init(r3, r4)     // Catch:{ all -> 0x0089 }
            int r10 = r2.getBlockSize()     // Catch:{ all -> 0x0089 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0089 }
            r3.<init>(r9)     // Catch:{ all -> 0x0089 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x0087 }
            r9.<init>(r1)     // Catch:{ all -> 0x0087 }
            r4 = 65536(0x10000, float:9.18355E-41)
            byte[] r5 = new byte[r4]     // Catch:{ all -> 0x0085 }
            int r4 = r4 + r10
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0085 }
            r6 = 0
            r7 = 0
        L_0x0060:
            int r8 = r3.read(r5)     // Catch:{ all -> 0x0085 }
            if (r8 <= 0) goto L_0x006e
            r2.doFinal(r5, r6, r8, r4)     // Catch:{ all -> 0x0085 }
            r9.write(r4, r6, r8)     // Catch:{ all -> 0x0085 }
            r7 = r8
            goto L_0x0060
        L_0x006e:
            if (r7 <= 0) goto L_0x007b
            int r2 = r7 % r10
            int r2 = r10 - r2
            if (r2 > 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r10 = r2
        L_0x0078:
            r9.write(r4, r7, r10)     // Catch:{ all -> 0x0085 }
        L_0x007b:
            r9.flush()     // Catch:{ all -> 0x0085 }
            r9.close()     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r3.close()     // Catch:{ all -> 0x0084 }
        L_0x0084:
            return r1
        L_0x0085:
            goto L_0x008b
        L_0x0087:
            r9 = r0
            goto L_0x008b
        L_0x0089:
            r9 = r0
            r3 = r9
        L_0x008b:
            if (r9 == 0) goto L_0x0092
            r9.close()     // Catch:{ all -> 0x0091 }
            goto L_0x0092
        L_0x0091:
        L_0x0092:
            if (r3 == 0) goto L_0x0097
            r3.close()     // Catch:{ all -> 0x0097 }
        L_0x0097:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.encrypt.Encrypter.encrypt(java.io.File, byte[]):java.io.File");
    }

    public static Output encrypt(Input input) throws Exception {
        if (!(input == null || input.plainText == null || !WsgSecInfo.isDebug())) {
            SystemUtils.log(6, "encrypter", input.plainText, (Throwable) null, "com.didichuxing.dfbasesdk.encrypt.Encrypter", 180);
        }
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128);
        byte[] encoded = instance.generateKey().getEncoded();
        String encode = Base64Utils.encode(AESUtils.aesEncrypt(GZipUtils.compress(input.plainText.getBytes("UTF-8")), encoded));
        Output output = new Output();
        output.cipherText = encode;
        output.cipherSecret = RSAUtils.encipher(encoded, input.rsaPublic);
        return output;
    }
}
